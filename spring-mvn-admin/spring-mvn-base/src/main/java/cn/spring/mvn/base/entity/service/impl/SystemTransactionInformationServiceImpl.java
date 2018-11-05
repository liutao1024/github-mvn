package cn.spring.mvn.base.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.base.entity.SystemTransactionInformation;
import cn.spring.mvn.base.entity.dao.SystemTransactionInformationDao;
import cn.spring.mvn.base.entity.service.SystemTransactionInformationService;
@Service("SystemTransactionInformationService")
public class SystemTransactionInformationServiceImpl implements SystemTransactionInformationService{

	@Resource 
	private SystemTransactionInformationDao systemTransactionInformationDao;
	@Override
	public List<SystemTransactionInformation> selectSystemTransactionInformationList() {
		return systemTransactionInformationDao.selectSystemTransactionInformationList();
	}
	@Override
	public int insertSystemTransactionInformation(SystemTransactionInformation systemTransactionInformation) {
		return systemTransactionInformationDao.insertSystemTransactionInformation(systemTransactionInformation);
	}
	
}
