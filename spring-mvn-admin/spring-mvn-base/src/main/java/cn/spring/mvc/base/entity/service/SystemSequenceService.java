package cn.spring.mvc.base.entity.service;

import cn.spring.mvc.base.BaseService;
import cn.spring.mvc.base.entity.SystemSequence;

public interface SystemSequenceService extends BaseService<SystemSequence>{
	public abstract SystemSequence selectOne(String sequenceType);
}
