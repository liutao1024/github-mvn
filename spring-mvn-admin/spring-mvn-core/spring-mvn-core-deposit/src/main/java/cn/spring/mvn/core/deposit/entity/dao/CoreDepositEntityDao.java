package cn.spring.mvn.core.deposit.entity.dao;

import java.util.List;

import cn.spring.mvn.core.deposit.entity.CoreDepositEntity;

public interface CoreDepositEntityDao {
	public List<CoreDepositEntity> selectCoreDepositEntityList();
}
