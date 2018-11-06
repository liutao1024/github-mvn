package cn.spring.mvn.core.amain.entity.dao;

import java.util.List;

import cn.spring.mvn.core.amain.entity.Organization;

public interface OrganizationDao {
	public List<Organization> selectAll();
}
