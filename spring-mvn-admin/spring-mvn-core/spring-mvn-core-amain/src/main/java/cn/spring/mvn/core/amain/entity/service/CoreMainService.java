package cn.spring.mvn.core.amain.entity.service;

import java.util.List;

import cn.spring.mvn.core.amain.entity.CoreMain;

public interface CoreMainService {
	CoreMain selectEntity(String id);
	List<CoreMain> selectEntityList(String id);
	Integer insertEntity(CoreMain coreMain);
	List<CoreMain> selectAll(CoreMain entity);
}
