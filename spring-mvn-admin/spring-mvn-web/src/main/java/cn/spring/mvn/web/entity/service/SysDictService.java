package cn.spring.mvn.web.entity.service;

import java.util.List;

import cn.spring.mvn.base.BaseService;
import cn.spring.mvn.web.entity.SysDict;

public interface SysDictService extends BaseService<SysDict>{
	public abstract List<SysDict> selectAllByDictType(String dictType);
}
