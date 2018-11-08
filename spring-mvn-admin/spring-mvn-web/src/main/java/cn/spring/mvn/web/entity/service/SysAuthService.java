package cn.spring.mvn.web.entity.service;

import java.util.List;

import cn.spring.mvn.basic.hibernat.HibernatService;
import cn.spring.mvn.web.entity.SysAuth;

public interface SysAuthService extends HibernatService<SysAuth>{
	public List<SysAuth> queryEntitiesByEntityParamMap(SysAuth sysAuth);
}
