package cn.spring.mvn.web.entity.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.spring.mvn.base.BaseServiceImpl;
import cn.spring.mvn.web.entity.SysDict;
import cn.spring.mvn.web.entity.service.SysDictService;

@Service("SysDictService")
public class SysDictServiceImpl extends BaseServiceImpl<SysDict> implements SysDictService{
	@Override
	public List<SysDict> selectAllByDictType(String dictType){
		String hqlStr = "from SysDict where dict_type = '" + dictType + "'";
		return this.findAllByHql(hqlStr);
	}
}
