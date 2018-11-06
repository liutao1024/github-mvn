package cn.spring.mvn.core.amain.entity.dao;

import java.util.List;

import cn.spring.mvn.core.amain.entity.Account;

public interface AccountDao {
	public List<Account> selectAll();
}
