package cn.spring.mvn.batch.task.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.base.entity.SystemDate;
import cn.spring.mvn.base.entity.service.SystemDateService;
import cn.spring.mvn.batch.BatchManger;
import cn.spring.mvn.comm.tools.SequenceTool;

public class BatchJobTask0001 extends BatchManger{
	
	@Autowired
	private static SystemDateService systemDateServiceImpl = getService(SystemDateService.class);
	
	public static void executeOne() throws Exception {
		try {
			List<SystemDate> dateList = systemDateServiceImpl.findAllByHql("from SystemDate where date_type = 'system'");
			for (SystemDate systemDate : dateList) {
				System.out.println("-----executeOne-----toDay:"+systemDate.getToday());
				String s = SequenceTool.getSequence("ELECTRON");
				String a = SequenceTool.getSequence("USER");
				String b = SequenceTool.getSequence("ACCOUNT");
				System.out.println("------liutao-----" + s);
				System.out.println("------liutao-----" + a);
				System.out.println("------liutao-----" + b);
			}
		} catch (Exception e) {
			System.out.println("-----executeOne-----Exception:"+ e);
			throw e;
		}
	}

	public static void executeTwo() throws Exception {
//		List<SystemDate> dateList = systemDateServiceImpl.findAllByHql("from SystemDate where date_type = 'system'");
//		for (SystemDate systemDate : dateList) {
//			System.out.println("-----executeTwo-----toDay:"+systemDate.getToday());
//		}
	}
}
