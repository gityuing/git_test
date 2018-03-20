package com.hwua.Logical_processing.uesr;

import java.math.BigDecimal;
import java.util.List;

import com.hwua.control.initSys.Userobj;
import com.hwua.pojo.Car;
import com.hwua.util.template.Template;
import com.hwua.view.Myprint;

public class LookBorweCar {
	private static final String tableHad = "|租借编号\t\t|car编号\t\t|car名称\t\t|租借数\t\t|租借时间";
	BigDecimal b_id;
	BigDecimal c_id;
	String sta_date;
	String c_name;
	BigDecimal borrwenum;
	
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
	

	public BigDecimal getC_id() {
		return c_id;
	}

	public void setC_id(BigDecimal c_id) {
		this.c_id = c_id;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return "|"+this.getB_id()+"\t\t|"+this.getC_id()+"\t\t|"+this.getC_name()+"\t\t|"+this.getBorrwenum()+"\t\t|"+this.getSta_date();
	}

	//查看 当前 user借的 车 
	public static void lookb_b(){
		Userobj userobj = Userobj.getUserobj();
		
		BigDecimal uId = userobj.getUser().getU_id();
		String sql = "select b_id,car.c_id,car.c_name , b_borrwe.borrwenum ,sta_date from car,b_borrwe where car.c_id=b_borrwe.c_id and b_borrwe.u_id = ? and end_date is null";
		List<LookBorweCar> cars = Template.DQLsTemplate(sql, LookBorweCar.class,uId);
		Myprint.myPrint(cars, tableHad);
	}
	//查看 当前 user借的 对应id车 
	public static void lookById(BigDecimal cId){
		Userobj userobj = Userobj.getUserobj();
		
		BigDecimal uId = userobj.getUser().getU_id();
		String sql = "select b_id,car.c_id,car.c_name , b_borrwe.borrwenum ,sta_date from car,b_borrwe where car.c_id=b_borrwe.c_id and b_borrwe.u_id = ? and b_borrwe.c_id = ? and end_date is null";
		List<LookBorweCar> cars = Template.DQLsTemplate(sql, LookBorweCar.class,uId,cId);
		Myprint.myPrint(cars, tableHad);
	}
	
}
