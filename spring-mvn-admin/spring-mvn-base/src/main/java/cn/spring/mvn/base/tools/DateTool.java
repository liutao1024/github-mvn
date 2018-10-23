package cn.spring.mvn.base.tools;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateTool {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	// 时间格式年月日
	public final static String YYYYMMDD = "yyyyMMdd";
	// 时间格式年-月-日
	public final static String YYYY_MM_DD = "yyyy-MM-dd";
	// 时间格式时分秒
	public final static String HHMMSS = "HHmmss";
	// 时间格式年-月-日 时:分:秒
	public final static String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 获取当前日期时间
	 * @param dateFormat 日期格式
	 * @return 当前日期时间
	 */
	public static String getNow(String dateFormat) {
		Format f = new SimpleDateFormat(dateFormat);
		return f.format(new Date());
	}

	/**
	 * 将日期类型转换成字符类型
	 * @param dt 日期
	 * @param dateFormat 日期格式
	 * @return 日期字符类型
	 */
	public static String Date2String(Date dt, String dateFormat) {
		Format f = new SimpleDateFormat(dateFormat);
		return f.format(dt);
	}

	/**
	 * 将字符类型转换成日期类型
	 * @param dt 日期
	 * @param dateFormat 日期格式
	 * @return 日期类型
	 * @throws Exception 
	 */
	public static Date String2Date(String dt, String dateFormat) throws Exception {
		try {
			DateFormat df = new SimpleDateFormat(dateFormat);
			return df.parse(dt);
		} catch (ParseException e) {
			throw new Exception("日期类型转换失败");
		}
	}

	/**
	 * 获取日期年份
	 * @param dt 日期
	 * @return 年份
	 */
	public static int getYear(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 获取日期月份
	 * @param dt 日期
	 * @return 月份
	 */
	public static int getMonth(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(Calendar.MONTH);
	}

	/**
	 * 获取日期日
	 * @param dt 日期
	 * @return 某日
	 */
	public static int getDay(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(Calendar.DATE);
	}

	/**
	 * 设置日期日
	 * @param dt 日期
	 * @param day 日
	 * @return
	 */
	public static Date setDay(Date dt, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.DATE, day);
		return cal.getTime();
	}

	/**
	 * 日期比较
	 * @param d1
	 * @param d2
	 * @return d1 < d2 返回-1 d1 > d2 返回1 d1 = d2 返回0
	 */
	public static int compareDate(Date d1, Date d2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(d1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(d2);
		return cal1.compareTo(cal2);
	}

	/**
	 * 增加年数
	 * @param dt 日期
	 * @param years 年数
	 * @return 计算后日期
	 */
	public static Date addYears(Date dt, int years) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.YEAR, years);

		return cal.getTime();
	}

	/**
	 * 增加月数
	 * @param dt 日期
	 * @param months 月数
	 * @return 计算后日期 例如: 20150228 + 1M = 20150328 20150331 + 1M = 20150430
	 *         20150430 + 1M = 20150530
	 */
	public static Date addMonths(Date dt, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}

	/**
	 * 增加月数(按照实际月底计算)
	 * 
	 * @param dt 日期
	 * @param months 月数
	 * @return 计算后日期 例如: 20150228 + 1M = 20150331 20150331 + 1M = 20150430
	 *         20150430 + 1M = 20150531
	 */
	public static Date addMonthsReal(Date dt, int months) {
		Date month = addMonths(dt, months);
		if (isMonthEnd(dt))
			return getMonthEnd(month);
		return month;
	}

	/**
	 * 增加天数
	 * 
	 * @param dt 日期
	 * @param days 天数
	 * @return 计算后日期
	 */
	public static Date addDays(Date dt, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	/**
	 * 判断是否月底
	 * 
	 * @param dt
	 *            日期
	 * @return 月底返回true 日期增加一天,如果为1号就判断为月底
	 */
	public static boolean isMonthEnd(Date dt) {
		if (getDay(addDays(dt, 1)) == 1)
			return true;
		return false;
	}

	/**
	 * 获取当月月初日期
	 * 
	 * @param dt
	 *            日期
	 * @return
	 */
	public static Date getMonthFirst(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.DATE, 1);
		return cal.getTime();
	}

	/**
	 * 获取当月月末
	 * @param dt 日期
	 * @return
	 */
	public static Date getMonthEnd(Date dt) {
		if (isMonthEnd(dt))
			return dt;
		return addDays(getMonthFirst(addMonths(dt, 1)), -1);
	}

	/**
	 * 计算实际天数差
	 * 
	 * @param startDt 开始日期
	 * @param endDt 结束日期
	 * @return 实际天数差
	 */
	public static int calDiffDays(Date startDt, Date endDt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDt);
		long time1 = cal.getTimeInMillis();
		cal.setTime(endDt);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 计算两个日期年数差
	 * 
	 * @param startDt 开始日期
	 * @param endDt 结束日期
	 * @return 年数差
	 */
	public static int calDiffYears(Date startDt, Date endDt) {
		int years = 0;
		int year1 = getYear(startDt);
		int year2 = getYear(endDt);
		years = year2 - year1;
		int i = compareDate(addYears(startDt, years), endDt);
		if (i > 0)
			years--;
		return years;
	}

	/**
	 * 计算两个日期月数差
	 * @param startDt 开始日期
	 * @param endDt 结束日期
	 * @return 月数差
	 */
	public static int calDiffMonths(Date startDt, Date endDt) {
		int years = calDiffYears(startDt, endDt);
		Date tmp = addYears(startDt, years);

		int month1 = getMonth(tmp);
		int month2 = getMonth(endDt);

		int months = month2 - month1;
		if (months < 0)
			months = 12 + months;

		int i = compareDate(addMonths(tmp, months), endDt);

		if (i > 0)
			months--;

		return years * 12 + months;
	}

	/**
	 * 计算储蓄天数
	 * @param startDt 开始日期
	 * @param endDt 结束日期
	 * @return 储蓄天数
	 */
	public static int calDepositDays(Date startDt, Date endDt) {

		Date startTmp = startDt;
		Date endTmp = endDt;
		// 先统一将31号处理成30号
		int day = getDay(startDt);
		if (day == 31)
			startTmp = setDay(startDt, 30);
		day = getDay(endDt);
		if (day == 31)
			endTmp = setDay(endDt, 30);

		int months = calDiffMonths(startTmp, endTmp);

		Date tmpMonth = addMonths(startTmp, months);

		int days = 0;
		if (months == 0) {
			days = calDiffDays(startDt, endDt);
		} else {
			days = calDiffDays(tmpMonth, endTmp);
		}

		return months * 30 + days;
	}
	
	
	/**
	 * @author LiuTao @date 2018年6月9日 下午12:24:29 
	 * @Title: getNowDateToString 
	 * @Description: TODO(Describe) 
	 * @return
	 */
	public static String getNowDateToString(){
		Date date = new Date();
		return sdf.format(date);
	}
	
	public static String getSystemDateString(){
//		SystemDate date = new SystemDate();
		return null;
	}
	
	/** 
     * 获取 当前年,半年,季度,月,日,小时 开始结束时间 
     */  
  
    private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");  
    private final static SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");;  
    private final static SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");;  
  
  
    /** 
     * 获得本周的第一天,周一 
     *  
     * @return 
     */  
    public static Date getCurrentWeekDayStartTime() {  
        Calendar c = Calendar.getInstance();  
        try {  
            int weekday = c.get(Calendar.DAY_OF_WEEK) - 2;  
            c.add(Calendar.DATE, -weekday);  
            c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00"));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return c.getTime();  
    }  
  
    /** 
     * 获得本周的最后一天,周日 
     *  
     * @return 
     */  
    public static Date getCurrentWeekDayEndTime() {  
        Calendar c = Calendar.getInstance();  
        try {  
            int weekday = c.get(Calendar.DAY_OF_WEEK);  
            c.add(Calendar.DATE, 8 - weekday);  
            c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59"));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return c.getTime();  
    }  
  
    /** 
     * 获得本天的开始时间,即2012-01-01 00:00:00 
     *  
     * @return 
     */  
    public static Date getCurrentDayStartTime() {  
        Date now = new Date();  
        try {  
            now = shortSdf.parse(shortSdf.format(now));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return now;  
    }  
  
    /** 
     * 获得本天的结束时间,即2012-01-01 23:59:59 
     *  
     * @return 
     */  
    public static Date getCurrentDayEndTime() {  
        Date now = new Date();  
        try {  
            now = longSdf.parse(shortSdf.format(now) + " 23:59:59");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return now;  
    }  
  
    /** 
     * 获得本小时的开始时间,即2012-01-01 23:59:59 
     *  
     * @return 
     */  
    public static Date getCurrentHourStartTime() {  
        Date now = new Date();  
        try {  
            now = longHourSdf.parse(longHourSdf.format(now));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return now;  
    }  
  
    /** 
     * 获得本小时的结束时间,即2012-01-01 23:59:59 
     *  
     * @return 
     */  
    public static Date getCurrentHourEndTime() {  
        Date now = new Date();  
        try {  
            now = longSdf.parse(longHourSdf.format(now) + ":59:59");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return now;  
    }  
  
    /** 
     * 获得本月的开始时间,即2012-01-01 00:00:00 
     *  
     * @return 
     */  
    public static Date getCurrentMonthStartTime() {  
        Calendar c = Calendar.getInstance();  
        Date now = null;  
        try {  
            c.set(Calendar.DATE, 1);  
            now = shortSdf.parse(shortSdf.format(c.getTime()));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return now;  
    }  
  
    /** 
     * 当前月的结束时间,即2012-01-31 23:59:59 
     *  
     * @return 
     */  
    public static Date getCurrentMonthEndTime() {  
        Calendar c = Calendar.getInstance();  
        Date now = null;  
        try {  
            c.set(Calendar.DATE, 1);  
            c.add(Calendar.MONTH, 1);  
            c.add(Calendar.DATE, -1);  
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return now;  
    }  
  
    /** 
     * 当前年的开始时间,即2012-01-01 00:00:00 
     *  
     * @return 
     */  
    public static Date getCurrentYearStartTime() {  
        Calendar c = Calendar.getInstance();  
        Date now = null;  
        try {  
            c.set(Calendar.MONTH, 0);  
            c.set(Calendar.DATE, 1);  
            now = shortSdf.parse(shortSdf.format(c.getTime()));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return now;  
    }  
  
    /** 
     * 当前年的结束时间,即2012-12-31 23:59:59 
     *  
     * @return 
     */  
    public static Date getCurrentYearEndTime() {  
        Calendar c = Calendar.getInstance();  
        Date now = null;  
        try {  
            c.set(Calendar.MONTH, 11);  
            c.set(Calendar.DATE, 31);  
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return now;  
    }  
  
    /** 
     * 当前季度的开始时间,即2012-01-1 00:00:00 
     *  
     * @return 
     */  
    public static Date getCurrentQuarterStartTime() {  
        Calendar c = Calendar.getInstance();  
        int currentMonth = c.get(Calendar.MONTH) + 1;  
        Date now = null;  
        try {  
            if (currentMonth >= 1 && currentMonth <= 3)  
                c.set(Calendar.MONTH, 0);  
            else if (currentMonth >= 4 && currentMonth <= 6)  
                c.set(Calendar.MONTH, 3);  
            else if (currentMonth >= 7 && currentMonth <= 9)  
                c.set(Calendar.MONTH, 4);  
            else if (currentMonth >= 10 && currentMonth <= 12)  
                c.set(Calendar.MONTH, 9);  
            c.set(Calendar.DATE, 1);  
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return now;  
    }  
  
    /** 
     * 当前季度的结束时间,即2012-03-31 23:59:59 
     *  
     * @return 
     */  
    public static Date getCurrentQuarterEndTime() {  
        Calendar c = Calendar.getInstance();  
        int currentMonth = c.get(Calendar.MONTH) + 1;  
        Date now = null;  
        try {  
            if (currentMonth >= 1 && currentMonth <= 3) {  
                c.set(Calendar.MONTH, 2);  
                c.set(Calendar.DATE, 31);  
            } else if (currentMonth >= 4 && currentMonth <= 6) {  
                c.set(Calendar.MONTH, 5);  
                c.set(Calendar.DATE, 30);  
            } else if (currentMonth >= 7 && currentMonth <= 9) {  
                c.set(Calendar.MONTH, 8);  
                c.set(Calendar.DATE, 30);  
            } else if (currentMonth >= 10 && currentMonth <= 12) {  
                c.set(Calendar.MONTH, 11);  
                c.set(Calendar.DATE, 31);  
            }  
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return now;  
    }  
  
    /** 
     * 获取前/后半年的开始时间 
     *  
     * @return 
     */  
    public static Date getHalfYearStartTime() {  
        Calendar c = Calendar.getInstance();  
        int currentMonth = c.get(Calendar.MONTH) + 1;  
        Date now = null;  
        try {  
            if (currentMonth >= 1 && currentMonth <= 6) {  
                c.set(Calendar.MONTH, 0);  
            } else if (currentMonth >= 7 && currentMonth <= 12) {  
                c.set(Calendar.MONTH, 6);  
            }  
            c.set(Calendar.DATE, 1);  
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return now;  
  
    }  
  
    /** 
     * 获取前/后半年的结束时间 
     *  
     * @return 
     */  
    public static Date getHalfYearEndTime() {  
        Calendar c = Calendar.getInstance();  
        int currentMonth = c.get(Calendar.MONTH) + 1;  
        Date now = null;  
        try {  
            if (currentMonth >= 1 && currentMonth <= 6) {  
                c.set(Calendar.MONTH, 5);  
                c.set(Calendar.DATE, 30);  
            } else if (currentMonth >= 7 && currentMonth <= 12) {  
                c.set(Calendar.MONTH, 11);  
                c.set(Calendar.DATE, 31);  
            }  
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return now;  
    }  
}
