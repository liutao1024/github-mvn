package cn.spring.mvc.web.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
//import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.spring.mvc.comm.tools.MD5Tool;
import cn.spring.mvc.comm.util.CommUtil;
import cn.spring.mvc.web.entity.SysAuth;
import cn.spring.mvc.web.entity.SysAuthRole;
import cn.spring.mvc.web.entity.SysRole;
import cn.spring.mvc.web.entity.SysUser;
import cn.spring.mvc.web.entity.SysUserRole;
import cn.spring.mvc.web.entity.service.SysAuthRoleService;
import cn.spring.mvc.web.entity.service.SysAuthService;
import cn.spring.mvc.web.entity.service.SysRoleService;
import cn.spring.mvc.web.entity.service.SysUserRoleService;
import cn.spring.mvc.web.entity.service.SysUserService;
/**
 * @author LiuTao @date 2018年5月1日 上午11:59:41
 * @ClassName: SystemController 
 * @Description: 系统的Controller
 */
@Controller("SystemController")
@RequestMapping(value = "auth")
@ResponseBody
@SessionAttributes("SysUser")
public class SystemController {
	private static final Logger LOGGER = Logger.getLogger(SystemController.class);
	private static final String PASSWD = MD5Tool.md5EncryptString("123456");
	private static String AUTHTYPE = "2";//菜单权限类型
	private String[] strArray = {};//user用    有权限AuthCd数组
	@Autowired
	private SysUserRoleService sysUserRoleServiceImpl;
	@Autowired
	private SysAuthRoleService sysAuthRoleServiceImpl;
	@Autowired
	private SysAuthService sysAuthServiceImpl;
	@Autowired
	private SysUserService sysUserServiceImpl;
	@Autowired
	private SysRoleService sysRoleServiceImpl;
	//5.检查柜员信息
	/**
	 * @author LiuTao @date 2018年5月1日 下午1:35:12 
	 * @Title: getUserInfoController 
	 * @Description: TODO(前台获取session信息) 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/userInfo", method=RequestMethod.GET)
	public Map<String, Object> userInfoController(@ModelAttribute("SysUser") SysUser sysUser) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String userid = sysUser.getUserid();
		if (CommUtil.isNull(userid)) {
			resMap.put("ret", "error");
			resMap.put("msg", "您未登录,请登录");
			return resMap;
		}else {
			resMap.put("user", sysUser);
			resMap.put("ret", "success");
			resMap.put("msg", "成功");
		}
		return resMap;
	}
	
	//6.获取柜员菜单
	/**
	 * @author LiuTao @date 2018年5月7日 下午6:00:36 
	 * @Title: menuController 
	 * @Description: TODO(获取sysUser菜单权限) 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/menu")
	public Map<String, Object> menuController(@ModelAttribute("SysUser") SysUser sysUser) {
		
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setRegist_cd(sysUser.getRegistCd());
		sysUserRole.setAuth_type(AUTHTYPE);// 菜单权限为2
		sysUserRole.setUser_cd(sysUser.getUserid());
		/**得到柜员的角色      
		 * 一个柜员可能对应多个角色
		 */
		List<SysUserRole> sysUserRoleList = sysUserRoleServiceImpl.queryEntitiesByEntityParamMap(sysUserRole);
		List<SysAuthRole> sysAuthRoleList = new ArrayList<SysAuthRole>();
		SysAuthRole sysAuthRole = new SysAuthRole();
		for (SysUserRole theSysUserRole : sysUserRoleList) {
			/**通过角色来查询 角色权限
			 * 一个角色可能会有多个 权限
			 */
			sysAuthRole.setRegist_cd(theSysUserRole.getRegist_cd());
			sysAuthRole.setAuth_type(theSysUserRole.getAuth_type());
			sysAuthRole.setRole_cd(theSysUserRole.getRole_cd());
			sysAuthRoleList.addAll(sysAuthRoleServiceImpl.selectAllEntities(sysAuthRole));
		}
		//权限去重复
		HashSet<SysAuthRole> hashSet = new HashSet<SysAuthRole>(sysAuthRoleList);
		sysAuthRoleList.clear();
		sysAuthRoleList.addAll(hashSet);
		int k = 0;
		strArray = new String[sysAuthRoleList.size()];
		for (SysAuthRole theSysAuthRole : sysAuthRoleList) {
			strArray[k] = theSysAuthRole.getAuth_cd();//菜单编号
			k++;
		}
		// 查询所有菜单
		SysAuth sysAuth = new SysAuth();
		sysAuth.setRegist_cd(sysUser.getRegistCd());//机构好号
		sysAuth.setAuth_type(AUTHTYPE);// 2 为菜单权限
		sysAuth.setRank(1);//从第一级开始取
		List<SysAuth> sysAuthList = new ArrayList<SysAuth>();
		sysAuthList.addAll(sysAuthServiceImpl.selectAllEntities(sysAuth));		
		Map<String, Object> sysAuthMap = new HashMap<String, Object>();
		sysAuthMap.put("menu", reGetMenu(sysAuth, sysAuthList, sysAuth.getRank(), true));
		LOGGER.info("---------菜单" + sysAuthMap.toString());
		return sysAuthMap;//返回的菜单内容
	}
	
	//7.柜员退出
	/**
	 * @author LiuTao @date 2018年5月1日 上午11:52:54 
	 * @Title: loginOutController 
	 * @Description: TODO(Describe) 
	 * @param request
	 * @param model
	 * @param user
	 */
	@RequestMapping(value = "/logout")
	public void logoutController(HttpServletRequest request,Model model, @ModelAttribute("SysUser") SysUser sysUser) {
		String registCd = sysUser.getRegistCd();
		String userid = sysUser.getUserid();
		SysUser logoutSysUser = sysUserServiceImpl.selectOneByPrimeKey(registCd, userid);
		logoutSysUser.setUserst("0");
		sysUserServiceImpl.update(logoutSysUser);
		HttpSession session = request.getSession(false);  
		Enumeration<String> em = session.getAttributeNames();
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement().toString());
		}
		 session.removeAttribute("SysUser");
		 session.invalidate();//session无效处理
		 model.asMap().clear();//清除model中的对象
	}
	/**
	 * @author LiuTao @date 2018年5月7日 下午7:56:41 
	 * @Title: toDoListController 
	 * @Description: TODO(查询待办事件) 
	 * @param reqmap 查询条件输入
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/to-do-list")
	public Map<String, Object> toDoListController(@RequestParam Map<String, Object> reqmap, @ModelAttribute("SysUser") SysUser sysUser) {
		Map<String, Object> map = new HashMap<String, Object>();
		List <String> rolecdList  = new ArrayList<String>();
		
		map.putAll(reqmap);
		if (reqmap.get("q_subjtp") != null && reqmap.get("q_subjtp") != "") {
			map.put("subjtp", reqmap.get("q_subjtp"));
		}
		if (reqmap.get("q_emrgfg") != null && reqmap.get("q_emrgfg") != "") {
			map.put("emrgfg", reqmap.get("q_emrgfg"));
		}
		List<Map<String,String>> roleList = new ArrayList<Map<String,String>>();
		for(String s : rolecdList){
			Map<String,String> roleMap = new HashMap<String,String>();
			roleMap.put("recvrl", s);
			roleList.add(roleMap);
		}
	    map.put("roleList", roleList);
		map.put("userid", sysUser.getUserid()); // 设置操作柜员
		int length = Integer.parseInt(StringUtils.isNotEmpty((String) reqmap.get("length")) ? (String) reqmap.get("length") : "10", 10);
		int start = Integer.parseInt(StringUtils.isNotEmpty((String) reqmap.get("start")) ? (String) reqmap.get("start") : "1", 10);
		map.put("pageno", start / length + 1);// 当前页数
		map.put("pagesize", length); // 每页记录数
		Map<String, Object> resmap = new HashMap<String, Object>();
//		resmap = client.callClient("qrsubj", map);//需要查询待办事件表暂无
		resmap.put("retCode", "0000");
		if (resmap.get("retCode").toString().equals("0000")) {//空.toString报错了
			resmap.put("ret", "success");
			resmap.put("msg", "待办事项发送成功");
		} else {
			resmap.put("msg", resmap.get("retMsg").toString());
		}
		resmap.put("infos",resmap.get("infos") == null ? new ArrayList<Object>() : resmap.get("infos"));
		resmap.put("iTotalDisplayRecords", resmap.get("counts") == null ? "0" : resmap.get("counts"));
		resmap.put("iTotalRecords", resmap.get("counts") == null ? "0" : resmap.get("counts"));
		Map<String, Object> dmap = new HashMap<String, Object>();//
//		dmap = client.callClient("qdclam",map );
		dmap.put("wcouts", 0);
		resmap.put("wcouts",dmap.get("wcouts"));
		return resmap;
	}
	/**
	 * @author LiuTao @date 2018年5月29日 下午10:32:02 
	 * @Title: updatePasswd 
	 * @Description: TODO(Describe) 
	 * @param requestMap
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value = "/updatePasswd")
	public Map<String, Object> updatePasswdController(@RequestBody Map<String, Object> requestMap, @ModelAttribute("SysUser") SysUser sysUser){
		Map<String, Object> resMap = new HashMap<String, Object>();
		SysUser theSysUser = sysUserServiceImpl.selectOneByPrimeKey(sysUser.getRegistCd(), sysUser.getUserid());
		String oldPasswd = requestMap.get("passwd").toString();
		String newPasswd = requestMap.get("nwpswd").toString();
		if(CommUtil.equal(theSysUser.getPasswd(), MD5Tool.md5EncryptString(oldPasswd))){
			theSysUser.setPasswd(MD5Tool.md5EncryptString(newPasswd));
			try {
				sysUserServiceImpl.saveOrUpdate(theSysUser);
				resMap.put("ret", "success");
				resMap.put("msg", "密码修改成功");
			} catch (Throwable e) {
				resMap.put("msg", e.getMessage());
			}
		}else {
			resMap.put("msg", "密码修改失败,原密码不正确");
		}
		return resMap;
	}
	@RequestMapping(value = "/allUser")
	public Map<String, Object> showAllSysUser(@RequestParam Map<String, Object> resMap, @ModelAttribute("SysUser") SysUser sysUser){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		String hqlStr = "from SysUser where regist_cd = '"+ sysUser.getRegistCd()+"'";
		String appendStr = "";
		if (resMap.get("q_userid") != null && resMap.get("q_userid") != "") {
			appendStr = appendStr + " and userid = '" + resMap.get("q_userid") + "'";
		}
		if (resMap.get("q_userna") != null && resMap.get("q_userna") != "") {
			appendStr = appendStr + " and userna like '%" + resMap.get("q_userna") + "%'";
		}
		int page = Integer.parseInt((String) resMap.get("start"));
		int size = Integer.parseInt((String) resMap.get("length"));
		List<SysUser> sysUserList = sysUserServiceImpl.findAllByHqlPageSize(hqlStr+appendStr, page, size);
		List<SysUser> sysUserListCount = sysUserServiceImpl.findAllByHql(hqlStr+appendStr);
		rstMap.put("data", sysUserList);
		rstMap.put("iTotalDisplayRecords", sysUserListCount.size());
		rstMap.put("iTotalRecords", sysUserList.size());	
		return rstMap;
	}
	/**
	 * @author LiuTao @date 2018年6月6日 上午11:52:40 
	 * @Title: delUser 
	 * @Description: 注销柜员 
	 * @param user
	 * @param cuser
	 * @return
	 */
	@RequestMapping(value = "/allUser", method = { RequestMethod.DELETE })
	public Map<String, Object> delUser(@RequestBody SysUser user, @ModelAttribute("SysUser") SysUser cuser) {
		Map<String, Object> rstMap = new HashMap<String, Object>();
		SysUser offSysUser = sysUserServiceImpl.selectOneByPrimeKey(cuser.getRegistCd(), user.getUserid());
		offSysUser.setStatus("0");
		try {
			sysUserServiceImpl.saveOrUpdate(offSysUser);
			rstMap.put("ret", "success");
			rstMap.put("msg", "注销柜员成功");
		} catch (Exception e) {
			rstMap.put("msg", e.getMessage());
		}
		return rstMap;
	}
	/**
	 * @author LiuTao @date 2018年5月30日 下午9:31:28 
	 * @Title: showAllSysUserRole 
	 * @Description: TODO(Describe) 
	 * @param reqMap
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value = "/allUserRole")
	public Map<String, Object> showAllSysUserRole(@RequestParam Map<String, Object> reqMap, @ModelAttribute("SysUser") SysUser sysUser){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setRegist_cd(sysUser.getRegistCd());
		sysUserRole.setUser_cd(reqMap.get("user_cd").toString());
		int page = Integer.parseInt((String) reqMap.get("start"));
		int size = Integer.parseInt((String) reqMap.get("length"));
		Map<String, Object> listWithCount = sysUserRoleServiceImpl.findAllByEntityPageSizeWithCount(sysUserRole, page, size);
		try {
			rstMap = CommUtil.transSrcMapToWebMap(listWithCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rstMap;
	}
	/**
	 * @author LiuTao @date 2018年6月6日 下午2:49:16 
	 * @Title: delUserRole 
	 * @Description: 删除柜员角色
	 * @param sifSysRoleUser
	 * @return
	 */
	@RequestMapping(value = "/allUserRole", method = {RequestMethod.DELETE })
	@Transactional(propagation = Propagation.REQUIRED)
	public Map<String, String> delSysUserRole(@RequestBody SysUserRole sysUserRole) {
		Map<String, String> rstMap = new HashMap<String, String>();
		try {
			sysUserRoleServiceImpl.deleteEntity(sysUserRole);
			rstMap.put("ret", "success");
			rstMap.put("msg", sysUserRole.getUser_cd() + "删除成功");
		} catch (Exception e) {
			rstMap.put("ret", "error");
			rstMap.put("msg", sysUserRole.getUser_cd() + "删除失败");
		}
		return rstMap;

	}
	/**
	 * @author LiuTao @date 2018年6月6日 下午3:50:57 
	 * @Title: addUserRole 
	 * @Description: TODO(Describe) 
	 * @param sysUserRole
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value = "/addUserRole")
	@Transactional(propagation = Propagation.REQUIRED)
	public Map<String, String> addUserRole(@RequestBody SysUserRole sysUserRole,@ModelAttribute("SysUser") SysUser sysUser) {
		/**
		 * 保存roleUser
		 */
		Map<String, String> rstMap = new HashMap<String, String>();
		// 判断权限是否存在
		SysUserRole newSysUserRole = new SysUserRole();
		newSysUserRole.setAuth_type(sysUserRole.getAuth_type());
		newSysUserRole.setRegist_cd(sysUser.getRegistCd());
		newSysUserRole.setRole_cd(sysUserRole.getRole_cd());
		newSysUserRole.setUser_cd(sysUserRole.getUser_cd());
		SysUserRole userRole = sysUserRoleServiceImpl.selectOneEntity(newSysUserRole);
		if (CommUtil.isNotNull(userRole)) {
			rstMap.put("ret", "error");
			rstMap.put("msg", "角色已不存在,新增失败");
		}else {
			try {
				sysUserRoleServiceImpl.saveOrUpdate(newSysUserRole);
				rstMap.put("ret", "success");
				rstMap.put("msg", "角色新增成功");
			} catch (Exception e) {
				rstMap.put("ret", "error");
				rstMap.put("msg", "角色已存在,新增失败");
			}
		}
		return rstMap;
	}
	/**
	 * @author LiuTao @date 2018年6月5日 下午3:48:10 
	 * @Title: addUser 
	 * @Description: 新增柜员
	 * @param sysUserNew
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value = "/adduser")
	public Map<String, Object> addUser(@RequestBody SysUser sysUserNew, @ModelAttribute("SysUser") SysUser sysUser){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		sysUserNew.setRegistCd(sysUser.getRegistCd());
		sysUserNew.setPasswd(PASSWD);
		sysUserNew.setStatus("1");
		try {
			sysUserServiceImpl.add(sysUserNew);
			rstMap.put("ret", "success");
			rstMap.put("msg", "新增柜员成功");
		} catch (Throwable e) {
			rstMap.put("msg", e.getMessage());
		}
		return rstMap;
	}
	/**
	 * @author LiuTao @date 2018年6月5日 下午4:22:51 
	 * @Title: updateUser 
	 * @Description: 更新柜员信息
	 * @param sysUserUp
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value = "/upuser")
	public Map<String, Object> updateUser(@RequestBody SysUser sysUserUp, @ModelAttribute("SysUser") SysUser sysUser){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		SysUser newUser = sysUserServiceImpl.selectOneByPrimeKey(sysUser.getRegistCd(), sysUserUp.getUserid());
		newUser.setUserna(sysUserUp.getUserna());
		newUser.setBrchno(sysUserUp.getBrchno());
		newUser.setMaxert(sysUserUp.getMaxert());
		newUser.setUserst(sysUserUp.getUserst());
		newUser.setUserlv(sysUserUp.getUserlv());
		try {
			sysUserServiceImpl.update(newUser);
			rstMap.put("ret", "success");
			rstMap.put("msg", "修改柜员成功");
		} catch (Exception e) {
			rstMap.put("msg", e.getMessage());
		}
		return rstMap;
	}
	/**
	 * @author LiuTao @date 2018年6月6日 上午11:20:38 
	 * @Title: upUserPasswd 
	 * @Description: 重置柜员密码 
	 * @param ajaxSysUser
	 * @param sessionSysUser
	 * @return
	 */
	@RequestMapping(value = "/urpswd")
	public Map<String,Object> upUserPasswd(@RequestBody SysUser ajaxSysUser, @ModelAttribute("SysUser") SysUser sessionSysUser){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		SysUser updateSysUser = sysUserServiceImpl.selectOneByPrimeKey(sessionSysUser.getRegistCd(), ajaxSysUser.getUserid());
		updateSysUser.setPasswd(PASSWD);
		try {
			sysUserServiceImpl.saveOrUpdate(updateSysUser);
			rstMap.put("ret", "success");
			rstMap.put("msg", "修改柜员成功");
		} catch (Exception e) {
			rstMap.put("msg", e.getMessage());
		}
		return rstMap;
	}
	
	/**
	 * //根据 SifSysRole查询 SifSysRoleAuth查询菜单权限
	 * @param sifSysRole
	 * @return
	 */
	
	/**
	 * @author LiuTao @date 2018年6月24日 上午10:29:39 
	 * @Title: allAuthRole 
	 * @Description: TODO(Describe) 
	 * @param reqMap
	 * @return
	 */
	@RequestMapping(value="/allAuthRole")
	public Map<String, Object> allAuthRole(@RequestParam Map<String,Object> reqMap){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		SysAuthRole authRole = new SysAuthRole();
//		authRole.setRegist_cd(reqMap.get("roleCd").toString());
//		authRole.setAuth_type(reqMap.get("authType").toString());
//		authRole.setRegist_cd(reqMap.get("registCd").toString());
		if (reqMap.get("qq_authCd") != null && reqMap.get("qq_authCd") != "") {
			authRole.setAuth_cd(reqMap.get("qq_authCd").toString());
		}
		int page = Integer.parseInt((String) reqMap.get("start"));
		int size = Integer.parseInt((String) reqMap.get("length"));
		Map<String, Object> listWithCount = sysAuthRoleServiceImpl.findAllByEntityPageSizeWithCount(authRole, page, size);
		try {
			rstMap = CommUtil.transSrcMapToWebMap(listWithCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rstMap;		
	}
	
	
	/**
	 * @author LiuTao @date 2018年7月18日 下午3:25:54 
	 * @Title: allRole 
	 * @Description: 查询所有角色信息 sys_role表
	 * @param reqMap
	 * @return
	 */
	@RequestMapping(value="/allRole")
	public Map<String, Object> allRole(@RequestParam Map<String,Object> reqMap){
	    Map<String, Object> rstMap = new HashMap<String, Object>();
		SysRole sysRole = new SysRole();
		if (reqMap.get("q_authType") != null && reqMap.get("q_authType") != "") {
			sysRole.setAuth_type(reqMap.get("q_authType").toString());
		}
		if (reqMap.get("q_roleCd") != null && reqMap.get("q_roleCd") != "") {
			sysRole.setRole_cd(reqMap.get("q_roleCd").toString());
		}
//		if(reqMap.get("q_roleName")!=null&&reqMap.get("q_roleName")!=""){
//			sysRole.setRoleName(reqMap.get("q_roleName").toString());
//		}
		int page = Integer.parseInt((String) reqMap.get("start"));
		int size = Integer.parseInt((String) reqMap.get("length"));	
		Map<String, Object> listWithCount = sysRoleServiceImpl.findAllByEntityPageSizeWithCount(sysRole, page, size);
		try {
			rstMap = CommUtil.transSrcMapToWebMap(listWithCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rstMap;
	}
	
//	/**
//	 * @author LiuTao @date 2018年7月19日 上午10:19:49 
//	 * @Title: allRoleAuth 
//	 * @Description: TODO(Describe) 
//	 * @param reqMap
//	 * @return
//	 */
//	@RequestMapping(value = "/role_auth")
//	public Map<String, Object> allRoleAuth(@RequestParam Map<String,Object> reqMap){
//		 Map<String, Object> rstMap = new HashMap<String, Object>();
//		 return rstMap;
//	}
	
	
	/**---------------------------------------分隔符------------------------------------------------*/
	
	/**
	 * @author LiuTao @date 2018年5月7日 下午7:46:26 
	 * @Title: reGetMenu 
	 * @Description: TODO(根据sysAuth查询子项) 
	 * @param entity 权限模板
	 * @param parentMenu 父级菜单权限
	 * @param rank 层级
	 * @param flag 是否控制权限 true控制权限 false不控制
	 * @return
	 */
	private List<SysAuth> reGetMenu(SysAuth entity, List<SysAuth> parentMenu, int rank, Boolean flag) {
		// 取1级菜单		
		List<SysAuth> removeList = new ArrayList<SysAuth>();// list 遍历元素时不允许删除元素,创建一个List用于储存删除的元素,遍历后集中集中删除
		/**
		 * 循环遍历这一级菜单,分别获取下一级级菜单
		 */
		for (SysAuth sysAuth : parentMenu) {// 循环处理父菜单
			/**
			 * 判断user是否拥有权限
			 * 无父级菜单权限,子菜单权限无效
			 */
			if (strInArray(sysAuth.getAuth_cd(), strArray) && flag) { 
				removeList.add(sysAuth);// 放入删除List中
				continue;
			}
			entity.setRank(rank + 1);// 取下一级菜单级菜单
			entity.setParent_auth_cd(sysAuth.getAuth_cd());// 设置父级cored
			List<SysAuth> childMenu = new ArrayList<SysAuth>();
			
			childMenu.addAll(sysAuthServiceImpl.selectAllEntities(entity));
			if (childMenu.size() > 0) {
				sysAuth.setChildren(reGetMenu(entity, childMenu, entity.getRank(), flag));// 递归处理
				sysAuth.setHaschild("Y");
			}
		}
		parentMenu.removeAll(removeList);
		return parentMenu;
	}
	/**
	 * @author LiuTao @date 2018年5月7日 下午7:45:42 
	 * @Title: strInArray 
	 * @Description: TODO(判断字符串数组是否包含字符串) 
	 * @param str
	 * @param strs
	 * @return
	 */
	public boolean strInArray(String str, String[] strs) {
		for (int i = 0; i < strs.length; i++) {
			if (str.equals(strs[i])) {
				return false;
			}
		}
		return true;
	}
}

