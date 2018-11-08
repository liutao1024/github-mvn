package cn.spring.mvn.basic.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.entity.SystemParam;
import cn.spring.mvn.basic.entity.service.SystemParamService;
import cn.spring.mvn.basic.hibernat.HibernatServiceImpl;

@Service("SystemParamService")
public class SystemParamServiceImpl extends HibernatServiceImpl<SystemParam> implements SystemParamService{

}
