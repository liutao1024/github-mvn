package cn.spring.mvn.core.amain.entity.service;

import java.util.List;
import java.util.Map;

import cn.spring.mvn.core.amain.entity.Customer;

public interface CustomerService {
	public int insertEntity(Customer entity);
	public int deleteEntity(Customer entity);
	public int updateEntity(Customer entity);
	public Customer selectOneEntity(Customer entity);
	public List<Customer> selectAll();
	public List<Customer> selectListByEntity(Customer entity);
	public Map<String, Object> selectMapWithCountAndListByEntityAndPageSize(Customer entity, int page, int size);
	
}