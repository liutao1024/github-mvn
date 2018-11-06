package cn.spring.mvn.core.account.entity.dao;

import java.util.List;

import cn.spring.mvn.core.account.entity.CoreProduct;

public interface CoreProductDao {
	public List<CoreProduct> selectCorePorductList();
}
