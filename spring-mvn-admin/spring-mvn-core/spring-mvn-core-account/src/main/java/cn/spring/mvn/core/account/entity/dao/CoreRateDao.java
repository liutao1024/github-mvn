package cn.spring.mvn.core.account.entity.dao;

import java.util.List;

import cn.spring.mvn.core.account.entity.CoreRate;

public interface CoreRateDao {
	public List<CoreRate> selectCoreRateList();
}
