package cn.spring.mvn.base.entity.service;

import cn.spring.mvn.base.BaseService;
import cn.spring.mvn.base.entity.SystemTransaction;

public interface SystemTransactionService extends BaseService<SystemTransaction>{
	public abstract SystemTransaction selectOne(String corecd, String trantp);
}
