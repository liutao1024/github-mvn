package cn.spring.mvn.task.test;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.basic.entity.SystemDate;
import cn.spring.mvn.basic.entity.service.SystemDateService;
import cn.spring.mvn.basic.util.BasicUtil;

public class TestJob {
	@Autowired
	private SystemDateService systemDateServiceImpl;
	public void tips(){  
		SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		String hqlStr = "from SystemDate where date_type = 'system'";
		List<SystemDate> systemDateList = systemDateServiceImpl.findAllByHql(hqlStr);
		SystemDate systemDate = systemDateList.get(0);
		System.out.println("-----数据库中toDay是------" + systemDate.getToday());
		String today = systemDate.getToday();
		String newToDay = BasicUtil.toGetDateStrByDateStr(today, 1);
		systemDate.setTheDayBeforeYesterday(BasicUtil.toGetDateStrByDateStr(newToDay,-2));
		systemDate.setYesterday(BasicUtil.toGetDateStrByDateStr(newToDay,-1));
		systemDate.setToday(newToDay);
		systemDate.setTomorrow(BasicUtil.toGetDateStrByDateStr(newToDay,1));
		systemDate.setTheDayAfterTomorrow(BasicUtil.toGetDateStrByDateStr(newToDay,2));
		systemDateServiceImpl.saveOrUpdate(systemDate);
		String time = simpleDateFormat.format(System.currentTimeMillis());
        System.out.println("time:"+time);  
    }  
}
