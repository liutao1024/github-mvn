package cn.spring.mvn.core.amain.entity.dao;

import java.util.List;

import cn.spring.mvn.basic.ibatis.IBatisDao;
import cn.spring.mvn.core.amain.entity.Organization;

public interface OrganizationDao extends IBatisDao<Organization>{
	public List<Organization> selectAll();
}
