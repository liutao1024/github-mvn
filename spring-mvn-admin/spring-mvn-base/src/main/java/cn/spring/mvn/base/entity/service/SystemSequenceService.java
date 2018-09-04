package cn.spring.mvn.base.entity.service;

import cn.spring.mvn.base.BaseService;
import cn.spring.mvn.base.entity.SystemSequence;

public interface SystemSequenceService extends BaseService<SystemSequence>{
	public abstract SystemSequence selectOne(String sequenceType);
}
