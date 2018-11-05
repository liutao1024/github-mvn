package cn.spring.mvn.core.loan.entity.dao;

import java.util.List;

import cn.spring.mvn.core.loan.entity.CoreLoanEntity;

public interface CoreLoanEntityDao {
	public List<CoreLoanEntity> selectCorePorductList();
}
