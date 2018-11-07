package cn.spring.mvn.core.amain.entity.dao;

import java.util.List;
import java.util.Map;

import cn.spring.mvn.core.amain.entity.Customer;

public interface CustomerDao {
	public int insertEntity(Customer entity);
	public int deleteEntity(Customer entity);
	public int updateEntity(Customer entity);
	public Customer selectOneEntity(Customer entity);
	public List<Customer> selectAll();
	public List<Customer> selectListByParamMap(Map<String, Object> paramMap);
}
