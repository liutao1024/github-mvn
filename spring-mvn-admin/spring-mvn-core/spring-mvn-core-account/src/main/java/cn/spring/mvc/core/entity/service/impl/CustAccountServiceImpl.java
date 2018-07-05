package cn.spring.mvc.core.entity.service.impl;

import org.springframework.stereotype.Repository;

import cn.spring.mvc.base.BaseServiceImpl;
import cn.spring.mvc.core.entity.CustAccount;
import cn.spring.mvc.core.entity.service.CustAccountService;

@Repository("CustAccountService")
public class CustAccountServiceImpl extends BaseServiceImpl<CustAccount>implements CustAccountService{
	
}