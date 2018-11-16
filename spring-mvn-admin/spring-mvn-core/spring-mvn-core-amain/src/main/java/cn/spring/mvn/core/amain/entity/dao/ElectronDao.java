package cn.spring.mvn.core.amain.entity.dao;

import java.util.List;

import cn.spring.mvn.basic.ibatis.IBatisDao;
import cn.spring.mvn.core.amain.entity.Electron;

public interface ElectronDao extends IBatisDao<Electron>{
	public List<Electron> selectAll();
}
