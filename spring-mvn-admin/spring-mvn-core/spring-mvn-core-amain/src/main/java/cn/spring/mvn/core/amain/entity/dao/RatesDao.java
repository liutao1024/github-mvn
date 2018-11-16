package cn.spring.mvn.core.amain.entity.dao;

import java.util.List;

import cn.spring.mvn.basic.ibatis.IBatisDao;
import cn.spring.mvn.core.amain.entity.Rates;

public interface RatesDao extends IBatisDao<Rates>{
	public List<Rates> selectAll();
}
