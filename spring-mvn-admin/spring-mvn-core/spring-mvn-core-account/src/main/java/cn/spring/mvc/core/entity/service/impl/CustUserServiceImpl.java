package cn.spring.mvc.core.entity.service.impl;

import org.springframework.stereotype.Repository;

import cn.spring.mvc.base.BaseServiceImpl;
import cn.spring.mvc.core.entity.CustUser;
import cn.spring.mvc.core.entity.service.CustUserService;

@Repository("CustUserService")
public class CustUserServiceImpl extends BaseServiceImpl<CustUser>implements CustUserService{
	
}