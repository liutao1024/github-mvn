package cn.spring.mvn.core.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.core.entity.CoreProduct;
import cn.spring.mvn.core.entity.dao.CoreProductDao;
import cn.spring.mvn.core.entity.service.CoreProductService;


@Service("CoreProductService")
public class CoreProductServiceImpl implements CoreProductService{
	@Resource
	private CoreProductDao coreProductDao;
	@Override
	public List<CoreProduct> selectCorePorductList() {
		return coreProductDao.selectCorePorductList();
	}

}
