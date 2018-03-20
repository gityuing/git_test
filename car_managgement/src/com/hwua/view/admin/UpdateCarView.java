package com.hwua.view.admin;

import java.util.Scanner;

import com.hwua.Logical_processing.admin.UpadteCar;

public class UpdateCarView {
	//1.汽车的总量
	//2.汽车的价格
	//3.汽车的上架于下架

	public static void update() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要修改汽车的编号");
		long id = scanner.nextLong();
		
		System.out.println("请输入要做的操作编号:");
		System.out.println("1.修改汽车的总量");
		System.out.println("2.修改汽车的价格");
		System.out.println("3.修改汽车的上下架状态");
		
		int i= scanner.nextInt();
		
		UpadteCar upadteCar = new UpadteCar(id);
		
		switch (i) {
		case 1:
			upadteCar.updateNum();
			break;
		case 2:
			upadteCar.updatePrice();
			break;
		case 3:
			upadteCar.updatePorper();
			break;

		default:
			System.err.println("你输入的有误");
			break;
		}
		
		
	}
	
}
