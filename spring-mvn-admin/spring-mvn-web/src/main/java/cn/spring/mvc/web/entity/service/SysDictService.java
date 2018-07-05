package cn.spring.mvc.web.entity.service;

import java.util.List;

import cn.spring.mvc.base.BaseService;
import cn.spring.mvc.web.entity.SysDict;

public interface SysDictService extends BaseService<SysDict>{
	public abstract List<SysDict> selectAllByDictType(String dictType);
}
