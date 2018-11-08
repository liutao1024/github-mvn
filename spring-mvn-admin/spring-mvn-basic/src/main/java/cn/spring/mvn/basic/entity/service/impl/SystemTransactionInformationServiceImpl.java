package cn.spring.mvn.basic.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.entity.SystemTransactionInformation;
import cn.spring.mvn.basic.entity.service.SystemTransactionInformationService;
import cn.spring.mvn.basic.hibernat.HibernatServiceImpl;

@Service("SystemTransactionInformationService")
public class SystemTransactionInformationServiceImpl extends HibernatServiceImpl<SystemTransactionInformation> implements SystemTransactionInformationService{
//
//	@Resource 
//	private SystemTransactionInformationDao systemTransactionInformationDao;
//	@Override
//	public List<SystemTransactionInformation> selectSystemTransactionInformationList() {
//		return systemTransactionInformationDao.selectSystemTransactionInformationList();
//	}
//	@Override
//	public int insertSystemTransactionInformation(SystemTransactionInformation systemTransactionInformation) {
//		return systemTransactionInformationDao.insertSystemTransactionInformation(systemTransactionInformation);
//	}
	
}
