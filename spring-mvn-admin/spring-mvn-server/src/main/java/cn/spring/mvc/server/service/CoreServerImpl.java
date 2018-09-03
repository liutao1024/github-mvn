package cn.spring.mvc.server.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import cn.spring.mvc.base.util.BaseUtil;
import cn.spring.mvc.comm.tools.SequenceTool;
import cn.spring.mvc.comm.util.CommUtil;
import cn.spring.mvc.comm.util.SpringContextUtil;
import cn.spring.mvc.core.entity.CustAccount;
import cn.spring.mvc.core.entity.CustElectron;
import cn.spring.mvc.core.entity.CustUser;
import cn.spring.mvc.core.entity.service.CustAccountService;
import cn.spring.mvc.core.entity.service.CustElectronService;
import cn.spring.mvc.core.entity.service.CustUserService;

public class CoreServerImpl {
	private static ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
	private static CustUserService custUserServiceImpl = applicationContext.getBean(CustUserService.class);
	private static CustElectronService custElectronServiceImpl = applicationContext.getBean(CustElectronService.class);
	private static CustAccountService custAccountServiceImpl = applicationContext.getBean(CustAccountService.class);
	/**
	 * @author LiuTao @date 2018年8月23日 上午11:19:36 
	 * @Title: queryCustUser 
	 * @Description: TODO(Describe) 
	 * @param idtftp
	 * @param idtfno
	 * @param custna
	 * @return
	 */
	public static Map<String, Object> queryCustUser(String idtftp, String idtfno, String custna){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		String hqlStr = "from CustUser";
		String appendStr = "";
		if(CommUtil.isNotNull(idtftp)){
			appendStr = "and idtftp = '" + idtftp + "'";
		}
		if(CommUtil.isNotNull(idtfno)){
			appendStr = "and idtfno = '" + idtfno + "'";
		}
		if(CommUtil.isNotNull(custna)){
			appendStr = "and idtftp like '%" + custna + "%'";
		}
		if(CommUtil.isNotNull(appendStr)){
			hqlStr = hqlStr + " where" + BaseUtil.dealWith("and", appendStr);
		}
		List<CustUser> custUserList = custUserServiceImpl.findAllByHql(hqlStr);
		rstMap.put("count", custUserList.size());
		rstMap.put("data", custUserList);
		return rstMap;
	}
	/**
	 * @author LiuTao @date 2018年8月23日 上午11:19:41 
	 * @Title: openAccount 
	 * @Description: TODO(Describe) 
	 * @param idtftp
	 * @param idtfno
	 * @param custna
	 * @return
	 */
	public static Map<String, Object> openAccount(String corpno, String idtftp, String idtfno, String custna) throws Exception{
//		System.out.println("CoreServerImpl.openAccount");
		Map<String, Object> rstMap = new HashMap<String, Object>();
		String custno = SequenceTool.getSequence("USER");
		String custac = SequenceTool.getSequence("ELECTRON");
		String acctno = SequenceTool.getSequence("ACCOUNT");
		CustUser custUser = new CustUser();
		CustElectron custElectron = new CustElectron();
		CustAccount custAccount = new CustAccount();
		custUser.setIdtftp(idtftp);
		custUser.setIdtfno(idtfno);
		custUser.setCustna(custna);
		custUser.setCustno(custno);

		custElectron.setCorpno(corpno);
		custElectron.setCustac(custac);
		custElectron.setCustno(custno);
		custElectron.setCustna(custna);
		
		custAccount.setCorpno(corpno);
		custAccount.setAcctno(acctno);
		custAccount.setCustno(custno);
		custAccount.setCustac(custac);
		custAccount.setAcctna(custna);
		custAccount.setOnlnbl(0);
		
		try {
			custUserServiceImpl.saveEntity(custUser);
			custElectronServiceImpl.saveEntity(custElectron);
			custAccountServiceImpl.saveEntity(custAccount);
		} catch (Exception exception) {
			throw exception;
		}
		rstMap.put("custno", custno);
		rstMap.put("custac", custac);
		rstMap.put("acctno", acctno);
		return rstMap;
	}
}
