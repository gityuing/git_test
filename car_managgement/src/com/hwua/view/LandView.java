package com.hwua.view;

import java.util.Scanner;

import com.hwua.Logical_processing.Land;

public class LandView {
	//用户登陆
	public static boolean userLand() {
		Scanner scanner  = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = scanner.next();
		
		System.out.println("请输入密码：");
		String password = scanner.next();
		
		Land land = new Land();
		return land.userLongin(name,password);
		
	}

	public static boolean adminLand() {
		Scanner scanner  = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = scanner.next();
		
		System.out.println("请输入密码：");
		String password = scanner.next();
		Land land = new Land();
		return land.adminLongin(name,password);
	}

}
