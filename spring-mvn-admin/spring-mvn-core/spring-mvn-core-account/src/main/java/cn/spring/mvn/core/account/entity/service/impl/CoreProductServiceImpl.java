package cn.spring.mvn.core.account.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.core.account.entity.CoreProduct;
import cn.spring.mvn.core.account.entity.dao.CoreProductDao;
import cn.spring.mvn.core.account.entity.service.CoreProductService;


@Service("CoreProductService")
public class CoreProductServiceImpl implements CoreProductService{
	@Resource
	private CoreProductDao dao;
	@Override
	public List<CoreProduct> selectCorePorductList() {
		return dao.selectCorePorductList();
	}

}
