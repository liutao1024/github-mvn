package cn.spring.mvn.core.amain.entity.service.impl;

import org.springframework.stereotype.Repository;

import cn.spring.mvn.basic.ibatis.IBatisServiceImpl;
import cn.spring.mvn.core.amain.entity.BankCard;
import cn.spring.mvn.core.amain.entity.service.BankCardService;

@Repository("BankCardService")
public class BankCardServiceImpl extends IBatisServiceImpl<BankCard> implements BankCardService{

}
