package cn.spring.mvn.core.fund.entity.dao;

import java.util.List;

import cn.spring.mvn.core.fund.entity.CoreFundEntity;

public interface CoreFundEntityDao {
	public List<CoreFundEntity> selectCoreFundList();
}
