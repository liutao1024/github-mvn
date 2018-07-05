package cn.spring.mvc.batch.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LiuTao @date 2018年6月1日 下午11:57:29
 * @ClassName: SystemBatchTimeTaskResult 
 * @Description: 定时任务调度(执行)结果
 */
@Entity
@Table(name = "sys_bacth_timer_task_result")
public class SystemBatchTimeTaskDispathResult implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 6075455766727397252L;
	
	@Id
	@Column(name = "TRIGGER_JOB_GROUP_NUMBER", nullable = false, length = 24)
	private String triggerJobGroupNumber;//定时任务组批次号 
	@Id
	@Column(name = "TIME_TASK_DISPATH_DATE", nullable = false)
	private Date timeTaskDispathDate;//定时任务执行时间
	@Id
	@Column(name = "JOB_NUMBER", nullable = false, length = 24)
	private String jobNumber;//任务执行编号
	@Column(name = "JOB_NAME", length = 24)
	private String jobName;//任务名称
	@Column(name = "TRIGGER_JOB_GROUP_NAME", length = 24)
	private String triggerJobGroupName;//定时任务组名称
	@Column(name = "TIME_TASK_DISPATH_ERROR_MESSAGE", length = 255)
	private String timeTaskDispathErrorMessage;//定时任务调度错误信息
	@Column(name = "TIME_TASK_DISPATH_STATUS", length = 255)
	private String timeTaskDispathStatus;//定时任务调度状态
	
	public String getTriggerJobGroupNumber() {
		return triggerJobGroupNumber;
	}
	public void setTriggerJobGroupNumber(String triggerJobGroupNumber) {
		this.triggerJobGroupNumber = triggerJobGroupNumber;
	}
	public Date getTimeTaskDispathDate() {
		return timeTaskDispathDate;
	}
	public void setTimeTaskDispathDate(Date timeTaskDispathDate) {
		this.timeTaskDispathDate = timeTaskDispathDate;
	}
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getTriggerJobGroupName() {
		return triggerJobGroupName;
	}
	public void setTriggerJobGroupName(String triggerJobGroupName) {
		this.triggerJobGroupName = triggerJobGroupName;
	}
	public String getTimeTaskDispathErrorMessage() {
		return timeTaskDispathErrorMessage;
	}
	public void setTimeTaskDispathErrorMessage(String timeTaskDispathErrorMessage) {
		this.timeTaskDispathErrorMessage = timeTaskDispathErrorMessage;
	}
	public String getTimeTaskDispathStatus() {
		return timeTaskDispathStatus;
	}
	public void setTimeTaskDispathStatus(String timeTaskDispathStatus) {
		this.timeTaskDispathStatus = timeTaskDispathStatus;
	}
}
