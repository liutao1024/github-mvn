package cn.spring.mvn.basic.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.entity.SystemBatchTimeTaskDispathResult;
import cn.spring.mvn.basic.entity.service.SystemBatchTimeTaskDispathResultService;
import cn.spring.mvn.basic.hibernat.HibernatServiceImpl;

@Service("SystemBatchTimeTaskDispathResultService")
public class SystemBatchTimeTaskDispathResultServiceImpl extends HibernatServiceImpl<SystemBatchTimeTaskDispathResult> implements SystemBatchTimeTaskDispathResultService{

}
