package cn.spring.mvn.batch.task;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.base.tools.BaseReflection;
import cn.spring.mvn.batch.BatchManger;
import cn.spring.mvn.batch.entity.SystemBatchTaskDispathControl;
import cn.spring.mvn.batch.entity.SystemBatchTimeTaskDispathResult;
import cn.spring.mvn.batch.entity.service.SystemBatchTaskDispathControlService;
import cn.spring.mvn.batch.entity.service.SystemBatchTimeTaskDispathResultService;
//import cn.spring.mvn.batch.tools.BatchTools;

@SuppressWarnings("rawtypes")
public class BatchJobGroup10001 extends BatchManger implements Job{
	@Autowired
	private SystemBatchTaskDispathControlService systemBatchTaskDispathControlImpl = getService(SystemBatchTaskDispathControlService.class);
	@Autowired
	private SystemBatchTimeTaskDispathResultService systemBatchTimeTaskDispathResultServiceImpl = getService(SystemBatchTimeTaskDispathResultService.class);
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(systemBatchTaskDispathControlImpl);
		System.out.println(systemBatchTimeTaskDispathResultServiceImpl);
		/**测试是否可以通过反射执行类中的方法---成功的*/
//		String className = "cn.spring.mvn.global.comm.batch.task.impl.BatchTask0001";
//		String methodName = "executeOne";
//		Class[] es = {};
//		Object[] o = {};
//		try {
//			BatchTools.executeMethodByClassNameAndMethodName(className, methodName, es, o);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		/**20180603测试使用jdbc访问数据库----成功的*/
//		try {
//        	String sql = "select * from sys_batch_task_control where TRIGGER_GROUP_NUMBER = '10001' and JOB_EXECUTE_FLAG = 'Y'";
//        	Connection connection = DBTool.getConnection();
//        	PreparedStatement preparedStatement = connection.prepareStatement(sql);
// 			ResultSet resultSet = preparedStatement.executeQuery();
// 			List<SystemBatchTaskDispathControl>  list = new ArrayList<SystemBatchTaskDispathControl>();
// 			if(resultSet.next()){
// 				SystemBatchTaskDispathControl task = new SystemBatchTaskDispathControl();
// 				task.setTRIGGER_GROUP_NUMBER(resultSet.getString("TRIGGER_GROUP_NUMBER"));
// 				task.setJOB_GROUP_NUMBER(resultSet.getString("JOB_GROUP_NUMBER"));
// 				task.setJOB_GROUP_CLASS_NAME(resultSet.getString("JOB_GROUP_CLASS_NAME"));
// 				task.setJOB_GROUP_METHOD_NAME(resultSet.getString("JOB_GROUP_METHOD_NAME"));
// 				task.setJOB_DESCRIPTION(resultSet.getString("JOB_DESCRIPTION"));
// 				task.setJOB_EXECUTE_TIME(resultSet.getString("JOB_EXECUTE_TIME"));
// 				task.setJOB_EXECUTE_FLAG(resultSet.getString("JOB_EXECUTE_FLAG"));
// 				list.add(task);
// 			}
// 			System.out.println("List<SystemBatchTaskDispathControl>  list.size:"+list.size());
// 			for (SystemBatchTaskDispathControl systemBatchTaskDispathControl : list) {
// 				String jobGroupClassName = "cn.spring.mvn.global.comm.batch.task.impl." + systemBatchTaskDispathControl.getJOB_GROUP_CLASS_NAME();
// 				String jobGroupMethodName = systemBatchTaskDispathControl.getJOB_GROUP_METHOD_NAME();
// 				System.out.println("jobGroupClassName:"+jobGroupClassName);
// 				System.out.println("jobGroupMethodName:"+jobGroupMethodName);
// 				Class[] classes = {};
// 				Object[] objects = {};
//				BatchTools.executeMethodByClassNameAndMethodName(jobGroupClassName, jobGroupMethodName, classes, objects);
//			}
//		}catch(Exception e){
//			System.out.println("-------BatchJob10001.Exception----------"+e.getMessage());
//		}
// 			SystemBatchTaskDispathControl list = systemDateList.get(0) ;
// 	        String today = systemDate.getToday();
// 	        String newToDay = CommUtil.toGetDateStrByDateStr(today, 1);
// 	        String theDayBeforeYesterday = CommUtil.toGetDateStrByDateStr(newToDay,-2);
// 	        String yesterday = CommUtil.toGetDateStrByDateStr(newToDay,-1);
// 	        String todayNew = newToDay;
// 	        String tomorrow = CommUtil.toGetDateStrByDateStr(newToDay,1);
// 	        String theDayAfterTomorrow = CommUtil.toGetDateStrByDateStr(newToDay,2);
		
		
		/**使用heibrnt访问数据库----在访问数据库是就不执行了--
		 * 通过继承父类BatchManger在实例化Service时,调用父类的getService()方法,获取实例化对象
		 *  这样就能获取到Spring容器中的bean对象
		 *  想办法service实例化时不需要调用父类的方法
		 *  在父类中直接搞好,子类中还像之前那样写
		 *  		可以考虑反射取到注解来进行实例化
		 *  父类中能取到所有的子类吗?
		 *  ------这样子运行到子类时同样为null,由于父类中通过反射实例化一个子类并给子类属性赋值成功,
		 *  当定时任务执行到子类时是实例化的一个新的子类,所以同样为空,可以考虑的是实现单列模式??????
		 * */
//		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();获取不了值
		//根据调度状态为RUNING的定时调度控制器获取批量任务控制器中的任务执行标志为'Y'的批量任务
		String TRIGGER_JOB_GROUP_NUMBER = "10001";//(String) jobDataMap.get("triggerGroupNumber");
		//获取该批次所有需要执行的Task(方法)有序的---需要根据JOB_GROUP_NUMBER排序
		String hqlStr_Flage_Y = "from SystemBatchTaskDispathControl where TRIGGER_JOB_GROUP_NUMBER = '" + TRIGGER_JOB_GROUP_NUMBER + "' and JOB_EXECUTE_FLAG = 'Y'" ;
		System.out.println(hqlStr_Flage_Y);
		List<SystemBatchTaskDispathControl> systemBatchTaskDispathControlList = 
				systemBatchTaskDispathControlImpl.findAllByHql(hqlStr_Flage_Y);
		System.out.println(systemBatchTaskDispathControlList.size());
		for (SystemBatchTaskDispathControl systemBatchTaskDispathControl : systemBatchTaskDispathControlList) {
			String status = "";
			String message = "";
			String jobClassName = "cn.spring.mvn.batch.task.impl." + systemBatchTaskDispathControl.getJobClassName();
			String jobMethodName = systemBatchTaskDispathControl.getJobMethodName();
			//同样通过发射找到类调用对应的方法
			Class[] classes = {};
			Object[] objects = {};
			try {
				BaseReflection.executeMethodByClassNameAndMethodName(jobClassName, jobMethodName, classes, objects);
				// TODO:登记执行成功信息
				status = "SUCCESS";//jobDataMap.getString("STATUS");
			} catch (Exception e) {
				// TODO:异常信息
				message = e.getMessage();
				status = "ERROR";
				//终止任务后面的task不能在执行了
				break;
			} finally {
				SystemBatchTimeTaskDispathResult entity = new SystemBatchTimeTaskDispathResult();
				try {
					entity.setTriggerJobGroupNumber("10001");
					entity.setTriggerJobGroupName(jobMethodName);
					entity.setJobNumber(systemBatchTaskDispathControl.getJobNumber());
					entity.setJobName(jobMethodName);
					entity.setTimeTaskDispathDate(new Date());
					entity.setTimeTaskDispathErrorMessage(message);
					entity.setTimeTaskDispathStatus(status);
					systemBatchTimeTaskDispathResultServiceImpl.saveEntity(entity);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
