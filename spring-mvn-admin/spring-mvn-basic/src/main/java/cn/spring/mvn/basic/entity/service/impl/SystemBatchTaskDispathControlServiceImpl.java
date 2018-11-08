package cn.spring.mvn.basic.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.entity.SystemBatchTaskDispathControl;
import cn.spring.mvn.basic.entity.service.SystemBatchTaskDispathControlService;
import cn.spring.mvn.basic.hibernat.HibernatServiceImpl;

@Service("SystemBatchTaskDispathControlService")
public class SystemBatchTaskDispathControlServiceImpl extends HibernatServiceImpl<SystemBatchTaskDispathControl> implements SystemBatchTaskDispathControlService{

}
