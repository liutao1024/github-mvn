package cn.spring.mvn.web.entity.service;

import java.util.List;

import cn.spring.mvn.basic.hibernat.HibernatService;
import cn.spring.mvn.web.entity.SysUser;

public interface SysUserService extends HibernatService<SysUser>{

	SysUser add(SysUser entity) throws Exception;
	
	void delete(SysUser entity);
	
	SysUser selectOneByPrimeKey(String registCd, String userid);
	
	List<SysUser> selectAll();
	
	List<SysUser> selectAllByRegistCd(String registCd);
	
	void update(SysUser entity);

	long count();

}