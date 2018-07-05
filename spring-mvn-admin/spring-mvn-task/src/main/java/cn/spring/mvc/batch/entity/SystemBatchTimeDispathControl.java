package cn.spring.mvc.batch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author LiuTao @date 2018年6月1日 下午10:48:15
 * @ClassName: SysBatchTimerControl 
 * @Description: 定时调度控制器
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
	@Column(name = "TRIGGER_JOB_GROUP_NAME", nullable = false, length = 24)
	private String triggerJobGroupName;//定时任务组名称
	@Column(name = "TRIGGER_JOB_GROUP_CLASS_NAME", nullable = false, length = 24)
	private String triggerJobGroupClassName;//定时任务组类名
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
	public String getTriggerJobGroupClassName() {
		return triggerJobGroupClassName;
	}
	public void setTriggerJobGroupClassName(String triggerJobGroupClassName) {
		this.triggerJobGroupClassName = triggerJobGroupClassName;
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
}
