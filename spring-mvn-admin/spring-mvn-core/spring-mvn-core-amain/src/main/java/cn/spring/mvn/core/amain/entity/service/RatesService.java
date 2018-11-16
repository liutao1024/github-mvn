package cn.spring.mvn.core.amain.entity.service;

import java.util.List;

import cn.spring.mvn.basic.ibatis.IBatisService;
import cn.spring.mvn.core.amain.entity.Rates;

public interface RatesService extends IBatisService<Rates>{
	public List<Rates> selectAll();
}
