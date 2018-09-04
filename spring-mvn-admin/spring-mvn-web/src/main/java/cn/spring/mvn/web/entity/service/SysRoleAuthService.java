package cn.spring.mvn.web.entity.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.spring.mvn.base.BaseService;
import cn.spring.mvn.web.entity.SysRoleAuth;

public interface SysRoleAuthService extends BaseService<SysRoleAuth>{
	/**
	 * 检查主键是否唯一
	 * @param id 主键对象
	 * @return 是否唯一
	 */
	public boolean checkUnique(SysRoleAuth sysAuthRole);
	/**
	 * 获取系统角色下的操作员列表
	 * @param registerCd
	 * @param authType: 1--操作权限  2--菜单权限  3--查询权限
	 * @param roleCd
	 * @return the list of userCd
	 */
	public List<String> getSysAuthRoleListByRegistCdAndAuthTypeAndRoleCd(String registCd, String authType, String roleCd);
	/**
	 * @author LiuTao @date 2018年5月30日 下午3:05:42 
	 * @Title: selectOneByPrimeKey 
	 * @Description: 由主键确定唯一值
	 * @param registCd
	 * @param authType
	 * @param roleCd
	 * @param authCd
	 * @return
	 */
	public SysRoleAuth selectOneByPrimeKey(String registCd, String authType, String roleCd, String authCd);
	/**
	 * 根据模版分页查询实体
	 * @param tmp 模版对象
	 * @param pageable 分页排序模版
	 * @return 查询到的实体对象集合
	 */
	public Page<SysRoleAuth> queryEntitiesByTemplateWithPage(SysRoleAuth sysAuthRole,Pageable pageable);
	
}
