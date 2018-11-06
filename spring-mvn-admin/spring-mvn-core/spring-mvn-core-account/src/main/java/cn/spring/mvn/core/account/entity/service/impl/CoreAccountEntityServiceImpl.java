package cn.spring.mvn.core.account.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.core.account.entity.CoreAccountEntity;
import cn.spring.mvn.core.account.entity.dao.CoreAccountEntityDao;
import cn.spring.mvn.core.account.entity.service.CoreAccountEntityService;

@Service("CoreAccountEntityService")
public class CoreAccountEntityServiceImpl implements CoreAccountEntityService {
	@Resource
	private CoreAccountEntityDao dao;
	@Override
	public List<CoreAccountEntity> selectCoreAccountEntityList() {
		return dao.selectCoreAccountEntityList();
	}

}
