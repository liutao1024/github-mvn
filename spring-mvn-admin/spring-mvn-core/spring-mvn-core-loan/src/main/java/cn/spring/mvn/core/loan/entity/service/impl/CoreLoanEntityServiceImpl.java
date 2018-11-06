package cn.spring.mvn.core.loan.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.core.loan.entity.CoreLoanEntity;
import cn.spring.mvn.core.loan.entity.dao.CoreLoanEntityDao;
import cn.spring.mvn.core.loan.entity.service.CoreLoanEntityService;


@Service("CoreLoanEntityService")
public class CoreLoanEntityServiceImpl implements CoreLoanEntityService{
	@Resource
	private CoreLoanEntityDao dao;
	@Override
	public List<CoreLoanEntity> selectCoreLoanEntityList() {
		return dao.selectCoreLoanEntityList();
	}

}
