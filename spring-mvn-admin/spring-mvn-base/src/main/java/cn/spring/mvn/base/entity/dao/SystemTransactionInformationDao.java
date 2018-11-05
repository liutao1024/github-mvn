package cn.spring.mvn.base.entity.dao;

import java.util.List;

import cn.spring.mvn.base.entity.SystemTransactionInformation;
public interface SystemTransactionInformationDao {
	public List<SystemTransactionInformation> selectSystemTransactionInformationList();
	public int insertSystemTransactionInformation(SystemTransactionInformation systemTransactionInformation);
}
