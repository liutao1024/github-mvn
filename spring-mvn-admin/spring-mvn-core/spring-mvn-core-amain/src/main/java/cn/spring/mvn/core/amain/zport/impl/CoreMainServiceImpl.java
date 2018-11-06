package cn.spring.mvn.core.amain.zport.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.spring.mvn.comm.util.CommUtil;
import cn.spring.mvn.comm.util.SpringContextUtil;
import cn.spring.mvn.core.amain.entity.Customer;
import cn.spring.mvn.core.amain.entity.service.CustomerService;
import cn.spring.mvn.core.amain.zport.QrcustInput;
import cn.spring.mvn.core.amain.zport.QrcustOutput;

/**
 * @author LiuTao @date 2018年9月4日 下午1:25:31
 * @ClassName: AccountServiceImpl 
 * @Description: TODO(核心部分-账户模块对账户的处理均写在本类中)
 */

public class CoreMainServiceImpl extends SpringContextUtil {
	
	private static CustomerService customerServiceImpl = (CustomerService) applicationContext.getBean(CustomerService.class);
	
	public static void openAccount(){
		
	}
	/**
	 * @author LiuTao @date 2018年9月4日 下午1:30:17 
	 * @Title: queryCustUser 
	 * @Description: TODO(Describe) 
	 * @param idtftp
	 * @param idtfno
	 * @param custna
	 * @return
	 */
	public static Map<String, Object> queryCustUserOne(String idtftp, String idtfno, String custna){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		String hqlStr = "from CustUser where 1 = 1";
		String appendStr = "";
		if(CommUtil.isNotNull(idtftp)){
			appendStr += " and idtftp = '" + idtftp + "'";
		}
		if(CommUtil.isNotNull(idtfno)){
			appendStr += " and idtfno = '" + idtfno + "'";
		}
		if(CommUtil.isNotNull(custna)){
			appendStr += " and custna like '%" + custna + "%'";
		}
		if(CommUtil.isNotNull(appendStr)){
			hqlStr = hqlStr + appendStr;
		}
		List<Customer> custUserList = customerServiceImpl.selectAll();
		rstMap.put("count", custUserList.size());
		rstMap.put("data", custUserList);
		return rstMap;
	}
	/**
	 * @author LiuTao @date 2018年10月23日 下午4:47:30 
	 * @Title: queryCustUser 
	 * @Description: TODO(Describe) 
	 * @param input
	 * @param output
	 */
	public static void queryCustUser(QrcustInput input, QrcustOutput output){
		String custno = input.getCustno();
		String custna = input.getCustna();
		String idtftp = input.getIdtftp();
		String idtfno = input.getIdtfno();
		String hqlStr = "from CustUser where 1 = 1";
		String appendStr = "";
		if(CommUtil.isNotNull(custno)){
			appendStr += " and custno = '" + custno + "'";
		}
		if(CommUtil.isNotNull(custna)){
			appendStr += " and custna like '%" + custna + "%'";
		}
		if(CommUtil.isNotNull(idtftp)){
			appendStr += " and idtftp = '" + idtftp + "'";
		}
		if(CommUtil.isNotNull(idtfno)){
			appendStr += " and idtfno = '" + idtfno + "'";
		}
		hqlStr = hqlStr + appendStr;
		List<Customer> custUserList = customerServiceImpl.selectAll();
		output.setCount(custUserList.size());
		output.setInfos(custUserList);
	}
}
