package cn.spring.mvn.core.entity.service.impl;

import org.springframework.stereotype.Repository;

import cn.spring.mvn.base.BaseServiceImpl;
import cn.spring.mvn.core.entity.CustUser;
import cn.spring.mvn.core.entity.service.CustUserService;

@Repository("CustUserService")
public class CustUserServiceImpl extends BaseServiceImpl<CustUser>implements CustUserService{
	
}