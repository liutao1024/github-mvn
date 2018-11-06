package cn.spring.mvn.core.amain.entity.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.spring.mvn.core.amain.entity.Account;
import cn.spring.mvn.core.amain.entity.service.AccountService;

@Repository("AccountService")
public class AccountServiceImpl implements AccountService{

	@Override
	public List<Account> selectAll() {
		return null;
	}
	
}