package cn.spring.mvn.core.job.impl;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.base.entity.SystemDate;
import cn.spring.mvn.base.entity.service.SystemDateService;
import cn.spring.mvn.base.util.BaseUtil;
import cn.spring.mvn.comm.util.SpringContextUtil;

public class CoreJobTask {
	@Autowired
	private static SystemDateService systemDateServiceImpl = SpringContextUtil.getBean(SystemDateService.class);
	
	public static void changeDate() throws ParseException{
		SystemDate coreDate = systemDateServiceImpl.findOneByHql("from SystemDate where date_type = 'system'");
		String coreToDay = coreDate.getToday();
		SystemDate accaDate = systemDateServiceImpl.findOneByHql("from SystemDate where date_type = 'acca'");
		String accaToDay = accaDate.getToday();
		System.out.println("-----changeDate-----coreToDay:" + coreToDay);
		System.out.println("-----changeDate-----accaToDay:" + accaToDay);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		coreDate.setTheDayBeforeYesterday(BaseUtil.toGetDateStrByDateStr(coreDate.getTheDayBeforeYesterday(), 1));
		coreDate.setYesterday(BaseUtil.toGetDateStrByDateStr(coreDate.getYesterday(), 1));
		coreDate.setToday(BaseUtil.toGetDateStrByDateStr(coreDate.getToday(), 1));
		coreDate.setTomorrow(BaseUtil.toGetDateStrByDateStr(coreDate.getTomorrow(), 1));
		coreDate.setTheDayAfterTomorrow(BaseUtil.toGetDateStrByDateStr(coreDate.getTheDayAfterTomorrow(), 1));
		
		accaDate.setTheDayBeforeYesterday(BaseUtil.toGetDateStrByDateStr(accaDate.getTheDayBeforeYesterday(), 1));
		accaDate.setYesterday(BaseUtil.toGetDateStrByDateStr(accaDate.getYesterday(), 1));
		accaDate.setToday(BaseUtil.toGetDateStrByDateStr(accaDate.getToday(), 1));
		accaDate.setTomorrow(BaseUtil.toGetDateStrByDateStr(accaDate.getTomorrow(), 1));
		accaDate.setTheDayAfterTomorrow(BaseUtil.toGetDateStrByDateStr(accaDate.getTheDayAfterTomorrow(), 1));
		
		systemDateServiceImpl.saveOrUpdate(coreDate);
		systemDateServiceImpl.saveOrUpdate(accaDate);
//		BaseUtil.toGetDateStrByDateStr(coreToDay, 1);
//		Date d1 = DateTool.addDays(sdf.parse(coreToDay), 1);
//		Date d2 = DateTool.addDays(sdf.parse(coreToDay), 1);
		
	}
}
