package cn.spring.mvn.core.amain.zport.impl;

import java.util.List;

import cn.spring.mvn.basic.enums.BasicType;
import cn.spring.mvn.comm.tools.SequenceTool;
import cn.spring.mvn.comm.util.CommUtil;
import cn.spring.mvn.comm.util.SpringContextUtil;
import cn.spring.mvn.core.amain.entity.Account;
import cn.spring.mvn.core.amain.entity.BankCard;
import cn.spring.mvn.core.amain.entity.Customer;
import cn.spring.mvn.core.amain.entity.Electron;
import cn.spring.mvn.core.amain.entity.service.AccountService;
import cn.spring.mvn.core.amain.entity.service.BankCardService;
import cn.spring.mvn.core.amain.entity.service.CustomerService;
import cn.spring.mvn.core.amain.entity.service.ElectronService;
import cn.spring.mvn.core.amain.zport.OpacctInput;
import cn.spring.mvn.core.amain.zport.OpacctOutput;
import cn.spring.mvn.core.amain.zport.QrcustInput;
import cn.spring.mvn.core.amain.zport.QrcustOutput;

/**
 * @author LiuTao @date 2018年9月4日 下午1:25:31
 * @ClassName: AccountServiceImpl 
 * @Description: TODO(核心部分-账户模块对账户的处理均写在本类中)
 */

public class CoreMainServiceImpl extends SpringContextUtil {
	
	private static AccountService accountServiceImpl = (AccountService) applicationContext.getBean(AccountService.class);
	private static BankCardService bankCardServiceImpl = (BankCardService) applicationContext.getBean(BankCardService.class);
	private static CustomerService customerServiceImpl = (CustomerService) applicationContext.getBean(CustomerService.class);
	private static ElectronService electronServiceImpl = (ElectronService) applicationContext.getBean(ElectronService.class);
	/**
	 * @Author LiuTao @Date 2018年11月17日 下午1:43:56 
	 * @Title: openAccount 
	 * @Description: 核心开户
	 * @param input
	 * @param output
	 */
	public static void openAccount(OpacctInput input, OpacctOutput output){
		//1.必要参数为空校验
		if(CommUtil.isNull(input.getCertificateType())){
			
		}
		//2.检测客户是否存在
		Customer custmoer = customerServiceImpl.selectOneEntity(input.getCustomer());
		if(CommUtil.isNotNull(custmoer)){
			
		}
		//3.保存customer
		String custno = SequenceTool.getSequence(BasicType.SERIALTYPE.CUSTOMER.getValue());
		custmoer.setCustno(custno);
		customerServiceImpl.insertEntity(custmoer);
		//4.生成account信息
		Account account = new Account();
		String acctno = SequenceTool.getSequence(BasicType.SERIALTYPE.ACCOUNT.getValue());
		account.setAcctno(acctno);
		accountServiceImpl.insertEntity(account);
		//5.生成electron信息
		Electron electron = new Electron();
		String elecno = SequenceTool.getSequence(BasicType.SERIALTYPE.ELECTRON.getValue());
		electron.setElecno(elecno);
		electronServiceImpl.insertEntity(electron);
		//6.绑定bankcard信息
		BankCard bankCard = new BankCard();
		bankCard.setBankCardNumber(input.getBankCardNumber());
		bankCardServiceImpl.insertEntity(bankCard);
		
		
		output.setAccountName(input.getUserName());
		output.setAccountNumber(acctno);
		output.setBankCardNumber(input.getBankCardNumber());
		output.setCustNumber(custno);
		output.setElectronNumber(elecno);
		output.setOpenAccountSerial("");
		
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
