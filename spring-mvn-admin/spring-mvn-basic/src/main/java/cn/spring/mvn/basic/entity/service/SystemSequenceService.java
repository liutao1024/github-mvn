package cn.spring.mvn.basic.entity.service;

import cn.spring.mvn.basic.entity.SystemSequence;
import cn.spring.mvn.basic.hibernat.HibernatService;

public interface SystemSequenceService extends HibernatService<SystemSequence>{
	public abstract SystemSequence selectOne(String sequenceType);
}
