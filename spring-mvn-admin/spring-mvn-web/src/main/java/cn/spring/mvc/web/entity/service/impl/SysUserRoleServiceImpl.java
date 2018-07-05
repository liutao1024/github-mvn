package cn.spring.mvc.web.entity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.spring.mvc.base.BaseServiceImpl;
import cn.spring.mvc.web.entity.SysUserRole;
import cn.spring.mvc.web.entity.service.SysUserRoleService;

@Service("SysUserRoleService")
public class SysUserRoleServiceImpl extends  BaseServiceImpl<SysUserRole> implements SysUserRoleService {

	@Override
	public boolean checkUnique(SysUserRole sysUserRole) {
		List<SysUserRole> list = this.selectAllEntities(sysUserRole);
		if(list != null && list.size() == 1){
			return true;
		}
		return false;
	}

	@Override
	public Page<SysUserRole> queryEntitiesByTemplateWithPage(SysUserRole tmp, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSysUserRoleListByRegistCdAndAuthTypeAndRoleCd(String registCd, String authType, String roleCd) {
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setRegist_cd(registCd);
		sysUserRole.setAuth_type(authType);
		sysUserRole.setRole_cd(roleCd);
		List<SysUserRole> list = this.selectAllEntities(sysUserRole);
		List<String> str = new ArrayList<String>();
		for(SysUserRole s : list){
			str.add(s.getUser_cd());
		}
		return str;
	}

	@Override
	public List<SysUserRole> queryEntitiesByEntityParamMap(SysUserRole sysUserRole) {
		return this.selectAllEntities(sysUserRole);
	}

	@Override
	public SysUserRole selectOneByPrimeKey(String registCd, String authType, String roleCd, String userCd) {
		SysUserRole sysUserRole = new SysUserRole(registCd, authType, roleCd, userCd);
		return this.selectOneEntity(sysUserRole);
	}
	
}
