package com.hwua.Logical_processing.admin;

import java.math.BigDecimal;

import com.hwua.dao.impl.CarDAOImpl;

public class DeleteCar {
	//删除 car信息
	public void deleteCar(long id){
		//判断输入的id 是否存在
		CarDAOImpl carDAOImpl = new CarDAOImpl();
		boolean fl = carDAOImpl.idExistent(new BigDecimal(id));
		
		if(!fl){
			System.out.println("你输入的car编号不正确");
			return;
		}
		
		//判断 这种汽车 是否 有待还的 车辆 
		fl = carDAOImpl.borrweIsnull(new BigDecimal(id));
		if(!fl){
			System.out.println("这种汽车  有待还的 车辆 ，不能删除");
			return;
		}
		
		int i = carDAOImpl.delete(new BigDecimal(id));
		if(i==1){
			System.out.println("删除成功！");
		}else{
			System.out.println("删除失败！");
		}
	}
}
