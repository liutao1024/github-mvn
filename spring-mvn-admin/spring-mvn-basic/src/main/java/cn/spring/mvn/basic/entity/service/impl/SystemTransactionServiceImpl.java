package cn.spring.mvn.basic.entity.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.entity.SystemTransaction;
import cn.spring.mvn.basic.entity.service.SystemTransactionService;
import cn.spring.mvn.basic.hibernat.HibernatServiceImpl;
import cn.spring.mvn.basic.util.BasicUtil;

@Service("SystemTransactionService")
public class SystemTransactionServiceImpl extends HibernatServiceImpl<SystemTransaction> implements SystemTransactionService{

	@Override
	public SystemTransaction selectOne(String prcscd, String trantp) {
		SystemTransaction transaction  = null;
		String hqlStr = "from SystemTransaction where transactionCode = '" + prcscd + "' ";
		if(BasicUtil.isNotNull(trantp)){
			hqlStr = hqlStr + "and transactionType = '" + trantp + "'";
		}
		List<SystemTransaction> list = this.findAllByHql(hqlStr);
		if(BasicUtil.isNotNull(list) && list.size() > 0){
			transaction = list.get(0);
		}
		return transaction;
	}

}
