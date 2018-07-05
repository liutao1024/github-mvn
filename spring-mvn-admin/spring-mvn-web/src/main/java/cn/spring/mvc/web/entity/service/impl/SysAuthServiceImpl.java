package cn.spring.mvc.web.entity.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.spring.mvc.base.BaseServiceImpl;
import cn.spring.mvc.web.entity.SysAuth;
import cn.spring.mvc.web.entity.service.SysAuthService;

@Service("SysAuthService")
public class SysAuthServiceImpl extends BaseServiceImpl<SysAuth> implements SysAuthService {

	@Override
	public List<SysAuth> queryEntitiesByEntityParamMap(SysAuth sysAuth) {
		return (List<SysAuth>)this.selectAllEntities(sysAuth);
	}

}
