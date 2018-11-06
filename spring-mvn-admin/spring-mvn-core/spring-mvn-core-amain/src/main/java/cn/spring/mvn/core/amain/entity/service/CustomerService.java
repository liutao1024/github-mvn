package cn.spring.mvn.core.amain.entity.service;

import java.util.List;
import java.util.Map;

import cn.spring.mvn.core.amain.entity.Customer;

public interface CustomerService {
	public Customer selectOneEntity(Customer customer);
	public List<Customer> selectAll();
	public Map<String, Object> selectAllWithCountByPageSize(Customer customer, int page, int size);
	
}