package cn.spring.mvn.base.entity;

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
	@Column(name = "JOB_PATH", nullable = false, length = 24)
	private String jobPath;//任务路径 
	@Column(name = "JOB_MODULE", nullable = false, length = 24)
	private String jobModule;//任务模块
	@Column(name = "JOB_CLASS", nullable = false, length = 24)
	private String jobClass;//任务类
	@Column(name = "JOB_METHOD", nullable = false, length = 24)
	private String jobMethod;//任务方法
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
	public String getJobPath() {
		return jobPath;
	}
	public void setJobPath(String jobPath) {
		this.jobPath = jobPath;
	}
	public String getJobModule() {
		return jobModule;
	}
	public void setJobModule(String jobModule) {
		this.jobModule = jobModule;
	}
	public String getJobClass() {
		return jobClass;
	}
	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}
	public String getJobMethod() {
		return jobMethod;
	}
	public void setJobMethod(String jobMethod) {
		this.jobMethod = jobMethod;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((jobClass == null) ? 0 : jobClass.hashCode());
		result = prime * result
				+ ((jobDescription == null) ? 0 : jobDescription.hashCode());
		result = prime * result
				+ ((jobExecuteFlag == null) ? 0 : jobExecuteFlag.hashCode());
		result = prime * result
				+ ((jobExecuteTime == null) ? 0 : jobExecuteTime.hashCode());
		result = prime * result
				+ ((jobMethod == null) ? 0 : jobMethod.hashCode());
		result = prime * result
				+ ((jobModule == null) ? 0 : jobModule.hashCode());
		result = prime * result
				+ ((jobNumber == null) ? 0 : jobNumber.hashCode());
		result = prime * result + ((jobPath == null) ? 0 : jobPath.hashCode());
		result = prime
				* result
				+ ((triggerJobGroupNumber == null) ? 0 : triggerJobGroupNumber
						.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemBatchTaskDispathControl other = (SystemBatchTaskDispathControl) obj;
		if (jobClass == null) {
			if (other.jobClass != null)
				return false;
		} else if (!jobClass.equals(other.jobClass))
			return false;
		if (jobDescription == null) {
			if (other.jobDescription != null)
				return false;
		} else if (!jobDescription.equals(other.jobDescription))
			return false;
		if (jobExecuteFlag == null) {
			if (other.jobExecuteFlag != null)
				return false;
		} else if (!jobExecuteFlag.equals(other.jobExecuteFlag))
			return false;
		if (jobExecuteTime == null) {
			if (other.jobExecuteTime != null)
				return false;
		} else if (!jobExecuteTime.equals(other.jobExecuteTime))
			return false;
		if (jobMethod == null) {
			if (other.jobMethod != null)
				return false;
		} else if (!jobMethod.equals(other.jobMethod))
			return false;
		if (jobModule == null) {
			if (other.jobModule != null)
				return false;
		} else if (!jobModule.equals(other.jobModule))
			return false;
		if (jobNumber == null) {
			if (other.jobNumber != null)
				return false;
		} else if (!jobNumber.equals(other.jobNumber))
			return false;
		if (jobPath == null) {
			if (other.jobPath != null)
				return false;
		} else if (!jobPath.equals(other.jobPath))
			return false;
		if (triggerJobGroupNumber == null) {
			if (other.triggerJobGroupNumber != null)
				return false;
		} else if (!triggerJobGroupNumber.equals(other.triggerJobGroupNumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SystemBatchTaskDispathControl [triggerJobGroupNumber="
				+ triggerJobGroupNumber + ", jobNumber=" + jobNumber
				+ ", jobPath=" + jobPath + ", jobModule=" + jobModule
				+ ", jobClass=" + jobClass + ", jobMethod=" + jobMethod
				+ ", jobDescription=" + jobDescription + ", jobExecuteTime="
				+ jobExecuteTime + ", jobExecuteFlag=" + jobExecuteFlag + "]";
	}
}
