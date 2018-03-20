package com.hwua.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ڴ�����
 * 
 * @author yuing
 *
 */
public class DateUtil {

	// ʱ��--> �ַ���
	public static String date2str(Date date ) {
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat formatDate = new SimpleDateFormat(format);
		String strDate = formatDate.format(date);
		return strDate;
	}

	public static long getDatePoor(Date endDate, Date nowDate) {

		long nd = 1000 * 24 * 60 * 60;

		// �������ʱ��ĺ���ʱ�����
		long diff = endDate.getTime() - nowDate.getTime();
		// ����������
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
