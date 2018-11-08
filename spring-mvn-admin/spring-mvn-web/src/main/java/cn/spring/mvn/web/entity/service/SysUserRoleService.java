package cn.spring.mvn.web.entity.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.spring.mvn.basic.hibernat.HibernatService;
import cn.spring.mvn.web.entity.SysUserRole;
/**
 * @author LiuTao @date 2018年5月23日 下午1:55:29
 * @ClassName: SysRoleUserService 
 * @Description: TODO(定义sysRoleUser的业务方法)
 */
public interface SysUserRoleService extends HibernatService<SysUserRole>{
	/**
	 * 检查主键是否唯一
	 * @param id 主键对象
	 * @return 是否唯一
	 */
	public boolean checkUnique(SysUserRole sysUserRole);
	
	/**
	 * 根据模版分页查询实体
	 * @param tmp 模版对象
	 * @param pageable 分页排序模版
	 * @return 查询到的实体对象集合
	 */
	public Page<SysUserRole> queryEntitiesByTemplateWithPage(SysUserRole tmp,Pageable pageable);
	
	/**
	 * 获取系统角色下的操作员列表
	 * @param registCd
	 * @param authType: 1--操作权限  2--菜单权限  3--查询权限
	 * @param roleCd
	 * @return the list of userCd
	 */
	public List<String> getSysUserRoleListByRegistCdAndAuthTypeAndRoleCd(String registCd, String authType, String roleCd);
	
	/**
	 * @author LiuTao @date 2018年5月26日 下午5:15:09 
	 * @Title: queryEntitiesByParameterMap 
	 * @Description: 通过参数查询List   已改写在HibernatDao里的接口
	 * @param parmMap
	 * @return
	 */
	public List<SysUserRole> queryEntitiesByEntityParamMap(SysUserRole sysUserRole);
	
	public SysUserRole selectOneByPrimeKey(String registCd, String authType, String roleCd, String userCd);
}
