package cn.spring.mvn.socket.entity.dao;

import java.util.List;

import cn.spring.mvn.socket.entity.SystemTransactionInformation;
public interface SystemTransactionInformationDao {
	public List<SystemTransactionInformation> selectSystemTransactionInformationList();
}
