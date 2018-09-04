package cn.spring.mvn.batch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LiuTao @date 2018年6月1日 下午11:29:08
 * @ClassName: SystemBatchTaskDispathControl 
 * @Description: 批量任务控制器
 */
@Entity
@Table(name = "sys_batch_task_control")
public class SystemBatchTaskDispathControl implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 7926125672640251235L;
	
	@Id
	@Column(name = "TRIGGER_JOB_GROUP_NUMBER", nullable = false, length = 24)
	private String triggerJobGroupNumber;//定时任务组批次号
	@Id
	@Column(name = "JOB_NUMBER", nullable = false, length = 24)
	private String jobNumber;//任务执行步骤号
	@Column(name = "JOB_CLASS_NAME", nullable = false, length = 24)
	private String jobClassName;//任务类名 
	@Column(name = "JOB_METHOD_NAME", nullable = false, length = 24)
	private String jobMethodName;//任务方法名称
	@Column(name = "JOB_DESCRIPTION", nullable = false, length = 24)
	private String jobDescription;//任务描述
	@Column(name = "JOB_EXECUTE_TIME", nullable = false, length = 24)
	private String jobExecuteTime;//任务步骤执行次数
	@Column(name = "JOB_EXECUTE_FLAG", nullable = false, length = 24)
	private String jobExecuteFlag;//任务是否执行标志(Y/N)
	
	public String getTriggerJobGroupNumber() {
		return triggerJobGroupNumber;
	}
	public void setTriggerJobGroupNumber(String triggerJobGroupNumber) {
		this.triggerJobGroupNumber = triggerJobGroupNumber;
	}
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	public String getJobClassName() {
		return jobClassName;
	}
	public void setJobClassName(String jobClassName) {
		this.jobClassName = jobClassName;
	}
	public String getJobMethodName() {
		return jobMethodName;
	}
	public void setJobMethodName(String jobMethodName) {
		this.jobMethodName = jobMethodName;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobExecuteTime() {
		return jobExecuteTime;
	}
	public void setJobExecuteTime(String jobExecuteTime) {
		this.jobExecuteTime = jobExecuteTime;
	}
	public String getJobExecuteFlag() {
		return jobExecuteFlag;
	}
	public void setJobExecuteFlag(String jobExecuteFlag) {
		this.jobExecuteFlag = jobExecuteFlag;
	}
}
