package cn.spring.mvc.base.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.spring.mvc.base.util.BaseUtil;


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
		this.theDayBeforeYesterday = BaseUtil.toGetDateStrByDateStr(today, -2);
		this.yesterday = BaseUtil.toGetDateStrByDateStr(today, -1);
		this.today = today;
		this.tomorrow = BaseUtil.toGetDateStrByDateStr(today, 1);
		this.theDayAfterTomorrow = BaseUtil.toGetDateStrByDateStr(today, 2);
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
	
	
	
}
