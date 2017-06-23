/*
 *  =========================================================================
 *   Copyright(c) 2015-2016. Jibinfo System Inc. All Rights Reserved.
 *
 *   注意:本内容仅限于南京坚卓软件科技公司内部传阅，禁止外泄以及用于其他的商业目的
 *  =========================================================================
 *
 */

package com.jibinfo.finance.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @author GZJ
 * @date 2015-10-14 下午1:25:38
 * @classDescription
 * 时间的工具类<br>
 * 	   G 年代标志符<br>
	   y 年<br>
	   M 月<br>
	   d 日<br>
	   h 时 在上午或下午 (1~12)<br>
	   H 时 在一天中 (0~23)<br>
	   m 分<br>
	   s 秒<br>
	   S 毫秒<br>
	   E 星期<br>
	   D 一年中的第几天<br>
	   F 一月中第几个星期几<br>
	   w 一年中第几个星期<br>
	   W 一月中第几个星期<br>
	   a 上午 / 下午 标记符<br>
	   k 时 在一天中 (1~24)<br>
	   K 时 在上午或下午 (0~11)<br>
	   z 时区<br>
 * @version 1.0.0
 */
public class DateUtils {
	
	/**
	 * @Author GZJ
	 * @Date   2015-11-12上午10:45:15
	 * @Description
	 * 获得给定时间的 00:00:00的时间 <br>
	 * 例:2015-03-12或者2015-03-12 12:12:12 <br>
	 *  返回2015-03-12 <font color='red'>00:00:00</font>
	 * @return  string
	 */
	public static String getStrDateFirst(Date date){
		String strDate = dateToStr(date, FORMAT_DATE);
		strDate = strDate +" 00:00:00";
		return strDate;
	}

	public static String getStrDateFirst(String date){
		date = date.trim();
		date = date +" 00:00:00";
		return date;
	}
	
	/**
	 * @Author GZJ
	 * @Date   2015-11-12上午10:45:15
	 * @Description
	 * 获得给定时间的 00:00:00的时间 <br>
	 * 例:2015-03-12或者2015-03-12 12:12:12 <br>
	 *  返回2015-03-12 <font color='red'>00:00:00</font>
	 * @return  date
	 */
	public static Date getDateFirst(Date date){
		return strToDate(getStrDateFirst(date));
		
	}
	
	/**
	 * @Author GZJ
	 * @Date   2015-11-12上午10:48:40
	 * @Description
	 * 获得给定时间的 23:59:59的时间<br>
	 * 例:2015-03-12或者2015-03-12 12:12:12<br>
	 *  返回2015-03-12 <font color='red'>23:59:59</font>
	 * @param date
	 * @return String
	 */
	public static String getStrDateLast(Date date){
		String strDate = dateToStr(date, FORMAT_DATE);
		strDate = strDate +" 23:59:59";
		return strDate;
	}

	public static String getStrDateLast(String date){
		date = date.trim();
		date = date +" 23:59:59";
		return date;
	}
	
	/**
	 * @Author GZJ
	 * @Date   2015-11-12上午10:48:40
	 * @Description
	 * 获得给定时间的 23:59:59的时间<br>
	 * 例:2015-03-12或者2015-03-12 12:12:12<br>
	 *  返回2015-03-12 <font color='red'>23:59:59</font>
	 * @param date
	 * @return date
	 */
	public static Date getDateLast(Date date){
		return strToDate(getStrDateLast(date));
	}
	
	/**
	 * @author GZJ
	 * @date 2015-10-14 下午2:02:34
	 * @methodDescription
	 * 自定义的日期类型转字符类型
	 * @param strDate
	 * @param format<br>
	 * DateUtils.FORMAT_DATE_TIME = yyyy-MM-dd HH:mm:ss<br>
	 * DateUtils.FORMAT_DATE = yyyy-MM-dd ....
	 * @return
	 */
	public static String dateToStr(Date strDate,String format){
		// if(null == strDate || "null".equals(strDate)){
		if (null == strDate) {
			return null;
		}
		if(null == format){
			format = FORMAT_DATE_TIME;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(strDate);
	}
	
	
	/**
	 * @author GZJ
	 * @date 2015-10-14 下午2:03:00
	 * @methodDescription
	 * 日期类型转字符类型
	 * <默认格式 yyyy-MM-dd HH:mm:ss>
	 * @param strDate
	 * @return
	 */
	public static String dateToStrDate(Date strDate){
		return dateToStr(strDate,null);
	}
	
	
	/**
	 * @author GZJ
	 * @date 2015-10-14 下午1:49:44
	 * @methodDescription
	 * 自定义的日期格式 字符转转日期类型 
	 * @param strDate
	 * @param foramt<br>
	 * DateUtils.FORMAT_DATE_TIME = yyyy-MM-dd HH:mm:ss<br>
	 * DateUtils.FORMAT_DATE = yyyy-MM-dd ....
	 * @return
	 */
	public static Date strDateToDate(String strDate,String foramt){
		if(null == foramt){
			foramt = FORMAT_DATE_TIME;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(foramt);
		try {
			return sdf.parse(strDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @author GZJ
	 * @date 2015-10-14 下午2:10:54
	 * @methodDescription
	 * 字符转转日期类型  
	 * <默认格式  yyyy-MM-dd HH:mm:ss>
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate){
		return strDateToDate(strDate, null);
	}
	
	/**
	 * @author GZJ
	 * @date 2015-10-14 下午1:07:37
	 * @methodDescription
	 * 获取两个时间直接的差值,年 月 日 时 分 秒
	 * @param staDate
	 * @param endDate
	 * @param type
	 * DateUtils.HOUR <br>DateUtils.MIN <br>DateUtils.SEC
	 * @return
	 */
	public static long count(Date staDate,Date endDate,String type){
		Calendar startClr = Calendar.getInstance();
		startClr.setTime(staDate);
		Calendar endClr = Calendar.getInstance();
		endClr.setTime(endDate);
		return count(startClr,endClr,type);
	}
	/**
	 * @author GZJ
	 * @date 2015-10-14 下午1:07:37
	 * @methodDescription
	 * 获取两个时间直接的差值,年 月 日 时 分 秒
	 * @param staClr
	 * @param endClr
	 * @param type <br>DateUtils.YEAR <br>DateUtils.MONTH <br>DateUtils.DAY<br>
	 * 			   DateUtils.HOUR <br>DateUtils.MIN <br>DateUtils.SEC
	 * @return 传入类型的差值:<br>传入seconds则返回的就是秒数的差值,<br>
	 * 					 传入minutes则返回的就是分钟的差值......
	 */
	public static long count(Calendar staClr,Calendar endClr,String type){
		long count = -1;
		if(type.equals(TYPE_DAY) || type.equals(TYPE_HOUR) || type.equals(TYPE_MIN) || type.equals(TYPE_SEC)){
			Long seconds = getSeconds(type);
			long start = staClr.getTimeInMillis();
			long end = endClr.getTimeInMillis();
			long duration = end - start;
			count = duration / seconds;
		}
		else if(type.equals(TYPE_YEAR)){
			int staYear = staClr.get(Calendar.YEAR);
			int endYear = endClr.get(Calendar.YEAR);
			count = endYear - staYear;
		}
		else if(type.equals(TYPE_MONTH)){
			int staYear = staClr.get(Calendar.YEAR);
			int staMon = staClr.get(Calendar.MONTH);
			int endYear = endClr.get(Calendar.YEAR);
			int endMon = endClr.get(Calendar.MONTH);
			if(staYear == endYear){
				count = endMon - staMon;
			}
			else{
				int years = endYear - staYear;
				count = (years * 12 + endMon) - staMon;
			}
		}
		return count;
	}
	
	
	
	/**
	 * @author GZJ
	 * @date 2015-10-14 上午11:17:07
	 * @methodDescription
	 * 获取新的时间 
	 * @param srcDate
	 * @param yMdHms 
	 *  年 月 日 时 分 秒
	 * @return
	 */
	public static Date getOtherDate(Date srcDate,int...yMdHms){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(srcDate);
		if(null != yMdHms && yMdHms.length > 0 ){
			if(yMdHms.length == 6){
				calendar.add(Calendar.SECOND, yMdHms[5]);
				calendar.add(Calendar.MINUTE, yMdHms[4]);
				calendar.add(Calendar.HOUR, yMdHms[3]);
				calendar.add(Calendar.DATE, yMdHms[2]);
				calendar.add(Calendar.MONTH, yMdHms[1]);
				calendar.add(Calendar.YEAR, yMdHms[0]);
			}
			else if(yMdHms.length == 5){
				calendar.add(Calendar.MINUTE, yMdHms[4]);
				calendar.add(Calendar.HOUR, yMdHms[3]);
				calendar.add(Calendar.DATE, yMdHms[2]);
				calendar.add(Calendar.MONTH, yMdHms[1]);
				calendar.add(Calendar.YEAR, yMdHms[0]);
			}
			else if(yMdHms.length == 4){
				calendar.add(Calendar.HOUR, yMdHms[3]);
				calendar.add(Calendar.DATE, yMdHms[2]);
				calendar.add(Calendar.MONTH, yMdHms[1]);
				calendar.add(Calendar.YEAR, yMdHms[0]);
			}
			else if(yMdHms.length == 3){
				calendar.add(Calendar.DATE, yMdHms[2]);
				calendar.add(Calendar.MONTH, yMdHms[1]);
				calendar.add(Calendar.YEAR, yMdHms[0]);
			}
			else if(yMdHms.length == 2){
				calendar.add(Calendar.MONTH, yMdHms[1]);
				calendar.add(Calendar.YEAR, yMdHms[0]);
			}
			else if(yMdHms.length == 1){
				calendar.add(Calendar.YEAR, yMdHms[0]);
			}
		}
		return calendar.getTime();
	}
	
	/**
	 * @author GZJ
	 * @date 2015-10-14 上午11:17:07
	 * @methodDescription
	 * 获取新的时间
	 * @param srcDate
	 * @param year 年
	 * @return
	 */
	public static Date getDate(Date srcDate,int year){
		return getOtherDate(srcDate, year);
	}
	
	
	/**
	 * @author GZJ
	 * @date 2015-10-14 上午11:17:07
	 * @methodDescription
	 * 获取新的时间
	 * @param srcDate
	 * @param year 年
	 * @param month 月
	 * @return
	 */
	public static Date getDate(Date srcDate,int year,int month){
		return getOtherDate(srcDate, year, month );
	}
	
	

	/**
	 * @author GZJ
	 * @date 2015-10-14 上午11:17:07
	 * @methodDescription
	 * 获取新的时间
	 * @param srcDate
	 * @param year    年
	 * @param month   月
	 * @param day     日
	 * @return
	 */
	public static Date getDate(Date srcDate,int year,int month,int day){
		return getOtherDate(srcDate, year, month, day );
	}
	
	
	/**
	 * @author GZJ
	 * @date 2015-10-14 上午11:17:07
	 * @methodDescription
	 * 获取新的时间
	 * @param srcDate
	 * @param year   年
	 * @param month  月
	 * @param day    日
	 * @param hour   时
	 * @return
	 */
	public static Date getDate(Date srcDate,int year,int month,int day,int hour){
		return getOtherDate(srcDate, year, month, day, hour );
	}
	/**
	 * @author GZJ
	 * @date 2015-10-14 上午11:17:07
	 * @methodDescription
	 * 获取新的时间
	 * @param srcDate
	 * @param year  年
	 * @param month 月
	 * @param day   日
	 * @param hour  时
	 * @param min   分
	 * @return
	 */
	public static Date getDate(Date srcDate,int year,int month,int day,int hour,int min){
		return getOtherDate(srcDate, year, month, day, hour, min );
	}
	
	/**
	 * @author GZJ
	 * @date 2015-10-14 上午11:17:07
	 * @methodDescription
	 * 获取新的时间
	 * @param srcDate
	 * @param year   年
	 * @param month  月
	 * @param day    日
	 * @param hour   时
	 * @param min    分
	 * @param sec    秒
	 * @return
	 */
	public static Date getDate(Date srcDate,int year,int month,int day,int hour,int min,int sec){
		return getOtherDate(srcDate, year, month, day, hour, min, sec );
	}
	
	
	/**
	 * @Author GZJ
	 * @Date   2015-11-3下午2:28:02
	 * @Description
	 * 比较两个的date类型的大小
	 * @param date1
	 * @param date2
	 * @return 
	 * date1 > date2 return -1<br>
	 * date1 < date2 return 1<br>
	 * date1 = date2 return 0
	 */
	public static int compareDate(Date date1,Date date2){
		long staTime = date1.getTime();
		long endTime = date2.getTime();
		if(staTime > endTime){
			return -1;
		}
		else if(staTime < endTime){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	
	
	/**
	 * @author GZJ
	 * @date 2015-10-14 下午1:22:27
	 * @methodDescription
	 * 获取响应类型的 秒数的值
	 * @param type
	 * @return
	 */
	public static Long getSeconds(String type){
		if(type.equals(TYPE_DAY)){
			return DAY;
		}
		else if(type.equals(TYPE_HOUR)){
			return HOUR;
		}
		else if(type.equals(TYPE_MIN)){
			return MIN;
		}
		else if(type.equals(TYPE_SEC)){
			return SEC;
		}
		else{
			return 0L;
		}
	}
	
	/**
	 * 1天的毫秒数
	 */
	public static final Long DAY = 1000 * 60 * 60 * 24L ;
	
	/**
	 * 1时的毫秒数
	 */
	public static final Long HOUR = 1000 * 60 * 60L ;
	
	/**
	 * 1分的毫秒数
	 */
	public static final Long MIN = 1000 * 60L;
	
	/**
	 * 1秒的毫秒数
	 */
	public static final Long SEC = 1000L;
	
	/**
	 * 年份类型
	 */
	public static final String TYPE_YEAR = "YEAR";
	
	/**
	 * 月份类型
	 */
	public static final String TYPE_MONTH = "MONTH";
	
	/**
	 * 天数类型
	 */
	public static final String TYPE_DAY = "DAY";
	
	/**
	 * 小时类型
	 */
	public static final String TYPE_HOUR = "HOUR";
	
	/**
	 * 分钟类型
	 */
	public static final String TYPE_MIN = "MIN";
	
	/**
	 * 秒数类型
	 */
	public static final String TYPE_SEC = "SEC";
	
	/**
	 * format格式  yyyy-MM-dd
	 */
	public static final String FORMAT_DATE = "yyyy-MM-dd";
	
	/**
	 * format格式  yyyy-MM-dd HH
	 */
	public static final String FORMAT_DATE_HOUR = "yyyy-MM-dd HH";
	
	/**
	 * format格式  yyyy-MM-dd HH:mm
	 */
	public static final String FORMAT_DATE_MIN = "yyyy-MM-dd HH:mm";
	
	/**
	 * format格式  yyyy-MM-dd HH:mm:ss
	 */
	public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * format格式  yyyy-MM-dd HH:mm:ss E
	 */
	public static final String FORMAT_DATE_TIME_WEEK = "yyyy-MM-dd HH:mm:ss E";
	
	
	
	public static void main(String[] args) {
//		long count = count(new Date(), getDate(new Date(),0,-15),TYPE_MONTH);
//		System.out.println(count);
		System.out.println(dateToStr(new Date(),FORMAT_DATE_TIME_WEEK));
		
//		Calendar calendar = Calendar.getInstance();
//		int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);
//		System.out.println(day_of_week);
//		int day_of_month = calendar.get(Calendar.DAY_OF_MONTH);
//		System.out.println(day_of_month);
//		System.out.println(Calendar.WEDNESDAY);
//		System.out.println(getWeek(getDate(new Date(), 0, 0, 2)));
//		System.err.println(getWeek(getDate(new Date(), 0, 0, 1),LanguageEnum.en_US));


		Date date = DateUtils.strDateToDate(DateUtils.dateToStr(new Date(), "yyyy-MM-dd"), "yyyy-MM-dd");
		Date date1 = DateUtils.getDate(date, 0, 0, -1);
		System.out.println(date);
		System.out.println(date1);
		System.out.println(DateUtils.count(date1,date,DateUtils.TYPE_DAY));






	}
}
