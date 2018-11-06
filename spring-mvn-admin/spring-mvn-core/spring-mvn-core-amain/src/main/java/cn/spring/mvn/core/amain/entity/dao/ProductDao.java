package cn.spring.mvn.core.amain.entity.dao;

import java.util.List;

import cn.spring.mvn.core.amain.entity.Product;

public interface ProductDao {
	public List<Product> selectAll();
}
