package com.hwua.Logical_processing.admin;

import java.math.BigDecimal;
import java.util.Scanner;

import com.hwua.dao.impl.CarDAOImpl;

public class UpadteCar {
	private static CarDAOImpl carDAOImpl = new CarDAOImpl();
	private static Scanner Scanner = new Scanner(System.in);
	
	private static BigDecimal id ;
	public UpadteCar(long id){
		this.id = new BigDecimal(id);
	}
	
	public  void updateNum() {
		if(!isId()){
			System.err.println("输入的编号不存在");
			return;
		}
		
		System.out.println("请输入要更新的数量值：");
		int num = Scanner.nextInt();
		
		//判断输入的数量是否小于当前的租借量
		
		
		BigDecimal Borrwenum = carDAOImpl.getBorrwenum(id);
		if(num < Borrwenum.intValue()){
			System.out.println("你输入的数量 低于 当前的租借量  ， 会造成损失");
			return;
		}
		
		int i = carDAOImpl.upDateNum(new BigDecimal(num), id);
		
		Success(i);
		
		
		
	}



	public  void updatePrice() {
		if(!isId()){
			System.err.println("输入的编号不存在");
			return;
		}
		
		System.out.println("请输入价格：");
		double price = Scanner.nextDouble();
		
		int i = carDAOImpl.upDatePrice(new BigDecimal(price), id);
		
		Success(i);
	}

	public  void updatePorper() {
		if(!isId()){
			System.err.println("输入的编号不存在");
			return;
		}
		
		System.out.println("1:上架");
		System.out.println("2:下架");
		int j = Scanner.nextInt();
		int i=0;
		switch (j) {
		case 1:
			i = carDAOImpl.uppPor(id);
			Success(i);
			break;
		case 2:
			i = carDAOImpl.lowPor(id);
			Success(i);
			break;

		default:
			System.out.println("输入有误");
			break;
		}
		
	}
	//判断结果
	private static void Success(int i) {
		if(i==1){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
		
	}
	//判断  car id 是否存存在
		private static boolean isId(){
			return  carDAOImpl.idExistent(id);
		}

}
