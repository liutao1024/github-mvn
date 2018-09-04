package cn.spring.mvn.base.entity.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.spring.mvn.base.BaseServiceImpl;
import cn.spring.mvn.base.entity.SystemTransaction;
import cn.spring.mvn.base.entity.service.SystemTransactionService;
import cn.spring.mvn.base.util.BaseUtil;

@Service("SystemTransactionService")
public class SystemTransactionServiceImpl extends BaseServiceImpl<SystemTransaction> implements SystemTransactionService{

	@Override
	public SystemTransaction selectOne(String corecd, String trantp) {
		SystemTransaction transaction  = null;
		String hqlStr = "from SystemTransaction where transactionCode = '" + corecd + "' and transactionType = '" + trantp + "'";
		List<SystemTransaction> list = this.findAllByHql(hqlStr);
		if(BaseUtil.isNotNull(list) && list.size() > 0){
			transaction = list.get(0);
		}
		return transaction;
	}

}
