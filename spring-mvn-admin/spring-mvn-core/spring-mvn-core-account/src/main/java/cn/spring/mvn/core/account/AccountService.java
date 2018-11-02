package cn.spring.mvn.core.account;

import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.comm.util.SpringContextUtil;
import cn.spring.mvn.core.account.entity.service.CustUserService;

public class AccountService {
	@Autowired
	private CustUserService custUserServiceImple = SpringContextUtil.getBean(CustUserService.class);
	
	public void doSomeThing(){
		
	}
}
