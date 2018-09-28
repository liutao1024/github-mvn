package cn.spring.mvn.batch.entity;

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobName == null) ? 0 : jobName.hashCode());
		result = prime * result
				+ ((jobNumber == null) ? 0 : jobNumber.hashCode());
		result = prime
				* result
				+ ((timeTaskDispathDate == null) ? 0 : timeTaskDispathDate
						.hashCode());
		result = prime
				* result
				+ ((timeTaskDispathErrorMessage == null) ? 0
						: timeTaskDispathErrorMessage.hashCode());
		result = prime
				* result
				+ ((timeTaskDispathStatus == null) ? 0 : timeTaskDispathStatus
						.hashCode());
		result = prime
				* result
				+ ((triggerJobGroupName == null) ? 0 : triggerJobGroupName
						.hashCode());
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
		SystemBatchTimeTaskDispathResult other = (SystemBatchTimeTaskDispathResult) obj;
		if (jobName == null) {
			if (other.jobName != null)
				return false;
		} else if (!jobName.equals(other.jobName))
			return false;
		if (jobNumber == null) {
			if (other.jobNumber != null)
				return false;
		} else if (!jobNumber.equals(other.jobNumber))
			return false;
		if (timeTaskDispathDate == null) {
			if (other.timeTaskDispathDate != null)
				return false;
		} else if (!timeTaskDispathDate.equals(other.timeTaskDispathDate))
			return false;
		if (timeTaskDispathErrorMessage == null) {
			if (other.timeTaskDispathErrorMessage != null)
				return false;
		} else if (!timeTaskDispathErrorMessage
				.equals(other.timeTaskDispathErrorMessage))
			return false;
		if (timeTaskDispathStatus == null) {
			if (other.timeTaskDispathStatus != null)
				return false;
		} else if (!timeTaskDispathStatus.equals(other.timeTaskDispathStatus))
			return false;
		if (triggerJobGroupName == null) {
			if (other.triggerJobGroupName != null)
				return false;
		} else if (!triggerJobGroupName.equals(other.triggerJobGroupName))
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
		return "SystemBatchTimeTaskDispathResult [triggerJobGroupNumber="
				+ triggerJobGroupNumber + ", timeTaskDispathDate="
				+ timeTaskDispathDate + ", jobNumber=" + jobNumber
				+ ", jobName=" + jobName + ", triggerJobGroupName="
				+ triggerJobGroupName + ", timeTaskDispathErrorMessage="
				+ timeTaskDispathErrorMessage + ", timeTaskDispathStatus="
				+ timeTaskDispathStatus + "]";
	}
}
