package cn.spring.mvn.web.entity.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.spring.mvn.base.BaseServiceImpl;
import cn.spring.mvn.web.entity.SysUser;
import cn.spring.mvn.web.entity.service.SysUserService;

@Service("SysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService{
	
	@Override
	public SysUser add(SysUser entity) throws Exception {
		return this.saveEntity(entity);
	}
	
	@Override
	public void delete(SysUser entity) {
		this.deleteEntity(entity);
	}

	@Override
	public void update(SysUser entity) {
		this.updateEntity(entity);
	}
	
	@Override
	public SysUser selectOneByPrimeKey(String registCd, String userid){
//		SysUser sysUser = new SysUser();
//		sysUser.setRegistCd(registCd);
//		sysUser.setUserid(userid);
		//由于sysUser的例有默认值导致用daoImpl中的会出现查不到
		String hqlStr = "from SysUser where regist_cd = " + registCd + " and userid = " + userid;
		List<SysUser> sysUserList = this.findAllByHql(hqlStr);
		if(sysUserList != null && sysUserList.size() == 1){
			return sysUserList.get(0);
		}else {
			return null;
		}
	}
	
	@Override
	public List<SysUser> selectAll() {
		String hqlStr = "from SysUser";
		return this.findAllByHql(hqlStr);
	}
	@Override
	public List<SysUser> selectAllByRegistCd(String registCd){
		String hqlStr = "from SysUser where regist_cd = '" + registCd + "'";
		return this.findAllByHql(hqlStr);
	}
	
	@Override
	public long count() {
		List<SysUser> sysUsers = selectAll();
		return sysUsers.size();
	}


}
