package cn.spring.mvn.web.entity.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.hibernat.HibernatServiceImpl;
import cn.spring.mvn.web.entity.SysAuth;
import cn.spring.mvn.web.entity.service.SysAuthService;

@Service("SysAuthService")
public class SysAuthServiceImpl extends HibernatServiceImpl<SysAuth> implements SysAuthService {

	@Override
	public List<SysAuth> queryEntitiesByEntityParamMap(SysAuth sysAuth) {
		return (List<SysAuth>)this.selectAllEntities(sysAuth);
	}

}
