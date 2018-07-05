package cn.spring.mvc.web.entity.service;

import java.util.List;

import cn.spring.mvc.base.BaseService;
import cn.spring.mvc.web.entity.SysUser;

public interface SysUserService extends BaseService<SysUser>{

	SysUser add(SysUser entity) throws Throwable;
	
	void delete(SysUser entity);
	
	SysUser selectOneByPrimeKey(String registCd, String userid);
	
	List<SysUser> selectAll();
	
	List<SysUser> selectAllByRegistCd(String registCd);
	
	void update(SysUser entity);

	long count();

}