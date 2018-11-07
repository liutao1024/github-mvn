package cn.spring.mvn.core.amain.entity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.spring.mvn.core.amain.entity.CoreMain;
import cn.spring.mvn.core.amain.entity.dao.CoreMainDao;
import cn.spring.mvn.core.amain.entity.service.CoreMainService;

@Repository("CoreMainService")
public class CoreMainServiceImpl implements CoreMainService{

	@Autowired
	private CoreMainDao dao;
	
	@Override
	public List<CoreMain> selectEntityList(String id){
		return dao.selectEntityList(id);
	}
	
	@Override
	public CoreMain selectEntity(String id) {
		return dao.selectOneEntityByPK(id);
	}

	@Override
	public Integer insertEntity(CoreMain entity) {
		return dao.insertOneEntity(entity);
	}

}
