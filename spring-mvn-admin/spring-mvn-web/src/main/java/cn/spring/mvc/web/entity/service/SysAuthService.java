package cn.spring.mvc.web.entity.service;

import java.util.List;

import cn.spring.mvc.base.BaseService;
import cn.spring.mvc.web.entity.SysAuth;

public interface SysAuthService extends BaseService<SysAuth>{
	public List<SysAuth> queryEntitiesByEntityParamMap(SysAuth sysAuth);
}
