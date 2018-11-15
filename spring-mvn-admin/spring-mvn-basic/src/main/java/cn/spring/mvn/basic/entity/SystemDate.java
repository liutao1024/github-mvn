package cn.spring.mvn.basic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.spring.mvn.basic.util.BasicUtil;


@Entity
@Table(name = "sys_date")
public class SystemDate implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 8166803477284862895L;
	
	
	@Id
	@Column(name = "date_type")
	private String dateType;//时间类型
	@Column(name = "day_before_yesterday", length = 8)
	private String theDayBeforeYesterday;//
	@Column(name = "yesterday", length = 8)
	private String yesterday;//
	@Column(name = "today", length = 8)
	private String today;//当前日期
	@Column(name = "tomorrow", length = 8)
	private String tomorrow;//
	@Column(name = "day_after_tomorrow", length = 8)
	private String theDayAfterTomorrow;//
	
	public SystemDate(){
		
	}
	public SystemDate(String dateType, String today){
		this.dateType = dateType;
		this.theDayBeforeYesterday = BasicUtil.getDateStrByDateStrAddDays(today, -2);
		this.yesterday = BasicUtil.getDateStrByDateStrAddDays(today, -1);
		this.today = today;
		this.tomorrow = BasicUtil.getDateStrByDateStrAddDays(today, 1);
		this.theDayAfterTomorrow = BasicUtil.getDateStrByDateStrAddDays(today, 2);
	}
	
	
	public String getDateType() {
		return dateType;
	}
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	public String getTheDayBeforeYesterday() {
		return theDayBeforeYesterday;
	}
	public void setTheDayBeforeYesterday(String theDayBeforeYesterday) {
		this.theDayBeforeYesterday = theDayBeforeYesterday;
	}
	public String getYesterday() {
		return yesterday;
	}
	public void setYesterday(String yesterday) {
		this.yesterday = yesterday;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getTomorrow() {
		return tomorrow;
	}
	public void setTomorrow(String tomorrow) {
		this.tomorrow = tomorrow;
	}
	public String getTheDayAfterTomorrow() {
		return theDayAfterTomorrow;
	}
	public void setTheDayAfterTomorrow(String theDayAfterTomorrow) {
		this.theDayAfterTomorrow = theDayAfterTomorrow;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateType == null) ? 0 : dateType.hashCode());
		result = prime
				* result
				+ ((theDayAfterTomorrow == null) ? 0 : theDayAfterTomorrow
						.hashCode());
		result = prime
				* result
				+ ((theDayBeforeYesterday == null) ? 0 : theDayBeforeYesterday
						.hashCode());
		result = prime * result + ((today == null) ? 0 : today.hashCode());
		result = prime * result
				+ ((tomorrow == null) ? 0 : tomorrow.hashCode());
		result = prime * result
				+ ((yesterday == null) ? 0 : yesterday.hashCode());
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
		SystemDate other = (SystemDate) obj;
		if (dateType == null) {
			if (other.dateType != null)
				return false;
		} else if (!dateType.equals(other.dateType))
			return false;
		if (theDayAfterTomorrow == null) {
			if (other.theDayAfterTomorrow != null)
				return false;
		} else if (!theDayAfterTomorrow.equals(other.theDayAfterTomorrow))
			return false;
		if (theDayBeforeYesterday == null) {
			if (other.theDayBeforeYesterday != null)
				return false;
		} else if (!theDayBeforeYesterday.equals(other.theDayBeforeYesterday))
			return false;
		if (today == null) {
			if (other.today != null)
				return false;
		} else if (!today.equals(other.today))
			return false;
		if (tomorrow == null) {
			if (other.tomorrow != null)
				return false;
		} else if (!tomorrow.equals(other.tomorrow))
			return false;
		if (yesterday == null) {
			if (other.yesterday != null)
				return false;
		} else if (!yesterday.equals(other.yesterday))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SystemDate [dateType=" + dateType + ", theDayBeforeYesterday="
				+ theDayBeforeYesterday + ", yesterday=" + yesterday
				+ ", today=" + today + ", tomorrow=" + tomorrow
				+ ", theDayAfterTomorrow=" + theDayAfterTomorrow + "]";
	}
}
