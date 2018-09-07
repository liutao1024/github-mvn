package cn.spring.mvn.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;



//import cn.spring.mvn.comm.tools.SequenceTool;
import cn.spring.mvn.comm.util.CommUtil;
import cn.spring.mvn.core.account.entity.CustUser;
import cn.spring.mvn.core.account.entity.service.CustUserService;
import cn.spring.mvn.web.entity.SysUser;
/**
 * @author LiuTao @date 2018年6月9日 下午10:21:54
 * @ClassName: CustController 
 * @Description: 客户相关页面Controller
 */
@Controller("CustController")
@RequestMapping(value = "cust")
@ResponseBody
@SessionAttributes("SysUser")
public class CustController {
	@Autowired
	private CustUserService custUserServiceImpl;
	/**
	 * @author LiuTao @date 2018年6月9日 下午7:21:05 
	 * @Title: getCust 
	 * @Description: TODO(Describe) 
	 * @param reqMap
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value ="/custinfo")
	public Map<String,Object> getCustInfo(@RequestParam Map<String, Object> reqMap, @ModelAttribute("SysUser") SysUser sysUser){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		CustUser custUser = new CustUser();
		custUser.setCustno(reqMap.get("custno").toString());
		custUser.setCustna(reqMap.get("custna").toString());
		custUser.setIdtftp(reqMap.get("idtftp").toString());
		custUser.setIdtfno(reqMap.get("idtfno").toString());
		int page = Integer.parseInt((String) reqMap.get("start"));
		int size = Integer.parseInt((String) reqMap.get("length"));
		Map<String, Object> listWithCount = custUserServiceImpl.findAllByEntityPageSizeWithCount(custUser, page, size);
		try {
			rstMap = CommUtil.transSrcMapToWebMap(listWithCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rstMap;
	}
	/**
	 * @author LiuTao @date 2018年6月10日 下午8:50:47 
	 * @Title: updateCustUser 
	 * @Description: 更新客户信息
	 * @param reqMap
	 * @return
	 */
	@RequestMapping(value = "/update")
	public  Map<String, Object>  updateCustUser(@RequestBody Map<String, Object> reqMap){
		Map<String, Object> rspMap = new HashMap<String, Object>();
		String idtftp = (String) reqMap.get("idtftp");
		String idtfno = (String) reqMap.get("idtfno");
		for (Entry<String, Object> en : reqMap.entrySet()) {
			String s = en.getKey();
			String sb = (String) en.getValue();
			System.out.println(s);
			System.out.println(sb);
		}
		CustUser custUser = new CustUser();
		custUser.setIdtftp(idtftp);
		custUser.setIdtfno(idtfno);
		custUser = custUserServiceImpl.selectOneEntity(custUser);
		try {
//			custUser.setCustno(SequenceTool.getSequence("USER"));
			custUser.setTeleno((String) reqMap.get("teleno"));
			custUser.setCustst((String) reqMap.get("custst"));
			custUser.setAddres((String) reqMap.get("addres"));
			custUser.setCustno((String) reqMap.get("custno"));
			custUser.setCustna((String) reqMap.get("custna"));
			custUserServiceImpl.saveOrUpdate(custUser);
			rspMap.put("retCode", "0000");
		} catch (Exception e) {
			rspMap.put("retCode", "101");
			rspMap.put("retMsg", e.getMessage());
		}
		return rspMap;
	}
}
