package cn.spring.mvn.web.entity.service;

import cn.spring.mvn.base.BaseService;
import cn.spring.mvn.web.entity.SysRole;

public interface SysRoleService extends BaseService<SysRole> {
	public SysRole selectOneByPrimeKey(String regist_cd, String auth_type, String role_cd);
}
