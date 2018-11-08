package cn.spring.mvn.core.amain.zport.impl;

import java.util.List;

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
	 * @author LiuTao @date 2018年10月23日 下午4:47:30 
	 * @Title: queryCustUser 
	 * @Description: TODO(Describe) 
	 * @param input
	 * @param output
	 */
	public static void queryCustUser(QrcustInput input, QrcustOutput output){
		Customer customer = new Customer();
		customer.setCustno(input.getCustno());
		customer.setCustna(input.getCustna());
		customer.setIdtftp(input.getIdtftp());
		customer.setIdtfno(input.getIdtfno());
		List<Customer> customerList = customerServiceImpl.selectListByEntity(customer);
		output.setCount(customerList.size());
		output.setInfos(customerList);
	}
}
