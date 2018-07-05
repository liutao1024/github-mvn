package cn.spring.mvc.batch;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvc.base.entity.SystemDate;
import cn.spring.mvc.base.entity.service.SystemDateService;
import cn.spring.mvc.base.util.BaseUtil;

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
		String newToDay = BaseUtil.toGetDateStrByDateStr(today, 1);
		systemDate.setTheDayBeforeYesterday(BaseUtil.toGetDateStrByDateStr(newToDay,-2));
		systemDate.setYesterday(BaseUtil.toGetDateStrByDateStr(newToDay,-1));
		systemDate.setToday(newToDay);
		systemDate.setTomorrow(BaseUtil.toGetDateStrByDateStr(newToDay,1));
		systemDate.setTheDayAfterTomorrow(BaseUtil.toGetDateStrByDateStr(newToDay,2));
		systemDateServiceImpl.saveOrUpdate(systemDate);
		String time = simpleDateFormat.format(System.currentTimeMillis());
        System.out.println("time:"+time);  
    }  
}
