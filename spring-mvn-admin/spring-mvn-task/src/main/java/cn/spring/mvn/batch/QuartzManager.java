package cn.spring.mvn.batch;

import java.util.Calendar;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
/**
 * @author LiuTao @date 2018年6月1日 下午3:53:17
 * @ClassName: TaskManager 
 * @Description: 任务管理器
 */
public class QuartzManager {
	
	private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
	/**
	 * @author LiuTao @date 2018年6月5日 上午11:09:58 
	 * @Title: addOrModifyJobByCron 
	 * @Description:  添加一个定时任务,使用传入的任务组名,触发器名,触发器组名
	 * @param jobClass 任务
	 * @param jobName 任务名
	 * @param triggerGroupName 定时器组
	 * @param jobGroupName 任务组名
	 * @param cron 定时规则
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void addOrModifyJobByCron(Class jobClass, String jobName, String jobGroupName, String triggerGroupName, String triggerGroupNumber, String cron) throws Exception{
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			TriggerKey triggerKey = new TriggerKey(jobName, triggerGroupName);
			Trigger trigger = scheduler.getTrigger(triggerKey);
			if(trigger == null){
				// job 唯一标识 
				JobKey jobKey = new JobKey(jobName,jobGroupName);
				// 任务名,任务组,任务执行类
				JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobKey).build();
				// 触发器
				CronTrigger cronTrigger = TriggerBuilder
										.newTrigger()
										.withIdentity(triggerKey)
										.withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
				// 触发器时间设定
				scheduler.scheduleJob(jobDetail,cronTrigger);
				// 启动
				if (!scheduler.isShutdown()) {
					scheduler.start();
				}
				// 以上步骤没有问题,设置参数到JobDataMap中在JobGroup中获取
				jobDetail.getJobDataMap().put("STATUS", "SUCESS");
				jobDetail.getJobDataMap().put("jobName", jobName);
				jobDetail.getJobDataMap().put("jobGroupName", jobGroupName);
				jobDetail.getJobDataMap().put("triggerGroupName", triggerGroupName);
				jobDetail.getJobDataMap().put("triggerGroupNumber", triggerGroupNumber);
			}else {
				CronTrigger cronTrigger = (CronTrigger) trigger;
				String oldCron = cronTrigger.getCronExpression();
				if(!(oldCron.equalsIgnoreCase(cron))){
					removeJob(jobName, triggerGroupName, jobGroupName);
					addOrModifyJobByCron(jobClass, jobName, jobGroupName, triggerGroupName, triggerGroupNumber, cron);
				}
			}
		} catch (SchedulerException e) {
			throw e;
		}
	}
	
	/**
	 * @author LiuTao @date 2018年6月4日 下午11:25:17 
	 * @Title: addJobByCron 
	 * @Description:  添加一个定时任务,使用传入的任务组名,触发器名,触发器组名
	 * @param jobClass 任务
	 * @param jobName 任务名
	 * @param triggerGroupName 定时器组
	 * @param jobGroupName 任务组名
	 * @param cron 定时规则
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void addJobByCron(Class jobClass, String jobName, String triggerGroupName, String jobGroupName, String cron) {
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			// job 唯一标识 
			JobKey jobKey = new JobKey(jobName,jobGroupName);
			// 任务名,任务组,任务执行类
			JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobKey).build();
			// 触发器
			TriggerKey triggerKey = new TriggerKey(jobName, triggerGroupName);
			CronTrigger cronTrigger = TriggerBuilder
									.newTrigger()
									.withIdentity(triggerKey)
									.withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
			// 触发器时间设定
			scheduler.scheduleJob(jobDetail,cronTrigger);
			// 启动
			if (!scheduler.isShutdown()) {
				scheduler.start();
			}
			// 以上步骤没有问题传递参数STATUS为SUCCESS
			jobDetail.getJobDataMap().put("STATUS", "SUCCESS");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * @author LiuTao @date 2018年6月4日 下午11:28:21 
	 * @Title: modifyJobByCron 
	 * @Description: 修改指定任务的触发时间(使用默认的任务组名,触发器名,触发器组名) 
	 * @param jobName 任务名
	 * @param triggerGroupName 定时器组
	 * @param jobGroupName 任务组名
	 * @param cron 定时规则
	 */
	@SuppressWarnings("rawtypes")
	public static void modifyJobByCron(String jobName, String triggerGroupName, String jobGroupName, String cron) {
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			TriggerKey triggerKey = new TriggerKey(jobName, triggerGroupName);
			CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			if (cronTrigger == null) {
				return;
			}else {
				String oldCron = cronTrigger.getCronExpression();
				if(!(oldCron.equalsIgnoreCase(cron))){
					JobKey jobKey = new JobKey(jobName, jobGroupName);
					JobDetail jobDetail = scheduler.getJobDetail(jobKey);
					Class jobClass = jobDetail.getJobClass();
					removeJob(jobName, triggerGroupName, jobGroupName);
					addJobByCron(jobClass, jobName, triggerGroupName, jobGroupName, cron);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * @author LiuTao @date 2018年6月1日 下午12:04:30 
	 * @Title: addJob 
	 * @Description: 添加一个定时任务,使用存入的任务组名,触发器名,触发器组名
	 * @param jobName 任务名
	 * @param cls 任务
	 * @param time 时间设置
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void addJobByTime(Class jobClass, String jobName, String triggerGroupName, String jobGroupName, long time) {
		Date date = new Date();
		Calendar ca = Calendar.getInstance();
		long millis = date.getTime() + time;
		ca.setTimeInMillis(millis);
		date = ca.getTime();
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			// job 唯一标识 
			JobKey jobKey = new JobKey(jobName,jobGroupName);
			// 任务名,任务组,任务执行类
			JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobKey).build();
			// 触发器
			TriggerKey triggerKey = new TriggerKey(jobName, triggerGroupName);
			Trigger trigger = TriggerBuilder
					.newTrigger()
					.withIdentity(triggerKey)
					// 延迟一秒执行
					.startAt(date)
					// 每隔一秒执行 并一直重复
					.withSchedule(
							SimpleScheduleBuilder.simpleSchedule()
									.withIntervalInSeconds(10).repeatForever())
					.build();
			// 触发器时间设定
			scheduler.scheduleJob(jobDetail, trigger);
			// 启动
			if (!scheduler.isShutdown()) {
				scheduler.start();
			}
			// 以上步骤没有问题传递参数STATUS为SUCCESS
			jobDetail.getJobDataMap().put("STATUS", "SUCCESS");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * @author LiuTao @date 2018年6月1日 下午12:04:11 
	 * @Title: modifyJobTime 
	 * @Description: 修改一个任务的触发时间(使用默认的任务组名,触发器名,触发器组名)
	 * @param jobName
	 * @param time
	 */
	@SuppressWarnings("rawtypes")
	public static void modifyJobByTime(String jobName, String triggerGroupName, String jobGroupName, long time) {
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			TriggerKey triggerKey = new TriggerKey(jobName, triggerGroupName);
			Trigger trigger = scheduler.getTrigger(triggerKey);
			if (trigger == null) {
				return;
			}else {
				JobKey jobKey = new JobKey(jobName, jobGroupName);
				JobDetail jobDetail = scheduler.getJobDetail(jobKey);
				Class jobClass = jobDetail.getJobClass();
				removeJob(jobName, triggerGroupName, jobGroupName);
				addJobByTime(jobClass, jobName, triggerGroupName, jobGroupName, time);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @author LiuTao @date 2018年6月1日 下午12:03:58 
	 * @Title: removeJob 
	 * @Description: 移除一个任务(使用默认的任务组名,触发器名,触发器组名)
	 * @param jobName
	 */
	public static void removeJob(String jobName, String triggerGroupName, String jobGroupName) {
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			TriggerKey triggerkey = new TriggerKey(jobName, triggerGroupName);
			JobKey jobKey = new JobKey(jobName, jobGroupName);
			scheduler.pauseTrigger(triggerkey);// 停止触发器
			scheduler.unscheduleJob(triggerkey);// 移除触发器
			scheduler.deleteJob(jobKey);// 删除任务
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @author LiuTao @date 2018年6月1日 下午12:03:45 
	 * @Title: startJobs 
	 * @Description: 启动所有定时任务
	 */
	public static void startJobs() {
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @author LiuTao @date 2018年6月1日 下午12:03:34 
	 * @Title: shutdownJobs 
	 * @Description: 关闭所有定时任务
	 */
	public static void shutdownJobs() {
		try {
			Scheduler sched = schedulerFactory.getScheduler();
			if (!sched.isShutdown()) {
				sched.shutdown();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
