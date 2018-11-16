package cn.spring.mvn.core.amain.entity.service;

import java.util.List;
import java.util.Map;

import cn.spring.mvn.basic.ibatis.IBatisService;
import cn.spring.mvn.core.amain.entity.Customer;

public interface CustomerService extends IBatisService<Customer> {
	public List<Customer> selectAll();
	public List<Customer> selectListByEntity(Customer entity);
	public Map<String, Object> selectMapWithCountAndListByEntityAndPageSize(Customer entity, int page, int size);
	
}