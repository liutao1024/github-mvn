package cn.spring.mvn.core.account.entity.dao;

import java.util.List;

import cn.spring.mvn.core.account.entity.CoreAccountEntity;

public interface CoreAccountEntityDao {
	public List<CoreAccountEntity> selectCoreAccountEntityList();
}