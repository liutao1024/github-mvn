package cn.spring.mvn.core.amain.entity.dao;

import java.util.List;

import cn.spring.mvn.basic.ibatis.IBatisDao;
import cn.spring.mvn.core.amain.entity.Account;

public interface AccountDao extends IBatisDao<Account>{
	public List<Account> selectAll();
}
