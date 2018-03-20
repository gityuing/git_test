package com.hwua.view.user;

import java.util.Scanner;

import com.hwua.control.flowUser;

public class ChoiceUser {
	public static void choice(){
		
		System.out.println("============================================"
				+ "================================================");
		System.out.print("1:查询car\t\t");
		System.out.print("2:借car\t\t");
		System.out.print("3:还car\t\t");
		System.out.print("4:查看已经租借的car\t\t");
		System.out.println("0:退出");
		
		System.out.println("============================================="
				+ "===============================================");
		System.out.println("请输入你要进行的操作");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		flowUser.flow(i);
	}
}
