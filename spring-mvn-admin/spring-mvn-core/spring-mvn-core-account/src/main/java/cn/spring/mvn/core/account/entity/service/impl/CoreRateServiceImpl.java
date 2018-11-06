package cn.spring.mvn.core.account.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.core.account.entity.CoreRate;
import cn.spring.mvn.core.account.entity.dao.CoreRateDao;
import cn.spring.mvn.core.account.entity.service.CoreRateService;

@Service("CoreRateService")
public class CoreRateServiceImpl implements CoreRateService{
	@Resource
	private CoreRateDao dao;
	
	@Override
	public List<CoreRate> selectCoreRateList() {
		// TODO Auto-generated method stub
		return null;
	}

}
