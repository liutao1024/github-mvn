package cn.spring.mvn.basic.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.entity.SystemDate;
import cn.spring.mvn.basic.entity.service.SystemDateService;
import cn.spring.mvn.basic.hibernat.HibernatServiceImpl;

@Service("SystemDateService")
public class SystemDateServiceImpl extends HibernatServiceImpl<SystemDate> implements SystemDateService{

}
