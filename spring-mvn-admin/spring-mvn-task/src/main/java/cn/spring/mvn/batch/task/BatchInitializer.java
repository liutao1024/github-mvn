package cn.spring.mvn.batch.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.base.tools.BaseReflection;
import cn.spring.mvn.batch.QuartzManager;
import cn.spring.mvn.batch.entity.SystemBatchTimeDispathControl;
import cn.spring.mvn.batch.entity.service.SystemBatchTaskDispathControlService;
import cn.spring.mvn.batch.entity.service.SystemBatchTimeDispathControlService;
//import cn.spring.mvn.batch.tools.BatchTools;
/**
 * @author LiuTao @date 2018年6月2日 下午5:21:19
 * @ClassName: BatchJob 
 * @Description:项目启动时,执行此定时任务,在本任务中将其他的定时任务按启动起来
 * 				启动时在SystemBatchTimeDispathControl中,获取定时任务的配置并将任务添加起来
 */
@SuppressWarnings("rawtypes")
public class BatchInitializer{
	@Autowired
	private SystemBatchTimeDispathControlService systemBatchTimeDispathControlImpl;
	@Autowired
	private SystemBatchTaskDispathControlService systemBatchTaskDispathControlImpl;
	/**
	 * @author LiuTao @date 2018年6月3日 下午12:50:23 
	 * @Title: initializeBatch 
	 * @Description: TODO(Describe)
	 */
	public void initializeBatch(){
		/**
		 * 1.将所有调度状态为START的定时调度任务的状态修改为RUNING
		 */
		String hqlStr_StatusStart = "from SystemBatchTimeDispathControl where DISPATH_STATUS = 'START'";
		List<SystemBatchTimeDispathControl> systemBatchTimeDispathControlStatusStartList = 
				systemBatchTimeDispathControlImpl.findAllByHql(hqlStr_StatusStart);
		for (SystemBatchTimeDispathControl systemBatchTimeDispathControlStatusStart : systemBatchTimeDispathControlStatusStartList) {
			systemBatchTimeDispathControlStatusStart.setDispathStatus("RUNING");
		}
		systemBatchTimeDispathControlImpl.updateEntities(systemBatchTimeDispathControlStatusStartList);
		/**
		 * 2.将所有调度状态为STOP的定时调度任务的状态修改为STOPPED
		 */
		String hqlStr_StatusStop = "from SystemBatchTimeDispathControl where DISPATH_STATUS = 'STOP'";
		List<SystemBatchTimeDispathControl> systemBatchTimeDispathControlStatusStopList = 
				systemBatchTimeDispathControlImpl.findAllByHql(hqlStr_StatusStop);
		for (SystemBatchTimeDispathControl systemBatchTimeDispathControlStatusStop : systemBatchTimeDispathControlStatusStopList) {
			systemBatchTimeDispathControlStatusStop.setDispathStatus("STOPPED");
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
		for (SystemBatchTimeDispathControl systemBatchTimeDispathControlStatusRuning : systemBatchTimeDispathControlStatusRuningList) {
			String jobName = systemBatchTimeDispathControlStatusRuning.getTriggerJobGroupName();
			String jobGroupName = systemBatchTimeDispathControlStatusRuning.getTriggerJobGroupName();
			String triggerGroupName = systemBatchTimeDispathControlStatusRuning.getTriggerJobGroupName();
			String triggerGroupClassName = systemBatchTimeDispathControlStatusRuning.getTriggerJobGroupClassName();
			String triggerGroupNumber = systemBatchTimeDispathControlStatusRuning.getTriggerJobGroupNumber();
			String year = systemBatchTimeDispathControlStatusRuning.getDispathPeriodYear();
			String week = systemBatchTimeDispathControlStatusRuning.getDispathPeriodWeek();
			String month = systemBatchTimeDispathControlStatusRuning.getDispathPeriodMonth();
			String day = systemBatchTimeDispathControlStatusRuning.getDispathPeriodDay();
			String hour = systemBatchTimeDispathControlStatusRuning.getDispathPeriodHour();
			String minute = systemBatchTimeDispathControlStatusRuning.getDispathPeriodMinute();
			String second = systemBatchTimeDispathControlStatusRuning.getDispathPeriodSecond();
			String className = "cn.spring.mvn.batch.task."+triggerGroupClassName;
			//是否可以利用发射将batchJob转换成类BatchJob1001------可以的20180602
			//systemBatchTimeDispathControlStatusRuning获得corn的规则
			String  cron = (second == null ? "*": second) +" "+ (minute == null ? "*": minute) +" "+ (hour == null ? "*":hour) +" "+  
					(day == null ? "*":day) +" "+ (month == null ? "":month) +" "+ (week == null ? "":week) +" "+ (year == null ? "*":year);
			cron = "0/30 * * * * ?";//每分钟的每15秒执行一次  ----具体的cron配置不太会要看一看
			try {
				Class jobClass = BaseReflection.getClassByClassName(className);
				QuartzManager.addOrModifyJobByCron(jobClass, jobName, jobGroupName, triggerGroupName, triggerGroupNumber, cron);
				// TODO:登记成功信息
			} catch (Exception e) {
				// TODO:登记异常信息
				System.out.println(e.getMessage());
			}
		}
	}
}
