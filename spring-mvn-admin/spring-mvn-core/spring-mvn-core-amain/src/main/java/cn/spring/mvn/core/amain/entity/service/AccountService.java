package cn.spring.mvn.core.amain.entity.service;

import java.util.List;

import cn.spring.mvn.basic.ibatis.IBatisService;
import cn.spring.mvn.core.amain.entity.Account;

public interface AccountService extends IBatisService<Account>{
	public List<Account> selectAll();
}