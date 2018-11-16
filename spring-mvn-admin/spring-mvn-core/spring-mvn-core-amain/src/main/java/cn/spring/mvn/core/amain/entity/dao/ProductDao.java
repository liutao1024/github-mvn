package cn.spring.mvn.core.amain.entity.dao;

import java.util.List;

import cn.spring.mvn.basic.ibatis.IBatisDao;
import cn.spring.mvn.core.amain.entity.Product;

public interface ProductDao extends IBatisDao<Product> {
	public List<Product> selectAll();
}
