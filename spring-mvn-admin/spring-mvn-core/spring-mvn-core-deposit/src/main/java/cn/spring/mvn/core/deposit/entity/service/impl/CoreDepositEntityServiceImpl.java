package cn.spring.mvn.core.deposit.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.core.deposit.entity.CoreDepositEntity;
import cn.spring.mvn.core.deposit.entity.dao.CoreDepositEntityDao;
import cn.spring.mvn.core.deposit.entity.service.CoreDepositEntityService;

@Service("CoreDepositEntityService")
public class CoreDepositEntityServiceImpl implements CoreDepositEntityService{

	@Resource
	private CoreDepositEntityDao dao;
	@Override
	public List<CoreDepositEntity> selectCoreDepositEntityList() {
		return dao.selectCoreDepositEntityList();
	}

}
