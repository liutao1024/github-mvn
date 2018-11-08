package cn.spring.mvn.basic.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.entity.SystemBatchTimeDispathControl;
import cn.spring.mvn.basic.entity.service.SystemBatchTimeDispathControlService;
import cn.spring.mvn.basic.hibernat.HibernatServiceImpl;

@Service("SystemBatchTimeDispathControlService")
public class SystemBatchTimeDispathControlServiceImpl extends HibernatServiceImpl<SystemBatchTimeDispathControl> implements SystemBatchTimeDispathControlService{

}
