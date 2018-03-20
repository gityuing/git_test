package com.hwua.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理工具
 * 
 * @author yuing
 *
 */
public class DateUtil {

	// 时间--> 字符串
	public static String date2str(Date date ) {
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat formatDate = new SimpleDateFormat(format);
		String strDate = formatDate.format(date);
		return strDate;
	}

	public static long getDatePoor(Date endDate, Date nowDate) {

		long nd = 1000 * 24 * 60 * 60;

		// 获得两个时间的毫秒时间差异
		long diff = endDate.getTime() - nowDate.getTime();
		// 计算差多少天
		long day = diff / nd;

		return day + 1;
	}

	public static Date str2date(String string) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
