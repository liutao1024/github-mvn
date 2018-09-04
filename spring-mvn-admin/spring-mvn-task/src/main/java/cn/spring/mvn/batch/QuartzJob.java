package cn.spring.mvn.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.base.entity.SystemDate;
import cn.spring.mvn.base.entity.service.SystemDateService;
import cn.spring.mvn.base.util.BaseUtil;
import cn.spring.mvn.batch.task.impl.BatchJobTask0001;
import cn.spring.mvn.comm.tools.DBTool;


public class QuartzJob implements Job {  
	@Autowired
	private SystemDateService systemDateServiceImpl;
    @Override  
    public void execute(JobExecutionContext content) throws JobExecutionException {
//    	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//    	String jobName = (content.getJobDetail()).getKey().getName();//getName();  
//    	JobDataMap dataMap = content.getJobDetail().getJobDataMap();  
//    	String param = dataMap.getString("param");  
//    	System.out.println("传递的参数是="+param +"任务名字是="+jobName);
//    	content.get("");
//        content.getCalendar();
//        content.getFireInstanceId();
//        content.getFireTime();
//        content.getJobDetail();
//        content.getJobInstance();
//        content.getJobRunTime();
//        content.getMergedJobDataMap();
//        content.getNextFireTime();
//        content.getPreviousFireTime();
//        content.getRecoveringTriggerKey();
//        content.getRefireCount();
//        content.getResult();
//        content.getScheduledFireTime();
//        content.getScheduler();
//        content.getTrigger();
//        content.isRecovering();
       
        /**
         * 1.定日切时间
         * 2.日切步骤
         * 3.定时任务,其实日切也是定时任务之一
         * 
         * 1)定时调度表,2)日切步骤表
         */
//      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        String hqlStr = "from SystemDate where date_type = 'system'";
//        List<SystemDate> systemDateList = systemDateServiceImpl.findAllByHql(hqlStr);
//        SystemDate systemDate = systemDateList.get(0);
//        String today = systemDate.getToday();
//        String newToDay = CommUtil.toGetDateStrByDateStr(today, 1);
//        systemDate.setTheDayBeforeYesterday(CommUtil.toGetDateStrByDateStr(newToDay,-2));
//        systemDate.setYesterday(CommUtil.toGetDateStrByDateStr(newToDay,-1));
//        systemDate.setToday(newToDay);
//        systemDate.setTomorrow(CommUtil.toGetDateStrByDateStr(newToDay,1));
//        systemDate.setTheDayAfterTomorrow(CommUtil.toGetDateStrByDateStr(newToDay,2));
//        systemDateServiceImpl.saveOrUpdate(systemDate);
        System.out.println("QuartzJob");
        try {
        	String sql = "select * from sys_date where date_type = 'system'";
        	Connection connection = DBTool.getConnection();
        	PreparedStatement preparedStatement = connection.prepareStatement(sql);
 			ResultSet resultSet = preparedStatement.executeQuery();
// 			ResultSetMetaData rsmd = resultSet.getMetaData();
 			List<SystemDate> systemDateList = new ArrayList<SystemDate>();
 			if(resultSet.next()){
 				SystemDate date = new SystemDate();
 				date.setDateType(resultSet.getString(1));
 				date.setTheDayBeforeYesterday(resultSet.getString(2));
 				date.setYesterday(resultSet.getString(3));
 				date.setToday(resultSet.getString(4));
 				date.setTomorrow(resultSet.getString(5));
 				date.setTheDayAfterTomorrow(resultSet.getString(6));
 				systemDateList.add(date);
// 				System.out.println(resultSet.getString("date_type"));
// 				System.out.println(resultSet.getString(1));
// 				System.out.println(resultSet.getString(2));
// 				System.out.println(resultSet.getString(3));
// 				System.out.println(resultSet.getString(4));
// 				System.out.println(resultSet.getString(5));
 			}
 			SystemDate systemDate = systemDateList.get(0) ;
 	        String today = systemDate.getToday();
 	        String newToDay = BaseUtil.toGetDateStrByDateStr(today, 1);
 	        String theDayBeforeYesterday = BaseUtil.toGetDateStrByDateStr(newToDay,-2);
 	        String yesterday = BaseUtil.toGetDateStrByDateStr(newToDay,-1);
 	        String todayNew = newToDay;
 	        String tomorrow = BaseUtil.toGetDateStrByDateStr(newToDay,1);
 	        String theDayAfterTomorrow = BaseUtil.toGetDateStrByDateStr(newToDay,2);
 	        
 	        String newSql = "update sys_time set day_before_yesterday = '"+theDayBeforeYesterday+"', yesterday = '"+yesterday+"', today='"+todayNew+"', tomorrow='"+tomorrow+"', day_after_tomorrow='"+theDayAfterTomorrow+"'";
 	        preparedStatement = connection.prepareStatement(newSql);
 	        int a = preparedStatement.executeUpdate();
 	        try {
				
 	        	BatchJobTask0001.executeOne();
			} catch (Exception e) {
				System.out.println("BatchJobTask0001.executeOne()" + e.getMessage());// TODO: handle exception
			}
 	        try {
 	        	
 	        	BatchJobTask0001.executeTwo();
 	        } catch (Exception e) {
 	        	System.out.println("BatchJobTask0001.executeTwo()" + e.getMessage());// TODO: handle exception
 	        }
 	        System.out.println("-----------"+a);
 	         	       
 			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
    }  
}  
