package cn.spring.mvn.core.amain.entity.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.spring.mvn.base.util.BaseUtil;
import cn.spring.mvn.comm.util.CommUtil;
import cn.spring.mvn.core.amain.entity.Customer;
import cn.spring.mvn.core.amain.entity.dao.CustomerDao;
import cn.spring.mvn.core.amain.entity.service.CustomerService;

@Repository("CustomerService")
public class CustomerServiceImpl implements CustomerService{

	@Resource
	private CustomerDao dao;
	
	@Override
	public Customer selectOneEntity(Customer entity) {
		return dao.selectOneEntity(entity);
	}
	
	@Override
	public List<Customer> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Map<String, Object> selectAllWithCountByPageSize(Customer entity, int page, int size) {
		Map<String, Object> paramMap = BaseUtil.getObjectMapByReflectObject(entity);
		long count = dao.selectListByParamMap(paramMap).size();
		BaseUtil.setPageSizeToParamMap(page, size, paramMap);
		List<Customer> list = dao.selectListByParamMap(paramMap);
		return CommUtil.getListWithCountByPageSize(list, count, page, size);
	}
	
}