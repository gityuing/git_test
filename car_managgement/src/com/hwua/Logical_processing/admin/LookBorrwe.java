package com.hwua.Logical_processing.admin;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.hwua.util.template.Template;
import com.hwua.view.Myprint;

public class LookBorrwe {
	private static String tableHad = "|租借编号\t\t|用户名\t\t|car名称\t\t|租借数\t\t|租   借   时   间\t\t|还 车 时 间";
	String u_name;
	BigDecimal b_id;
	String sta_date;
	String end_date;
	String c_name;
	BigDecimal borrwenum;

	
	
	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public BigDecimal getBorrwenum() {
		return borrwenum;
	}

	public void setBorrwenum(BigDecimal borrwenum) {
		this.borrwenum = borrwenum;
	}

	public BigDecimal getB_id() {
		return b_id;
	}

	public void setB_id(BigDecimal b_id) {
		this.b_id = b_id;
	}

	public String getSta_date() {
		return sta_date;
	}

	public void setSta_date(String sta_date) {
		this.sta_date = sta_date;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String toString() {
		return "|" + b_id + "\t\t|" + u_name + "\t\t|" + c_name + "\t\t|"
				+ borrwenum + "\t\t|" + sta_date + "\t|" + end_date;
	}

	// 查看 当前 借的 车
	public static void lookb_b(int i) {
		switch (i) {
		case 1:
			//查看未还的信息
			lookAll();
			break;
		case 2:
			//根据car  id
			lookByCarId();
			break;
		case 3:
			//根据 user   id
			lookByUserId();
			break;
			
		case 4:
			//根据 user   id
			lookAlll();
			break;

		default:
			System.out.println("你输入的有误");
			break;
		}

	}

	private static void lookAlll() {
		String sql = "select b_borrwe.b_id, c_user.u_name, car.c_name ,b_borrwe.borrwenum,b_borrwe.sta_date, b_borrwe.end_date from car ,b_borrwe,c_user where car.c_id=b_borrwe.c_id and b_borrwe.u_id=c_user.u_id ";
		List<LookBorrwe> cars = Template.DQLsTemplate(sql, LookBorrwe.class);
		Myprint.myPrint(cars, tableHad);
		
	}

	private static Scanner sc = new Scanner(System.in);

	private static void lookByUserId() {
		System.out.println("请输入 要 查询的 用户的id");
		long id = sc.nextLong();
		String sql = "select b_borrwe.b_id, c_user.u_name, car.c_name ,b_borrwe.borrwenum,b_borrwe.sta_date, b_borrwe.end_date from car ,b_borrwe,c_user where b_borrwe.u_id = ? and car.c_id=b_borrwe.c_id and b_borrwe.u_id=c_user.u_id";
		List<LookBorrwe> cars = Template.DQLsTemplate(sql, LookBorrwe.class,
				new BigDecimal(id));
		Myprint.myPrint(cars, tableHad);

	}

	private static void lookByCarId() {
		System.out.println("请输入 要 查询的 汽车的id");
		long id = sc.nextLong();
		String sql = "select b_borrwe.b_id, c_user.u_name, car.c_name ,b_borrwe.borrwenum,b_borrwe.sta_date, b_borrwe.end_date from car ,b_borrwe,c_user where b_borrwe.c_id = ? and car.c_id=b_borrwe.c_id and b_borrwe.u_id=c_user.u_id";
		List<LookBorrwe> cars = Template.DQLsTemplate(sql, LookBorrwe.class,
				new BigDecimal(id));
		Myprint.myPrint(cars, tableHad);

	}

	private static void lookAll() {

		String sql = "select b_borrwe.b_id, c_user.u_name, car.c_name ,b_borrwe.borrwenum,b_borrwe.sta_date, b_borrwe.end_date from car ,b_borrwe,c_user where car.c_id=b_borrwe.c_id and b_borrwe.u_id=c_user.u_id and end_date is null";
		List<LookBorrwe> cars = Template.DQLsTemplate(sql, LookBorrwe.class);
		Myprint.myPrint(cars, tableHad);
	}

}
