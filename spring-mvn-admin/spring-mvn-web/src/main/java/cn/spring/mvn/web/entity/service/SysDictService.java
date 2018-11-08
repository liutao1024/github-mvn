package cn.spring.mvn.web.entity.service;

import java.util.List;

import cn.spring.mvn.basic.hibernat.HibernatService;
import cn.spring.mvn.web.entity.SysDict;

public interface SysDictService extends HibernatService<SysDict>{
	public abstract List<SysDict> selectAllByDictType(String dictType);
}
