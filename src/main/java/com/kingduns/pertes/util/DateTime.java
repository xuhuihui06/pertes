package com.kingduns.pertes.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.kingduns.pertes.config.bean.DateRange;


/**
 * 日期时间类
 * 
 * @see 定义时间日期通用方法
 * @author 宋德彬
 * @version 1.0
 */
public class DateTime {

	/**
	 * 交易流水号同步控制
	 */
	private static final Object TRS = 1;


	/**
	 * 交易流水号同步控制
	 */
	private static final Object ST = 1;

	/**
	 * 获取交易流水号
	 * 
	 * @return
	 */
	public static String getTrscd() {
		synchronized (TRS) {
			String curDate = DateTime.getDT("yyyyMMddHHmmssSSS");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return curDate;
		}
	}

	/**
	 * 获取月度计划编号
	 * 
	 * @return
	 */
	public static String getPlancd(Integer siteid, Integer year, Integer month) {
		StringBuffer sb = new StringBuffer("M");
		sb.append(year).append(String.format("%02d", month)).append("_").append(String.format("%03d", siteid));
		return sb.toString();

	}

	/**
	 * 获取站网测量任务编号
	 * 
	 * @return
	 */
	public static String getStationTaskid(Integer siteid) {
		synchronized (ST) {
			String curDate = DateTime.getDT("yyyyMMdd_HHmmssSSS");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "M" + curDate + "_" + String.format("%03d", siteid);
		}
	}

	/**
	 * Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01");
	 * 
	 * @throws ParseException
	 */
	public static Date getThisDate(String param) {
		Date date = null;
		try {

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = df.parse(param);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取当前日期YYYY-MM-dd HH:mm:ss 格式
	 * 
	 * @return
	 */
	public static String getThisDateStr() {

		SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		Date d = null;
		try {
			d = f.parse(new Date().toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d.toString();
	}

	/**
	 * 转为Timestamp
	 * 
	 * @param pattern
	 * @return
	 */
	public static Timestamp getToDate(String pattern) {

		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date d = null;
		try {
			d = f.parse(pattern);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Timestamp(d.getTime());
	}

	/**
	 * 获取系统当前日期和时间(自定义格式)
	 * 
	 * @param pattern
	 *            时间格式化字符串，如：yyyy-MM-dd
	 * @return 格式化后的字符串
	 */
	public static String getDT(String pattern) {
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat(pattern);
		return f.format(date);
	}

	/**
	 * 获取系统当前日期和时间
	 * 
	 * @return 字符串，格式: yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateTime() {
		return getDT("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取系统当前日期
	 * 
	 * @return 字符串，格式: yyyy-MM-dd
	 */
	public static String getDate() {
		return getDT("yyyy-MM-dd");
	}

	/**
	 * 获取系统当前时间
	 * 
	 * @return 字符串，格式：HH:mm:ss
	 */
	public static String getTime() {
		return getDT("HH:mm:ss");
	}

	/**
	 * 获取系统当前年
	 * 
	 * @return 字符串，格式：yyyy
	 */
	public static String getYear() {
		return getDT("yyyy");
	}

	/**
	 * 获取系统当前月份
	 * 
	 * @return 字符串，格式：MM
	 */
	public static String getMonth() {
		return getDT("MM");
	}

	/**
	 * 获取系统当前日
	 * 
	 * @return 字符串，格式：dd
	 */
	public static String getDay() {
		return getDT("dd");
	}

	/**
	 * 获取系统当前日期是星期几
	 * 
	 * @return 字符串，格式：星期x
	 */
	public static String getWeek() {
		return getDT("E");
	}

	/**
	 * 获取系统当前日期是星期几
	 * 
	 * @return 数字，如：5表示星期五
	 */
	public static int getWeekNumber() {
		Calendar c = Calendar.getInstance();
		int weekday = c.get(Calendar.DAY_OF_WEEK) - 1;
		return weekday;
	}

	/**
	 * 获取系统当前中文日期和星期
	 * 
	 * @return 字符串，格式: 2005年03月21日 星期三
	 */
	public static String getDateWeek() {
		return getDT("yyyy年MM月dd日 E");
	}

	/**
	 * 获取系统当前年月
	 * 
	 * @return 字符串，格式: yyyy-MM
	 */
	public static String getYearMonth() {
		return getDT("yyyy-MM");
	}

	/**
	 * 获取系统当前月日
	 * 
	 * @return 字符串，格式: MM-dd
	 */
	public static String getMonthDay() {
		return getDT("MM-dd");
	}

	/**
	 * 获取系统当前年月日
	 * 
	 * @return 字符串，格式: yyyyMMdd
	 */
	public static String getYMD() {
		return getDT("yyyyMMdd");
	}

	/**
	 * 获取系统当前年月日时分秒
	 * 
	 * @return 字符串，格式: yyyyMMddHHmmss
	 */
	public static String getYMDHMS() {
		return getDT("yyyyMMddHHmmss");
	}

	/**
	 * 获取系统当前年月日时分秒毫秒
	 * 
	 * @return 字符串，格式: yyyyMMddHHmmssSSS
	 */
	public static String getYMDHMSS() {
		return getDT("yyyyMMddHHmmssSSS");
	}

	public static long getTimeDiffS(String startDate, String endDate) {
		long diff = -1;
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date t1 = df.parse(startDate);
			Date t2 = df.parse(endDate);
			long l = t2.getTime() - t1.getTime();
			diff = (long) l / 1000;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return diff;
	}

	/**
	 * 获取两个日期的时间差(绝对值)
	 * 
	 * @param startDate
	 *            起始时间，格式: yyyy-MM-dd HH:mm:ss
	 * @param endDate
	 *            结束时间，格式: yyyy-MM-dd HH:mm:ss
	 * @return 数字，单位: 秒
	 * @exception 如果异常，返回-1
	 */
	public static long getTimeDiffSAbs(String startDate, String endDate) {
		return Math.abs(getTimeDiffS(startDate, endDate));
	}

	/**
	 * 获取两个日期的时间差(绝对值)，不足1分钟返回0
	 * 
	 * @param startDate
	 *            起始时间，格式: yyyy-MM-dd HH:mm:ss
	 * @param endDate
	 *            结束时间，格式: yyyy-MM-dd HH:mm:ss
	 * @return 数字，单位: 分钟
	 */
	public static long getTimeDiffM(String startDate, String endDate) {
		long l = getTimeDiffSAbs(startDate, endDate);
		l = l / 60;
		return l;
	}

	/**
	 * 获取两个日期的时间差(绝对值)，不足1小时返回0
	 * 
	 * @param startDate
	 *            起始时间，格式: yyyy-MM-dd HH:mm:ss
	 * @param endDate
	 *            结束时间，格式: yyyy-MM-dd HH:mm:ss
	 * @return 数字，单位: 小时
	 */
	public static long getTimeDiffH(String startDate, String endDate) {
		long l = getTimeDiffSAbs(startDate, endDate);
		l = l / (60 * 60);
		return l;
	}

	/**
	 * 获取两个日期的时间差(绝对值)，不足1天返回0
	 * 
	 * @param startDate
	 *            起始时间，格式: yyyy-MM-dd HH:mm:ss
	 * @param endDate
	 *            结束时间，格式: yyyy-MM-dd HH:mm:ss
	 * @return 数字，单位: 天
	 */
	public static long getTimeDiffD(String startDate, String endDate) {
		long l = getTimeDiffSAbs(startDate, endDate);
		l = l / (60 * 60 * 24);
		return l;
	}

	/**
	 * 获取两个日期时间差
	 * 
	 * @param startDate
	 *            起始时间，格式: yyyy-MM-dd HH:mm:ss
	 * @param endDate
	 *            结束时间，格式: yyyy-MM-dd HH:mm:ss
	 * @return 字符串，格式：x天x小时x分钟x秒
	 * @exception 如果异常，返回"-1秒"
	 */
	public static String getTimeDiff(String startDate, String endDate) {
		String str = "";
		// 获取日期相差的秒数
		long l = getTimeDiffSAbs(startDate, endDate);
		try {
			long day = l / (60 * 60 * 24);
			long hour = (l / (60 * 60)) - day * 24;
			long minute = (l / 60) - day * 24 * 60 - hour * 60;
			long s = l - day * 24 * 60 * 60 - hour * 60 * 60 - minute * 60;
			str = day + "天" + hour + "小时" + minute + "分" + s + "秒";
		} catch (Exception e) {
			e.printStackTrace();
			return "-1秒";
		}
		return str;
	}

	public static String getTimeDiff(String startDate, String endDate, String pattern) {
		String str = "";
		try {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			Date t1 = df.parse(startDate);
			Date t2 = df.parse(endDate);
			long l = Math.abs((long) (t2.getTime() - t1.getTime()) / 1000);

			long day = l / (60 * 60 * 24);
			long hour = (l / (60 * 60)) - day * 24;
			long minute = (l / 60) - day * 24 * 60 - hour * 60;
			long s = l - day * 24 * 60 * 60 - hour * 60 * 60 - minute * 60;
			str = day + "天" + hour + "小时" + minute + "分" + s + "秒";
		} catch (Exception e) {
			e.printStackTrace();
			return "-1秒";
		}
		return str;
	}

	/**
	 * 格式化时间
	 * 
	 * @param t
	 *            时间， 格式：xx:xx
	 * @return 字符串，格式：xx分xx秒
	 */
	public static String formatMS(String t) {
		try {
			if (t.length() > 0) {
				t = t.replace(":", "分");
				t += "秒";
			}
			return t;
		} catch (Exception e) {
			return t;
		}
	}

	/**
	 * 格式化时间
	 * 
	 * @param t
	 *            时间， 格式：xx:xx:xx
	 * @return 字符串，格式：xx小时xx分xx秒
	 */
	public static String formatHMS(String t) {
		try {
			if (t.length() > 0) {
				t = t.replaceFirst(":", "小时");
				t = t.replaceFirst(":", "分");
				t += "秒";
			}
			return t;
		} catch (Exception e) {
			return t;
		}
	}

	/**
	 * 获取时间随机数
	 * 
	 * @return Long 十三位随机数，如：1381495771952
	 */
	public static Long getRandom() {
		return System.currentTimeMillis();
	}

	/**
	 * 检测时间是否格式符合yyyy-MM-dd HH:mm:ss 或者yyyy/MM/dd HH:mm:ss或者yyyy.MM.dd HH:mm:ss
	 * 若符合该格式返回true
	 * 
	 * @param dateString
	 * @return
	 */
	public static boolean testDateTime(String dateString) {
		dateString = dateString.replace("/", "-").replace(".", "-");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf1.parse(dateString);
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = (String) f.format(date);
			if (!dateString.trim().equals(str)) {
				return false;
			}
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	/**
	 * 检测时间是否格式符合yyyy-MM-dd 或者yyyy/MM/dd 或者yyyy.MM.dd 若符合该格式返回true
	 * 
	 * @param dateString
	 * @return
	 */
	public static boolean testDate(String dateString) {
		dateString = dateString.replace("/", "-").replace(".", "-");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf1.parse(dateString);
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			String str = (String) f.format(date);
			if (!dateString.trim().equals(str)) {
				return false;
			}
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	/**
	 * 根据传进来的参数 number, day 可以得到任何一个星期的任何一天
	 * 
	 * @param number
	 *            为推迟的周数，0表示本周，-1表示向前推迟一周，1表示下周，依次类推
	 * @param day
	 *            为要想得到的星期几，其值为：Calendar.MONDAY（TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY）
	 * @return
	 */
	public static String getAnyDayOfAnyWeek(int number, int day) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, number * 7);
		cal.set(Calendar.DAY_OF_WEEK, day);
		String d = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		return d;
	}

	/**
	 * 根据传进来的参数 number,可以得到几天前或几天后的日期
	 * 
	 * @param number
	 *            为整数表示几天后，负数表示几天前，例如 ：0表示今天，-1表示昨天，1表示明天
	 * @return
	 */
	public static String getAnyDayWithToday(int number) {
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		calendar.add(Calendar.DATE, number);//
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}
	
	public static String getAnyDayWithToday(String time, int number) {
		Date date=null;
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		try {
			date=formatter.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE,number);//
		date=calendar.getTime(); //这个时间就是日期往后推一天的结果 
		return formatter.format(date);
	}

	/**
	 * 根据传进来的参数 number,可以得到几月前或几月后的日期
	 * 
	 * @param number
	 *            为整数表示几周后，负数表示几月前，例如 ：0表示今天，-1表示上月，1表示下月
	 * @return
	 */
	public static String getMonthWithToday(int number) {
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, number);//
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 得到本周周一
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getMondayOfThisWeek() {
		Calendar c = Calendar.getInstance();
		int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayofweek == 0)
			dayofweek = 7;
		c.add(Calendar.DATE, -dayofweek + 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(c.getTime());
	}

	/**
	 * 得到本周周日
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getSundayOfThisWeek() {
		Calendar c = Calendar.getInstance();
		int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayofweek == 0)
			dayofweek = 7;
		c.add(Calendar.DATE, -dayofweek + 7);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(c.getTime());
	}

	/**
	 * 得到本月第一天
	 * 
	 * @return
	 */
	public static String getFristDateOfMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int days = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, days);
		String result = format.format(cal.getTime());
		return result;
	}

	/**
	 * 得到本月最后一天
	 * 
	 * @return
	 */
	public static String getLastDateOfMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, days);
		String result = format.format(cal.getTime());
		return result;
	}

	/**
	 * 比较两个日期(yyyy-MM)前后，若DATE1在于DATE2之前返回-1，DATE1在于DATE2之后返回1
	 * 
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static int compare_dateYM(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() >= dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 比较两个日期(yyyy-MM-dd)前后，若DATE1在于DATE2之前返回-1，DATE1在于DATE2之后返回1
	 * 
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static int compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() >= dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 比较两个时间(yyyy-MM-dd
	 * HH:ss:mm)前后，若dateTime1在于dateTime2之前返回-1，dateTime1在于dateTime2之后返回1
	 * 
	 * @param dateTime1
	 * @param dateTime2
	 * @return
	 */
	public static int compare_dateTime(String dateTime1, String dateTime2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			if (StringUtils.isBlank(dateTime1)) {// dateTime1为空，dateTime2不为空，返回-1，否则返回1
				if (StringUtils.isNotBlank(dateTime2)) {
					return -1;
				}
				return 1;
			} else if (StringUtils.isBlank(dateTime2)) {// dateTime1不为空，dateTime2为空，返回1
				return 1;
			}
			Date dt1 = df.parse(dateTime1);
			Date dt2 = df.parse(dateTime2);
			if (dt1.getTime() >= dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 日期字符串转换成日期类
	 * 
	 * @param dateString
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public static Date string2Date(String dateString, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = new Date();
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String formatStringDate(String dateString, String pattern, String newPattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = new Date();
		try {
			date = sdf.parse(dateString);
			sdf.applyPattern(newPattern);
			return sdf.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 得到对比日期变化的目标日期 getDateChange("2003-10-15",1)="2003-10-16";
	 * 
	 * @param strCurrentDate
	 *            当前日期 格式 "2000-01-01"
	 * @param iQuantity
	 *            变化的数量 以天为单位
	 * @return strTarget 返回的结果，格式 "2000-01-01"，String 类型
	 * @exception 得到对比日期变化的目标日期错误
	 */
	public static String getDateChange(String strCurrentDate, int iQuantity) {
		String strTarget = "";
		int iYear = Integer.parseInt(strCurrentDate.substring(0, 4));
		int iMonth = Integer.parseInt(strCurrentDate.substring(5, 7));
		int iDay = Integer.parseInt(strCurrentDate.substring(8, 10));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, iYear);
		cal.set(Calendar.MONTH, iMonth - 1);
		cal.set(Calendar.DAY_OF_MONTH, iDay);
		cal.add(Calendar.DATE, iQuantity);
		Date currentDate = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		strTarget = formatter.format(currentDate);
		return strTarget;
	}

	/**
	 * 得到对比日期变化的目标日期包含时间 getDateTimeChange("2003-10-15 15:23:12",1)="2003-10-16
	 * 15:23:12";
	 * 
	 * @param strCurrentTime
	 *            当前日期 格式 "2003-10-15 15:23:12"
	 * @param iQuantity
	 *            变化的数量 以天为单位
	 * @return strTarget 返回的结果，格式 "2003-10-15 15:23:12"，String 类型
	 * @exception 得到对比日期变化的目标日期错误
	 */
	public static String getDateTimeChange(String strCurrentTime, int iQuantity) {
		String strTarget = "";
		String strHHMMSS = strCurrentTime.substring(10, 19);
		int iYear = Integer.parseInt(strCurrentTime.substring(0, 4));
		int iMonth = Integer.parseInt(strCurrentTime.substring(5, 7));
		int iDay = Integer.parseInt(strCurrentTime.substring(8, 10));

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, iYear);
		cal.set(Calendar.MONTH, iMonth - 1);
		cal.set(Calendar.DAY_OF_MONTH, iDay);
		cal.add(Calendar.DATE, iQuantity);
		Date currentDate = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		strTarget = formatter.format(currentDate);
		strTarget = strTarget + strHHMMSS;
		return strTarget;
	}

	/**
	 * 得到对比日期变化的目标日期包含时间 getDateTimeChange("2003-10-15 15:23:12",1)="2003-10-15
	 * 16:23:12";
	 * 
	 * @param strCurrentTime
	 *            当前日期 格式 "2003-10-15 15:23:12"
	 * @param iQuantity
	 *            变化的数量 以小时为单位
	 * @return strTarget 返回的结果，格式 "2003-10-15 15:23:12"，String 类型
	 * @exception 得到对比日期变化的目标日期错误
	 */
	public static String getDateTimeHourChange(String strCurrentTime, int iQuantity) {

		int iYear = Integer.parseInt(strCurrentTime.substring(0, 4));
		int iMonth = Integer.parseInt(strCurrentTime.substring(5, 7)) - 1;
		int iDay = Integer.parseInt(strCurrentTime.substring(8, 10));
		int iHour = Integer.parseInt(strCurrentTime.substring(11, 13));
		int iMinute = Integer.parseInt(strCurrentTime.substring(14, 16));
		int iSecond = Integer.parseInt(strCurrentTime.substring(17, 19));
		GregorianCalendar gc = new GregorianCalendar(iYear, iMonth, iDay, iHour, iMinute, iSecond);
		gc.add(GregorianCalendar.HOUR_OF_DAY, iQuantity);
		Date date = gc.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);

	}

	/**
	 * 得到大日期对小日期的差数 getDateMargin("2003-10-15","2003-10-17")=2;
	 * 
	 * @param strBeginDate
	 *            开始日期 格式 "2003-10-15"
	 * @param strEndDate
	 *            结束日期 格式 "2003-10-17"
	 * @return iMargin 返回的结果，int 类型
	 * @exception 日期格式不对引起的错误
	 */
	public static int getDateMargin(String strBeginDate, String strEndDate) {
		int iMargin = 0;
		if (strEndDate.compareTo(strBeginDate) < 0) {
			iMargin = -1;
		} else {
			int iBeginYear = Integer.parseInt(strBeginDate.substring(0, 4));
			int iBeginMonth = Integer.parseInt(strBeginDate.substring(5, 7));
			int iBeginDay = Integer.parseInt(strBeginDate.substring(8, 10));
			Calendar begincal = Calendar.getInstance();
			begincal.set(Calendar.YEAR, iBeginYear);
			begincal.set(Calendar.MONTH, iBeginMonth - 1);
			begincal.set(Calendar.DAY_OF_MONTH, iBeginDay);

			long lBeginDate = begincal.getTimeInMillis();

			int iEndYear = Integer.parseInt(strEndDate.substring(0, 4));
			int iEndMonth = Integer.parseInt(strEndDate.substring(5, 7));
			int iEndDay = Integer.parseInt(strEndDate.substring(8, 10));
			Calendar endcal = Calendar.getInstance();
			endcal.set(Calendar.YEAR, iEndYear);
			endcal.set(Calendar.MONTH, iEndMonth - 1);
			endcal.set(Calendar.DAY_OF_MONTH, iEndDay);
			long lDateMillis = 1000 * 60 * 60 * 24;
			long lEndDate = endcal.getTimeInMillis();
			long lMargin = (lEndDate - lBeginDate) / lDateMillis;
			iMargin = Integer.parseInt(String.valueOf(lMargin));
		}
		return iMargin;
	}

	/**
	 * 获取指定日期1是否在指定日期2之后
	 * 
	 * @param date1
	 *            日期（yyyy-mm-dd HH:mm:ss）
	 * @param date2
	 *            日期（yyyy-mm-dd HH:mm:ss）
	 * @return boolean
	 */
	public static boolean getDateTimeAfter(String date1, String date2) {
		boolean value = false;
		try {
			Date dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date1);
			Date dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date2);
			value = dateFormat1.after(dateFormat2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 获取指定日期1是否在指定日期2之后
	 * 
	 * @param date1
	 *            日期（yyyy-mm-dd）
	 * @param date2
	 *            日期（yyyy-mm-dd）
	 * @return boolean
	 */
	public static boolean getAfter(String date1, String date2) {
		boolean value = false;
		try {
			Date dateFormat1 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
			Date dateFormat2 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
			value = dateFormat1.after(dateFormat2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void main(String[] args) {
		 /*System.out.println(getTimeDiffS("2013-9-23 11:44:32", "2013-9-24 11:44:32"));
		 System.out.println("@@"+getTimeDiffS("2013-9-24 11:44:32", "2013-9-23 11:44:32"));
		 System.out.println(getTimeDiffM("2013-9-24 11:44:32", "2013-9-24 11:43:13"));
		 System.out.println(getTimeDiffH("2013-9-23 12:45:13", "2013-9-24 12:45:13"));
		 System.out.println(getTimeDiffD("2013-9-24 12:45:13", "2013-9-23 12:45:13"));
		 System.out.println(getTimeDiff("2013-12-23 09:49:32", "2013-9-24 11:44:07"));
		 System.out.println(getTimeDiff("20131223094932", "20130924114407", "yyyyMMddHHmmss"));
		 System.out.println(DateTime.formatStringDate("20160726024928", "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss"));
		System.out.println(DateTime.getMonthWithToday(-1));
		 DateRange currentQuarter = getThisQuarter();  
	        System.out.println("当前季度的时间范围： "+currentQuarter.getStart()+" - "+currentQuarter.getEnd());  	          
	          
	        DateRange yesterdayRange = getYesterdayRange();  
	        System.out.println("昨天的时间范围: "+yesterdayRange.getStart()+" - "+yesterdayRange.getEnd());  
	          
	        DateRange thisMonth = getThisMonth();  
	        System.out.println("当前月份的时间范围: "+thisMonth.getStart()+" - "+thisMonth.getEnd());  
	          
	        DateRange lastMonth = getLastMonth();  
	        System.out.println("上个月的时间范围: "+(lastMonth.getStart()+" - "+lastMonth.getEnd()));  
	          
	        DateRange lastQuarter = getLastQuarter();  
	        System.out.println("上个季度的时间范围: "+(lastQuarter.getStart()+" - "+lastQuarter.getEnd())); 
	        
	        DateRange lastWeek = getLastWeek();  
	        System.out.println("上周的时间范围: "+(lastWeek.getStart()+" - "+lastWeek.getEnd())); */
		/*for (int i = 0; i < 10; i++) {
			System.out.println(DateTime.getTrscd());
		}
		System.out.println(DateTime.getLastDateOfMonth());
		
		System.out.println(DateTime.getFristDateOfMonth());*/
		System.out.println(DateTime.getStationTaskid(1));

	}

	/**
	 * 得出两个月份以及两月份之间所有月份的月份集合
	 * 
	 * @param beginMonth
	 * @param endMonth
	 * @return
	 */
	public static List<String> getYearMonthDiff(String beginMonth, String endMonth) {
		List<String> monthslist = new ArrayList<String>();
		try {
			int min_year = 0;// 最小年
			int min_month = 0;// 最小年对应的月份
			String[] min_total = new String[2];// 初始化长度为2
			String[] max_total = new String[2];
			int max_year = 0;// 最大年
			int max_month = 0;// 最大年对应的月份

			min_total = beginMonth.split("-");
			min_year = Integer.parseInt(min_total[0]);
			min_month = Integer.parseInt(min_total[1]);

			max_total = endMonth.split("-");// 拆分最后一条统计数据
			max_year = Integer.parseInt(max_total[0]);
			max_month = Integer.parseInt(max_total[1]);

			int temp_month = 0;// 用于记录第一次循环结束后的月份，用来确定是否继续执行第二个循环添加

			// 最小年到年底的几个月
			for (int i = min_month; i < 13; i++) {
				if (String.valueOf(i).length() == 1) {
					monthslist.add(min_year + "-0" + i);// 当月份为前十个月时，将月份格式改为例如：“01”形式
				} else {
					monthslist.add(min_year + "-" + i);
				}
				if (min_year == max_year && i == max_month) {// 用于判断是否添加日期完毕
					temp_month = i;
					break;
				}
				temp_month = i;
			}

			// 此判断用来确定是否通过上边的循环已结束了日期添加，添加未结束则继续添加，否则不再添加
			if (!(min_year == max_year && temp_month == max_month)) {
				for (int i = min_year + 1; i <= max_year; i++) {// 年度循环
					for (int j = 1; j < 13; j++) {// 月份循环
						if (String.valueOf(j).length() == 1) {
							monthslist.add(i + "-0" + j);// 当月份为前十个月时，将月份格式改为例如：“01”形式
						} else {
							monthslist.add(i + "-" + j);
						}
						if (i == max_year && j == max_month) {// 用于判断是否添加日期完毕
							break;
						}
					}
				}
			}

			return monthslist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static int GetWeekOfYear() {
		Calendar curr = Calendar.getInstance();
		int week = curr.get(Calendar.WEEK_OF_YEAR);
		System.out.println("今天是今年的第几周：" + week);
		return week;
	}

	/**
	 * 根据当前日期计算前几年的日期，返回格式：yyyy-MM-dd；例如前2年：iQuantity=-2
	 * 
	 * @param iQuantity
	 * @return
	 */
	public static String getBeforeDate(int iQuantity) {
		Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
		ca.setTime(new Date()); // 设置时间为当前时间
		ca.add(Calendar.YEAR, iQuantity); // 几年前
		Date resultDate = ca.getTime(); // 结果
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(resultDate);
	}

	/**
	 * @param date1
	 *            需要比较的时间 不能为空(null),需要正确的日期格式
	 * @param date2
	 *            被比较的时间 为空(null)则为当前时间
	 * @param stype
	 *            返回值类型0为多少天，1为多少个月，2为多少年
	 * @return
	 */
	public static int compareDate(String date1, String date2, int stype) {
		int n = 0;

		String formatStyle = stype == 1 ? "yyyy-MM" : "yyyy-MM-dd";

		date2 = date2 == null ? getDate() : date2;

		DateFormat df = new SimpleDateFormat(formatStyle);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			c1.setTime(df.parse(date1));
			c2.setTime(df.parse(date2));
		} catch (Exception e3) {
			System.out.println("wrong occured");
		}
		// List list = new ArrayList();
		while (!c1.after(c2)) {// 循环对比，直到相等，n 就是所要的结果
			// list.add(df.format(c1.getTime())); // 这里可以把间隔的日期存到数组中 打印出来
			n++;
			if (stype == 1) {
				c1.add(Calendar.MONTH, 1); // 比较月份，月份+1
			} else {
				c1.add(Calendar.DATE, 1);// 比较天数，日期+1
			}
		}

		n = n - 1;

		if (stype == 2) {
			n = (int) n / 365;
		}

		// System.out.println(date1+" -- "+date2+" 相差多少"+u[stype]+":"+n);
		return n;
	}

	
	/** 
     * 获取date的月份的时间范围 
     * @param date 
     * @return 
     */  
    public static DateRange getMonthRange(Date date) {  
        Calendar startCalendar = Calendar.getInstance();  
        startCalendar.setTime(date);  
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);  
        setMaxTime(startCalendar);  
          
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.setTime(date);  
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
        setMaxTime(endCalendar);  
        
        return new DateRange(format(startCalendar.getTime()), format(endCalendar.getTime()));  
    }  
    /** 
     * 获取当前季度的时间范围 
     * @return current quarter 
     */  
    public static DateRange getThisQuarter() {  
        Calendar startCalendar = Calendar.getInstance();  
        startCalendar.set(Calendar.MONTH, ((int) startCalendar.get(Calendar.MONTH) / 3) * 3);  
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);  
        setMinTime(startCalendar);  
          
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.set(Calendar.MONTH, ((int) startCalendar.get(Calendar.MONTH) / 3) * 3 + 2);  
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
        setMaxTime(endCalendar);  
          
        return new DateRange(format(startCalendar.getTime()), format(endCalendar.getTime()));  
    }  
     
    
    /** 
     * 获取昨天的时间范围 
     * @return 
     */  
    public static DateRange getYesterdayRange() {  
         Calendar startCalendar = Calendar.getInstance();  
         startCalendar.add(Calendar.DAY_OF_MONTH, -1);  
         setMinTime(startCalendar);  
           
         Calendar endCalendar = Calendar.getInstance();  
         endCalendar.add(Calendar.DAY_OF_MONTH, -1);  
         setMaxTime(endCalendar);  
           
         return new DateRange(format(startCalendar.getTime()), format(endCalendar.getTime()));  
    }  
      
    /** 
     * 获取当前月份的时间范围 
     * @return 
     */  
    public static DateRange getThisMonth(){  
        Calendar startCalendar = Calendar.getInstance();  
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);  
        setMinTime(startCalendar);  
          
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
        setMaxTime(endCalendar);  
          
        return new DateRange(format(startCalendar.getTime()), format(endCalendar.getTime()));  
    }  
      
    /** 
     * 获取上个月的时间范围 
     * @return 
     */  
	public static DateRange getLastMonth(){  
        Calendar startCalendar = Calendar.getInstance();  
        startCalendar.add(Calendar.MONTH, -1);  
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);  
        setMinTime(startCalendar);  
          
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.add(Calendar.MONTH, -1);  
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
        setMaxTime(endCalendar);  
          
        return new DateRange(format(startCalendar.getTime()), format(endCalendar.getTime()));  
    }  
	/** 
     * 获取上周的时间范围 
     * @return 
     */  
	public static DateRange getLastWeek(){  
        Calendar startCalendar = Calendar.getInstance();  
        startCalendar.add(Calendar.WEEK_OF_MONTH, -1);  
        startCalendar.set(Calendar.DAY_OF_WEEK, 1);  
        setMinTime(startCalendar);  
          
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.add(Calendar.WEEK_OF_MONTH, -1);  
        endCalendar.set(Calendar.DAY_OF_WEEK, endCalendar.getActualMaximum(Calendar.DAY_OF_WEEK));  
        setMaxTime(endCalendar);  
          
        return new DateRange(format(startCalendar.getTime()), format(endCalendar.getTime()));  
    }  
    /** 
     * 获取上个季度的时间范围 
     * @return 
     */  
    public static DateRange getLastQuarter() {  
        Calendar startCalendar = Calendar.getInstance();  
        startCalendar.set(Calendar.MONTH, ((int) startCalendar.get(Calendar.MONTH) / 3 - 1) * 3);  
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);  
        setMinTime(startCalendar);  
          
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.set(Calendar.MONTH, ((int) endCalendar.get(Calendar.MONTH) / 3 - 1) * 3 + 2);  
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
        setMaxTime(endCalendar);  
          
        return new DateRange(format(startCalendar.getTime()), format(endCalendar.getTime()));  
    }  
      
    private static void setMinTime(Calendar calendar){  
        calendar.set(Calendar.HOUR_OF_DAY, 0);  
        calendar.set(Calendar.MINUTE, 0);  
        calendar.set(Calendar.SECOND, 0);  
        calendar.set(Calendar.MILLISECOND, 0);  
    }  
      
    private static void setMaxTime(Calendar calendar){  
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));  
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));  
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));  
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));  
    }  
      
      
    public final static String DEFAULT_PATTERN = "YYYY-MM-dd HH:mm:ss";  
    public static String format(Date date){  
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);  
        return sdf.format(date);  
    }  
      
   
    
    
}
 