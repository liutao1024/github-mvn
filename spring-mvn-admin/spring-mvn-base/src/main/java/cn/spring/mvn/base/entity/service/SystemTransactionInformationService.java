package cn.spring.mvn.base.entity.service;

import java.util.List;

import cn.spring.mvn.base.entity.SystemTransactionInformation;

public interface SystemTransactionInformationService {
	public List<SystemTransactionInformation> selectSystemTransactionInformationList();
	public int insertSystemTransactionInformation(SystemTransactionInformation systemTransactionInformation);
}
