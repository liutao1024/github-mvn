package cn.spring.mvn.web.entity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.spring.mvn.base.BaseServiceImpl;
import cn.spring.mvn.comm.util.CommUtil;
import cn.spring.mvn.web.entity.SysRoleAuth;
import cn.spring.mvn.web.entity.service.SysRoleAuthService;

@Service("SysRoleAuthService")
public class SysRoleAuthServiceImpl extends  BaseServiceImpl<SysRoleAuth> implements SysRoleAuthService {

	@Override
	public boolean checkUnique(SysRoleAuth sysAuthRole) {
		List<SysRoleAuth> list = this.selectAllEntities(sysAuthRole);
		boolean rst = false;
		if(CommUtil.isNotNull(list) && list.size() == 1 ){
			rst = true;
		}
		return rst;
	}

	@Override
	public List<String> getSysAuthRoleListByRegistCdAndAuthTypeAndRoleCd(String registCd, String authType, String roleCd) {
		SysRoleAuth sysAuthRole = new SysRoleAuth();
		sysAuthRole.setRegist_cd(registCd);
		sysAuthRole.setAuth_type(authType);
		sysAuthRole.setRole_cd(roleCd);
		List<SysRoleAuth> list = this.selectAllEntities(sysAuthRole);
		List<String> strList = new ArrayList<String>();
		for(SysRoleAuth theSysAuthRole : list){
			strList.add(theSysAuthRole.getAuth_cd());
		}
		return strList;
	}

	@Override
	public SysRoleAuth selectOneByPrimeKey(String registCd, String authType, String roleCd, String authCd) {
		SysRoleAuth sysAuthRole = new SysRoleAuth(registCd, authType, roleCd, authCd);
		return this.selectOneEntity(sysAuthRole);
	}

	@Override
	public Page<SysRoleAuth> queryEntitiesByTemplateWithPage(SysRoleAuth sysAuthRole, Pageable pageable) {
		pageable.getOffset();
		pageable.getPageNumber();
		pageable.getPageSize();
		pageable.getSort();
		return null;
	}
	
}
