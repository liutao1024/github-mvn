package cn.spring.mvn.web.zport.impl;

import cn.spring.mvn.comm.util.CommUtil;
import cn.spring.mvn.comm.util.SpringContextUtil;
import cn.spring.mvn.web.entity.SysUser;
import cn.spring.mvn.web.entity.service.SysUserService;
import cn.spring.mvn.web.zport.ResetsInput;
import cn.spring.mvn.web.zport.ResetsOutput;
import cn.spring.mvn.web.zport.UserinInput;
import cn.spring.mvn.web.zport.UserinOutput;

/**
 * @Author LiuTao @Date 2019年1月2日 上午10:37:09
 * @ClassName: WebServiceImpl 
 * @Description: Web端柜员校验/登录,角色/权限控制的对应实现类
 */
public class WebServiceImpl extends SpringContextUtil {
	private static SysUserService sysUserServiceImpl = (SysUserService) applicationContext.getBean(SysUserService.class);
	/**
	 * @Author LiuTao @Date 2019年1月2日 上午10:45:52 
	 * @Title: resetUserStatus 
	 * @Description: 柜员重置登录状态 
	 * @param input
	 * @param output
	 */
	public static void resetUserStatus(ResetsInput input, ResetsOutput output){
		String status = "success";
		String mesage = "状态重置成功";
		SysUser resetSysUser = sysUserServiceImpl.selectOneByPrimeKey(input.getCropno(), input.getUserid());
		if(CommUtil.isNotNull(resetSysUser) || CommUtil.notEqual("1", resetSysUser.getStatus())){
			if(input.getIschck()){//
				if(CommUtil.equal(input.getPasswd(), resetSysUser.getPasswd())){//
					resetSysUser.setErrort(0);
					resetSysUser.setUserst("0");
					sysUserServiceImpl.update(resetSysUser);
				}else {
					status = "error";
					mesage = "状态重置失败,密码不正确";
				}
			}else {//
				resetSysUser.setErrort(0);
				resetSysUser.setUserst("0");
				sysUserServiceImpl.update(resetSysUser);
			}
		}else {
			status = "error";
			mesage = "状态重置失败,账户:" + input.getUserid() + "不存在,或未启用";
		}
		output.setStatus(status);
		output.setMesage(mesage);
	}
	/**
	 * @Author LiuTao @Date 2019年1月2日 上午10:45:52 
	 * @Title: loginCheck 
	 * @Description: 柜员登录 
	 * @param input
	 * @param output
	 * @throws Exception 
	 */
	public static void loginCheck(UserinInput input, UserinOutput output) throws Exception{
		boolean checkPasswdFlag = input.getPswdfg();
		SysUser checkSysUser = sysUserServiceImpl.selectOneByPrimeKey(input.getCropno(), input.getUserid());
		//账户存在未登录且密码错误次数不大于最大错误次数状态为启用状态
		if(CommUtil.isNotNull(checkSysUser) && CommUtil.equal(checkSysUser.getUserst(), "0") 
				&& CommUtil.compare(checkSysUser.getMaxert(), checkSysUser.getErrort()) >= 0 && CommUtil.equal("1", checkSysUser.getStatus())){
			if(checkPasswdFlag){
				if(CommUtil.notEqual(input.getPasswd(), checkSysUser.getPasswd())){
					int time = checkSysUser.getErrort() + 1;//密码错误次数加1
					checkSysUser.setErrort(time);
					sysUserServiceImpl.update(checkSysUser);
					throw new Exception("登录失败,密码错误:" + time + "次");
				}
			}
			checkSysUser.setErrort(0);
			checkSysUser.setUserst("1");
			sysUserServiceImpl.update(checkSysUser);
		}else {
			throw new Exception("登录失败");
		}
		output.setBrchno(checkSysUser.getBrchno());
		output.setSystdt("20190101");
		output.setUserna(checkSysUser.getUserna());
	}
}
