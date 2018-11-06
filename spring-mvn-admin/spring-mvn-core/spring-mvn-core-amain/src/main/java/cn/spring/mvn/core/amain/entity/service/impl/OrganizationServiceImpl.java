package cn.spring.mvn.core.amain.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.core.amain.entity.Organization;
import cn.spring.mvn.core.amain.entity.dao.OrganizationDao;
import cn.spring.mvn.core.amain.entity.service.OrganizationService;

@Service("OrganizationService")
public class OrganizationServiceImpl implements OrganizationService {
	@Resource
	private OrganizationDao dao;

	@Override
	public List<Organization> selectAll() {
		return dao.selectAll();
	}
	

}
