package cn.spring.mvn.base.entity.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.spring.mvn.base.BaseServiceImpl;
import cn.spring.mvn.base.entity.SystemSequence;
import cn.spring.mvn.base.entity.service.SystemSequenceService;
import cn.spring.mvn.base.util.BaseUtil;

@Service("SystemSequenceService")
public class SystemSequenceServiceImpl extends BaseServiceImpl<SystemSequence> implements SystemSequenceService{

	@Override
	public SystemSequence selectOne(String sequenceType) {
		SystemSequence sequence  = null;
		String hqlStr = "from SystemSequence where sequencetype = '" + sequenceType + "'";
		List<SystemSequence> list = this.findAllByHql(hqlStr);
		if(BaseUtil.isNotNull(list) && list.size() > 0){
			sequence = list.get(0);
		}
		return sequence;
	}

}
