package com.hwua.view.user;

import java.util.Scanner;

import com.hwua.Logical_processing.uesr.LookCar;

public class ShowCar {
	// 查看图书信息
	public static void showCar() {
		System.out.println("1:查看所有上架的车辆");
		System.out.println("2:根据品牌查看上架的车辆");
		System.out.println("3:根据类型查看上架的车辆");
		System.out.println("4:根据汽车编号升序查看的车辆");
		System.out.println("5:根据汽车编号降序查看上架的车辆");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		LookCar lc = new LookCar();
		lc.lookCar(i);
	}

	
}
