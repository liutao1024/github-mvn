package cn.spring.mvc.web.entity.service;

import cn.spring.mvc.base.BaseService;
import cn.spring.mvc.web.entity.SysRole;

public interface SysRoleService extends BaseService<SysRole> {
	public SysRole selectOneByPrimeKey(String regist_cd, String auth_type, String role_cd);
}
