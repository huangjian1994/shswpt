package com.htcf.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 *日期工具处理类：主要用于实现  {java.util.Calendar}、{java.util.Date}、{java.sql.date}
 *之间相互的转换；最常用的方法是dateToString()方法和stringToUtilDate()。
 * @author:wsg
 * 
 */
public final class DateUtil {
	
	/**
	 * 将Date类型的日期转换成String类型"任意"格式
	 * java.sql.date,java.sql.Timestamp类型是java.util.Date类型的子类
	 * @param date	需要转换的日期
	 * @param format  "2014-01-01"格式  "yyyy年MM月dd日""yyyy-MM-dd HH:mm:ss"格式
	 * @return 表示日期的字符串
	 */
	public static String dateToString(java.util.Date date,String format){
		if(date==null||StringUtil.isBlank(format)) return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String str = sdf.format(date);
		return str;
	}
	
	
	/**
	 * 将String类型的日期转换成java.util.Date类型"2014-01-01"
	 * @param str 需要格式化的日期
	 * @param format  "2014-01-01"格式  "yyyy年MM月dd日""yyyy-MM-dd HH:mm:ss"格式
	 * @return java.util.Date 日期对象
	 */
	public static java.util.Date StringToUtilDate(String str,String format){
		if(StringUtil.isBlank(str)||StringUtil.isBlank(format)) return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		java.util.Date date = null;
		try{
			date = sdf.parse(str);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	/**
	 * 将String类型的日期转换成java.sql.Date类型"2014-01-01"
	 * @param str 需要格式化的日期
	 * @param format  "2014-01-01"格式  "yyyy年MM月dd日""yyyy-MM-dd HH:mm:ss"格式
	 * @return java.sql.Date 日期对象
	 */
	public static java.sql.Date StringToSqlDate(String str,String format){
		if(StringUtil.isBlank(str)||StringUtil.isBlank(format)) return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		java.util.Date date = null;
		try{
			date = sdf.parse(str);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new java.sql.Date(date.getTime());
	}
	
	/**
	 * 将java.util.Date日期转化成java.sql.Date类型。
	 * 
	 * @param date 需要转换的日期
	 * @return 格式化后的java.sql.Date。
	 */
	public static java.sql.Date toSqlDate(java.util.Date date)
	{
		if (date == null) return null; 
		return new java.sql.Date(date.getTime());
	}
	
	/**
	 * 将日历转换成日期
	 * @param calendar 需要转换的日历实例
	 * @return 转换后的日期
	 */
	public static java.util.Date converToDate(java.util.Calendar calendar){
		return calendar.getTime();
	}
	
	
	/**
	 * 将日期转换成日历
	 * @param date 需要转换的日期实例
	 * @return 转换后的日历
	 */
	public static java.util.Calendar converToCalendar(java.util.Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
}
