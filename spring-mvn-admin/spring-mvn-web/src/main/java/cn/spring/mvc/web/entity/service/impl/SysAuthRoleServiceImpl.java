package cn.spring.mvc.web.entity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.spring.mvc.base.BaseServiceImpl;
import cn.spring.mvc.comm.util.CommUtil;
import cn.spring.mvc.web.entity.SysAuthRole;
import cn.spring.mvc.web.entity.service.SysAuthRoleService;

@Service("SysAuthRoleService")
public class SysAuthRoleServiceImpl extends  BaseServiceImpl<SysAuthRole> implements SysAuthRoleService {

	@Override
	public boolean checkUnique(SysAuthRole sysAuthRole) {
		List<SysAuthRole> list = this.selectAllEntities(sysAuthRole);
		boolean rst = false;
		if(CommUtil.isNotNull(list) && list.size() == 1 ){
			rst = true;
		}
		return rst;
	}

	@Override
	public List<String> getSysAuthRoleListByRegistCdAndAuthTypeAndRoleCd(String registCd, String authType, String roleCd) {
		SysAuthRole sysAuthRole = new SysAuthRole();
		sysAuthRole.setRegist_cd(registCd);
		sysAuthRole.setAuth_type(authType);
		sysAuthRole.setRole_cd(roleCd);
		List<SysAuthRole> list = this.selectAllEntities(sysAuthRole);
		List<String> strList = new ArrayList<String>();
		for(SysAuthRole theSysAuthRole : list){
			strList.add(theSysAuthRole.getAuth_cd());
		}
		return strList;
	}

	@Override
	public SysAuthRole selectOneByPrimeKey(String registCd, String authType, String roleCd, String authCd) {
		SysAuthRole sysAuthRole = new SysAuthRole(registCd, authType, roleCd, authCd);
		return this.selectOneEntity(sysAuthRole);
	}

	@Override
	public Page<SysAuthRole> queryEntitiesByTemplateWithPage(SysAuthRole sysAuthRole, Pageable pageable) {
		pageable.getOffset();
		pageable.getPageNumber();
		pageable.getPageSize();
		pageable.getSort();
		return null;
	}
	
}
