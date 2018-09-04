package cn.spring.mvn.core.entity.service.impl;

import org.springframework.stereotype.Repository;

import cn.spring.mvn.base.BaseServiceImpl;
import cn.spring.mvn.core.entity.CustAccount;
import cn.spring.mvn.core.entity.service.CustAccountService;

@Repository("CustAccountService")
public class CustAccountServiceImpl extends BaseServiceImpl<CustAccount>implements CustAccountService{
	
}