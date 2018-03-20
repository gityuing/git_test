package com.hwua.Logical_processing.uesr;

import java.util.List;
import java.util.Scanner;

import com.hwua.dao.impl.CarDAOImpl;
import com.hwua.pojo.Car;
import com.hwua.view.ChoiceTypeBrand;
import com.hwua.view.Myprint;
//普通用户查看汽车
public class LookCar {
	static final String tableHad = "|汽车编号\t\t|"+"汽车名称\t\t|"+"备注\t\t|"+"品牌\t\t|"+"类型\t\t\t|"+"价格\t\t\t|"+"剩余量\t\t|"+"是否可租";
	
	private static CarDAOImpl carDAOImpl = new CarDAOImpl();
	Scanner scanner = new Scanner(System.in);
	
	
	public void lookCar(int i){
		switch (i) {
		case 1:
			lookAll();
			break;
		case 2:
			//品牌
			lookByBrand();
			break;
		case 3:
			//类型
			
			lookByType();
			break;
		case 4:
			//id 升序
			lookByIdLower();
			break;
		case 5:
			//id 降序
			lookByIdUpper();
			
			break;
			
		default:
			System.out.println("你的输入错误");
			break;
		}
		
	}
	
	//id降序
	private void lookByIdLower() {
		List<Car> cars = carDAOImpl.selectByIdLower();
		Myprint.myPrint(cars, tableHad);
	}

	//id升序
	private void lookByIdUpper() {
		List<Car> cars = carDAOImpl.selectByIdUpper();
		Myprint.myPrint(cars, tableHad);
	}
	//根据类型
	private void lookByType() {
		System.out.println("请选择对应的类型的编号");
		int i = ChoiceTypeBrand.getType();
		String type = i+"";
		List<Car> cars = carDAOImpl.selectByType(type);
		Myprint.myPrint(cars, tableHad);
		
	}
	//根据品牌
	private void lookByBrand() {
		System.out.println("请选择对应的品牌的编号");
		int i = ChoiceTypeBrand.getBrand();
		String brand = i+"";
		List<Car> cars = carDAOImpl.selectByBrand(brand);
		Myprint.myPrint(cars,tableHad);

	}

	//查看所有
	public static void lookAll(){
		List<Car> cars = carDAOImpl.selects();
		Myprint.myPrint(cars,tableHad);
	}

}
