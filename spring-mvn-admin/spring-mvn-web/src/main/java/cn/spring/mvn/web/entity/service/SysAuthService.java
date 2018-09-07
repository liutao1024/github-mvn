package cn.spring.mvn.web.entity.service;

import java.util.List;

import cn.spring.mvn.base.BaseService;
import cn.spring.mvn.web.entity.SysAuth;

public interface SysAuthService extends BaseService<SysAuth>{
	public List<SysAuth> queryEntitiesByEntityParamMap(SysAuth sysAuth);
}
