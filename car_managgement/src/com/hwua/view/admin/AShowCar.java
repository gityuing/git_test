package com.hwua.view.admin;

import java.util.Scanner;

import com.hwua.Logical_processing.admin.ALookCar;

public class AShowCar {
	// 管理员 查看 car信息 显示 car 的详情信息
	// 可以查看指定的汽车

	public static void showCar() {
		System.out.println("1：查询所有汽车的信息");
		System.out.println("2：根据id 查询汽车");
		System.out.println("3：根据名称查询 汽车");
		System.out.println("4：根据类型查询 汽车");
		System.out.println("5：根据品牌查询 汽车");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		ALookCar lookCar = new ALookCar();
		lookCar.lookCar(i);
	}
}
