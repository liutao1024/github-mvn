package cn.spring.mvn.core.amain.entity.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.spring.mvn.basic.tools.BasicReflection;
import cn.spring.mvn.basic.util.BasicUtil;
import cn.spring.mvn.comm.util.CommUtil;
import cn.spring.mvn.core.amain.entity.Customer;
import cn.spring.mvn.core.amain.entity.dao.CustomerDao;
import cn.spring.mvn.core.amain.entity.service.CustomerService;

@Repository("CustomerService")
public class CustomerServiceImpl implements CustomerService{

	@Resource
	private CustomerDao dao;
	
	@Override
	public int insertEntity(Customer entity) {
		return dao.insertEntity(entity);
	}
	
	@Override
	public int deleteEntity(Customer entity) {
		return dao.deleteEntity(entity);
	}
	
	@Override
	public int updateEntity(Customer entity) {
		return dao.updateEntity(entity);
	}
	
	@Override
	public Customer selectOneEntity(Customer entity) {
		return dao.selectOneEntity(entity);
	}
	
	@Override
	public List<Customer> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Customer> selectListByEntity(Customer entity){
		Map<String, Object> paramMap = BasicReflection.getMapByReflectWithOutNullObject(entity);
		return dao.selectListByParamMap(paramMap);
	}
	
	@Override
	public Map<String, Object> selectMapWithCountAndListByEntityAndPageSize(Customer entity, int page, int size) {
		Map<String, Object> paramMap = BasicReflection.getMapByReflectWithOutNullObject(entity);
		long count = dao.selectListByParamMap(paramMap).size();
		BasicUtil.setPageSizeToParamMap(page, size, paramMap);
		List<Customer> list = dao.selectListByParamMap(paramMap);
		return CommUtil.getListWithCountByPageSize(list, count, page, size);
	}
	
}