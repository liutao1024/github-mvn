package cn.spring.mvn.base.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author LiuTao @date 2018年11月2日 下午6:07:17
 * @ClassName: SystemBatchTimeDispathControl 
 * @Description: 定时任务调度控制器
 */
@Entity
@Table(name = "sys_batch_timer_control")
public class SystemBatchTimeDispathControl implements Serializable {
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 5860649223007713622L;
	
	@Id
	@Column(name = "TRIGGER_JOB_GROUP_NUMBER", nullable = false, length = 24)
	private String triggerJobGroupNumber;//定时任务组批次号
	@Id
	@Column(name = "TRIGGER_JOB_GROUP_NAME", nullable = false, length = 24)
	private String triggerJobGroupName;//定时任务组名称
	@Column(name = "TRIGGER_JOB_GROUP_PATH", nullable = false, length = 24)
	private String triggerJobGroupPath;//定时任务组路径
	@Column(name = "TRIGGER_JOB_GROUP_MODULE", nullable = false, length = 24)
	private String triggerJobGroupModule;//定时任务组模块
	@Column(name = "TRIGGER_JOB_GROUP_CLASS", nullable = false, length = 24)
	private String triggerJobGroupClass;//定时任务组类名
	@Column(name = "TRIGGER_JOB_GROUP_DESCRIPTION", nullable = false, length = 24)
	private String triggerJobGroupDescription;//定时任务组描述
	@Column(name = "DISPATH_PERIOD_YEAR", nullable = false, length = 24)
	private String dispathPeriodYear;//调度周期--年份
	@Column(name = "DISPATH_PERIOD_WEEK", nullable = false, length = 24)
	private String dispathPeriodWeek;//调度周期--周
	@Column(name = "DISPATH_PERIOD_MONTH", nullable = false, length = 24)
	private String dispathPeriodMonth;//调度周期--月份
	@Column(name = "DISPATH_PERIOD_DAY", nullable = false, length = 24)
	private String dispathPeriodDay;//调度周期--日
	@Column(name = "DISPATH_PERIOD_HOUR", nullable = false, length = 24)
	private String dispathPeriodHour;//调度周期--小时
	@Column(name = "DISPATH_PERIOD_MINUTE", nullable = false, length = 24)
	private String dispathPeriodMinute;//调度周期--分钟
	@Column(name = "DISPATH_PERIOD_SECOND", nullable = false, length = 24)
	private String dispathPeriodSecond;//调度周期--秒钟
	@Column(name = "DISPATH_STATUS", nullable = false, length = 24)
	private String dispathStatus;//调度状态(START/RUNING/STOP/STOPPED)
	public String getTriggerJobGroupNumber() {
		return triggerJobGroupNumber;
	}
	public void setTriggerJobGroupNumber(String triggerJobGroupNumber) {
		this.triggerJobGroupNumber = triggerJobGroupNumber;
	}
	public String getTriggerJobGroupName() {
		return triggerJobGroupName;
	}
	public void setTriggerJobGroupName(String triggerJobGroupName) {
		this.triggerJobGroupName = triggerJobGroupName;
	}
	public String getTriggerJobGroupPath() {
		return triggerJobGroupPath;
	}
	public void setTriggerJobGroupPath(String triggerJobGroupPath) {
		this.triggerJobGroupPath = triggerJobGroupPath;
	}
	public String getTriggerJobGroupModule() {
		return triggerJobGroupModule;
	}
	public void setTriggerJobGroupModule(String triggerJobGroupModule) {
		this.triggerJobGroupModule = triggerJobGroupModule;
	}
	public String getTriggerJobGroupClass() {
		return triggerJobGroupClass;
	}
	public void setTriggerJobGroupClass(String triggerJobGroupClass) {
		this.triggerJobGroupClass = triggerJobGroupClass;
	}
	public String getTriggerJobGroupDescription() {
		return triggerJobGroupDescription;
	}
	public void setTriggerJobGroupDescription(String triggerJobGroupDescription) {
		this.triggerJobGroupDescription = triggerJobGroupDescription;
	}
	public String getDispathPeriodYear() {
		return dispathPeriodYear;
	}
	public void setDispathPeriodYear(String dispathPeriodYear) {
		this.dispathPeriodYear = dispathPeriodYear;
	}
	public String getDispathPeriodWeek() {
		return dispathPeriodWeek;
	}
	public void setDispathPeriodWeek(String dispathPeriodWeek) {
		this.dispathPeriodWeek = dispathPeriodWeek;
	}
	public String getDispathPeriodMonth() {
		return dispathPeriodMonth;
	}
	public void setDispathPeriodMonth(String dispathPeriodMonth) {
		this.dispathPeriodMonth = dispathPeriodMonth;
	}
	public String getDispathPeriodDay() {
		return dispathPeriodDay;
	}
	public void setDispathPeriodDay(String dispathPeriodDay) {
		this.dispathPeriodDay = dispathPeriodDay;
	}
	public String getDispathPeriodHour() {
		return dispathPeriodHour;
	}
	public void setDispathPeriodHour(String dispathPeriodHour) {
		this.dispathPeriodHour = dispathPeriodHour;
	}
	public String getDispathPeriodMinute() {
		return dispathPeriodMinute;
	}
	public void setDispathPeriodMinute(String dispathPeriodMinute) {
		this.dispathPeriodMinute = dispathPeriodMinute;
	}
	public String getDispathPeriodSecond() {
		return dispathPeriodSecond;
	}
	public void setDispathPeriodSecond(String dispathPeriodSecond) {
		this.dispathPeriodSecond = dispathPeriodSecond;
	}
	public String getDispathStatus() {
		return dispathStatus;
	}
	public void setDispathStatus(String dispathStatus) {
		this.dispathStatus = dispathStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dispathPeriodDay == null) ? 0 : dispathPeriodDay.hashCode());
		result = prime
				* result
				+ ((dispathPeriodHour == null) ? 0 : dispathPeriodHour
						.hashCode());
		result = prime
				* result
				+ ((dispathPeriodMinute == null) ? 0 : dispathPeriodMinute
						.hashCode());
		result = prime
				* result
				+ ((dispathPeriodMonth == null) ? 0 : dispathPeriodMonth
						.hashCode());
		result = prime
				* result
				+ ((dispathPeriodSecond == null) ? 0 : dispathPeriodSecond
						.hashCode());
		result = prime
				* result
				+ ((dispathPeriodWeek == null) ? 0 : dispathPeriodWeek
						.hashCode());
		result = prime
				* result
				+ ((dispathPeriodYear == null) ? 0 : dispathPeriodYear
						.hashCode());
		result = prime * result
				+ ((dispathStatus == null) ? 0 : dispathStatus.hashCode());
		result = prime
				* result
				+ ((triggerJobGroupClass == null) ? 0 : triggerJobGroupClass
						.hashCode());
		result = prime
				* result
				+ ((triggerJobGroupDescription == null) ? 0
						: triggerJobGroupDescription.hashCode());
		result = prime
				* result
				+ ((triggerJobGroupModule == null) ? 0 : triggerJobGroupModule
						.hashCode());
		result = prime
				* result
				+ ((triggerJobGroupName == null) ? 0 : triggerJobGroupName
						.hashCode());
		result = prime
				* result
				+ ((triggerJobGroupNumber == null) ? 0 : triggerJobGroupNumber
						.hashCode());
		result = prime
				* result
				+ ((triggerJobGroupPath == null) ? 0 : triggerJobGroupPath
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
		SystemBatchTimeDispathControl other = (SystemBatchTimeDispathControl) obj;
		if (dispathPeriodDay == null) {
			if (other.dispathPeriodDay != null)
				return false;
		} else if (!dispathPeriodDay.equals(other.dispathPeriodDay))
			return false;
		if (dispathPeriodHour == null) {
			if (other.dispathPeriodHour != null)
				return false;
		} else if (!dispathPeriodHour.equals(other.dispathPeriodHour))
			return false;
		if (dispathPeriodMinute == null) {
			if (other.dispathPeriodMinute != null)
				return false;
		} else if (!dispathPeriodMinute.equals(other.dispathPeriodMinute))
			return false;
		if (dispathPeriodMonth == null) {
			if (other.dispathPeriodMonth != null)
				return false;
		} else if (!dispathPeriodMonth.equals(other.dispathPeriodMonth))
			return false;
		if (dispathPeriodSecond == null) {
			if (other.dispathPeriodSecond != null)
				return false;
		} else if (!dispathPeriodSecond.equals(other.dispathPeriodSecond))
			return false;
		if (dispathPeriodWeek == null) {
			if (other.dispathPeriodWeek != null)
				return false;
		} else if (!dispathPeriodWeek.equals(other.dispathPeriodWeek))
			return false;
		if (dispathPeriodYear == null) {
			if (other.dispathPeriodYear != null)
				return false;
		} else if (!dispathPeriodYear.equals(other.dispathPeriodYear))
			return false;
		if (dispathStatus == null) {
			if (other.dispathStatus != null)
				return false;
		} else if (!dispathStatus.equals(other.dispathStatus))
			return false;
		if (triggerJobGroupClass == null) {
			if (other.triggerJobGroupClass != null)
				return false;
		} else if (!triggerJobGroupClass.equals(other.triggerJobGroupClass))
			return false;
		if (triggerJobGroupDescription == null) {
			if (other.triggerJobGroupDescription != null)
				return false;
		} else if (!triggerJobGroupDescription
				.equals(other.triggerJobGroupDescription))
			return false;
		if (triggerJobGroupModule == null) {
			if (other.triggerJobGroupModule != null)
				return false;
		} else if (!triggerJobGroupModule.equals(other.triggerJobGroupModule))
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
		if (triggerJobGroupPath == null) {
			if (other.triggerJobGroupPath != null)
				return false;
		} else if (!triggerJobGroupPath.equals(other.triggerJobGroupPath))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SystemBatchTimeDispathControl [triggerJobGroupNumber="
				+ triggerJobGroupNumber + ", triggerJobGroupName="
				+ triggerJobGroupName + ", triggerJobGroupPath="
				+ triggerJobGroupPath + ", triggerJobGroupModule="
				+ triggerJobGroupModule + ", triggerJobGroupClass="
				+ triggerJobGroupClass + ", triggerJobGroupDescription="
				+ triggerJobGroupDescription + ", dispathPeriodYear="
				+ dispathPeriodYear + ", dispathPeriodWeek="
				+ dispathPeriodWeek + ", dispathPeriodMonth="
				+ dispathPeriodMonth + ", dispathPeriodDay=" + dispathPeriodDay
				+ ", dispathPeriodHour=" + dispathPeriodHour
				+ ", dispathPeriodMinute=" + dispathPeriodMinute
				+ ", dispathPeriodSecond=" + dispathPeriodSecond
				+ ", dispathStatus=" + dispathStatus + "]";
	}
}
