package cn.spring.mvn.core.amain.entity.service;

import java.util.List;

import cn.spring.mvn.basic.ibatis.IBatisService;
import cn.spring.mvn.core.amain.entity.Electron;

public interface ElectronService extends IBatisService<Electron>{
	public List<Electron> selectAll();
}