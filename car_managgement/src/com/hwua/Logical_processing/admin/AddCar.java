package com.hwua.Logical_processing.admin;

import java.math.BigDecimal;

import com.hwua.dao.impl.CarDAOImpl;
import com.hwua.pojo.Car;
import com.hwua.util.template.Template;

public class AddCar {
	//BigDecimal c_id,	 String c_name,	 String c_remarks,	 BigDecimal brand_id, BigDecimal type_id,	 BigDecimal c_price,BigDecimal c_borrwe,	 BigDecimal c_number;
	public void addCar(String c_name,String c_remarks,BigDecimal c_brand,  BigDecimal c_type,	 BigDecimal c_price, BigDecimal c_number,String porper){
		String sql = "select count(*) from t_type where t_id=?";
		BigDecimal num = (BigDecimal)Template.selectOne(sql, c_type);

		if(num.intValue()==0){
			System.err.println("你输入的类型编号不正确！");
			return;
		}
		sql = "select count(*) from t_brand where b_id=?";
		num = (BigDecimal)Template.selectOne(sql, c_brand);
		
		if(num.intValue()==0){
			System.err.println("你输入的品牌编号不正确！");
			return;
		}
		
		Car car = new Car(c_name, c_remarks, c_brand, c_type, c_price,new BigDecimal(0), c_number,porper);
		CarDAOImpl bookDAOImpl = new CarDAOImpl();
		bookDAOImpl.add(car);
	}
}
