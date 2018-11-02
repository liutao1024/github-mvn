package cn.spring.mvn.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.base.entity.service.SystemDateService;
import cn.spring.mvn.base.tools.BaseReflection;
import cn.spring.mvn.comm.util.CommUtil;
import cn.spring.mvn.task.entity.SystemBatchTimeDispathControl;
import cn.spring.mvn.task.entity.service.SystemBatchTaskDispathControlService;
import cn.spring.mvn.task.entity.service.SystemBatchTimeDispathControlService;
//import cn.spring.mvn.batch.tools.BatchTools;
/**
 * @author LiuTao @date 2018年6月2日 下午5:21:19
 * @ClassName: BatchJob 
 * @Description:项目启动时,执行此定时任务,在本任务中将其他的定时任务按启动起来
 * 				启动时在SystemBatchTimeDispathControl中,获取定时任务的配置并将任务添加起来
 * 
 * 
 */
public class TaskInitializer{
	@Autowired
	private SystemBatchTimeDispathControlService systemBatchTimeDispathControlImpl;
	@Autowired
	private SystemBatchTaskDispathControlService systemBatchTaskDispathControlImpl;
	@Autowired
	private SystemDateService s;
	/**
	 * @author LiuTao @date 2018年6月3日 下午12:50:23 
	 * @Title: initializeBatch 
	 * @Description: 项目启动时,这个方法配置spring-quartz.xml中作为定时任务启动,频率为一分钟执行一次(0 * * * * ?)
	 * 					通过这个定时任务对系统中其他的定时任务做:
	 * 							1.初始化
	 * 							2.改变调度时间
	 * 							3.关闭(暂未实现)
	 * 时间到了执行定时任务***JobGroup**.java
	 */		
	public void initializeTasks(){
		try {
			/**
			 * 1.将所有调度状态为START的定时调度任务的状态修改为RUNING
			 */
			String hqlStr_StatusStart = "from SystemBatchTimeDispathControl where DISPATH_STATUS = 'START'";
//			String hqlStr_StatusStart = "from SystemDate";
//			List<SystemDate> li = s.findAllByHql(hqlStr_StatusStart);
//			for (SystemDate systemDate : li) {
//				System.out.println(systemDate.getToday());
//			}
			List<SystemBatchTimeDispathControl> systemBatchTimeDispathControlStatusStartList = 
					systemBatchTimeDispathControlImpl.findAllByHql(hqlStr_StatusStart);
			for (SystemBatchTimeDispathControl entity : systemBatchTimeDispathControlStatusStartList) {
				entity.setDispathStatus("RUNING");
			}
			systemBatchTimeDispathControlImpl.updateEntities(systemBatchTimeDispathControlStatusStartList);
			/**
			 * 2.将所有调度状态为STOP的定时调度任务的状态修改为STOPPED
			 */
			String hqlStr_StatusStop = "from SystemBatchTimeDispathControl where DISPATH_STATUS = 'STOP'";
			List<SystemBatchTimeDispathControl> systemBatchTimeDispathControlStatusStopList = 
					systemBatchTimeDispathControlImpl.findAllByHql(hqlStr_StatusStop);
			for (SystemBatchTimeDispathControl entity : systemBatchTimeDispathControlStatusStopList) {
				entity.setDispathStatus("STOPPED");
			}
			systemBatchTimeDispathControlImpl.updateEntities(systemBatchTimeDispathControlStatusStopList);
			/**
			 * 3.获取所有调度状态为RUNING的定时调度任务
			 */
			String hqlStr_StatusRuning = "from SystemBatchTimeDispathControl where DISPATH_STATUS = 'RUNING'";
			List<SystemBatchTimeDispathControl> systemBatchTimeDispathControlStatusRuningList = 
					systemBatchTimeDispathControlImpl.findAllByHql(hqlStr_StatusRuning);
			/**
			 * 4.将定时任务添加到Spring容器中----RUNING状态排序就没必要了
			 */
			for (SystemBatchTimeDispathControl entity : systemBatchTimeDispathControlStatusRuningList) {
				String jobName = entity.getTriggerJobGroupName();
				String jobGroupName = entity.getTriggerJobGroupName();
				String triggerGroupName = entity.getTriggerJobGroupName();
				String triggerGroupNumber = entity.getTriggerJobGroupNumber();
				String triggerGroupPath = entity.getTriggerJobGroupPath();
				String triggerGroupModule = entity.getTriggerJobGroupModule();
				String triggerGroupClass = entity.getTriggerJobGroupClass();
				String year = entity.getDispathPeriodYear();
				String week = entity.getDispathPeriodWeek();
				String month = entity.getDispathPeriodMonth();
				String day = entity.getDispathPeriodDay();
				String hour = entity.getDispathPeriodHour();
				String minute = entity.getDispathPeriodMinute();
				String second = entity.getDispathPeriodSecond();
				String className = triggerGroupPath + CommUtil.DOT + triggerGroupModule + CommUtil.JOB + triggerGroupClass;//定时任务的入口类
				//是否可以利用发射将batchJob转换成类BatchJob1001------可以的20180602
				//systemBatchTimeDispathControlStatusRuning获得corn的规则
				String  cron = (second == null ? "*": second) +" "+ (minute == null ? "*": minute) +" "+ (hour == null ? "*":hour) +" "+  
						(day == null ? "*":day) +" "+ (month == null ? "":month) +" "+ (week == null ? "":week) +" "+ (year == null ? "*":year);
				cron = "0/30 * * * * ?";//每分钟的每15秒执行一次  ----具体的cron配置不太懂,需要看一看
				try {
					Class<?> jobClass = BaseReflection.getClassByClassName(className);
					//添加或修改定时任务
					TaskManager.addOrModifyJobByCron(jobClass, jobName, jobGroupName, triggerGroupName, triggerGroupNumber, cron);
					// TODO:登记成功信息
				} catch (Exception e) {
					// TODO:登记异常信息
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
