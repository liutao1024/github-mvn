package cn.spring.mvn.socket.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.socket.entity.SystemTransactionInformation;
import cn.spring.mvn.socket.entity.dao.SystemTransactionInformationDao;
import cn.spring.mvn.socket.entity.service.SystemTransactionInformationService;
@Service("SystemTransactionInformationService")
public class SystemTransactionInformationServiceImpl implements SystemTransactionInformationService{

	@Resource 
	private SystemTransactionInformationDao systemTransactionInformationDao;
	@Override
	public List<SystemTransactionInformation> selectSystemTransactionInformationList() {
		return systemTransactionInformationDao.selectSystemTransactionInformationList();
	}
	
}
