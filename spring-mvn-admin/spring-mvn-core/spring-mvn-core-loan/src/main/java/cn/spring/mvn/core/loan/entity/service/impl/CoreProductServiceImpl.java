package cn.spring.mvn.core.loan.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.core.loan.entity.CoreProduct;
import cn.spring.mvn.core.loan.entity.dao.CoreProductDao;
import cn.spring.mvn.core.loan.entity.service.CoreProductService;


@Service("CoreProductService")
public class CoreProductServiceImpl implements CoreProductService{
	@Resource
	private CoreProductDao coreProductDao;
	@Override
	public List<CoreProduct> selectCorePorductList() {
		return coreProductDao.selectCorePorductList();
	}

}
