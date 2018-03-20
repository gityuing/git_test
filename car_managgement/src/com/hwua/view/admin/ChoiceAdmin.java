package com.hwua.view.admin;

import java.util.Scanner;

import com.hwua.control.flowAdmin;

public class ChoiceAdmin {
	public static void choice() {

		System.out.println("===============================================================================================================");
		System.out.print("1:查询car\t\t");
		//查看汽车的租借情况    c_id		c_name		c_borrwe		剩余量
		System.out.print("2:查看租借的car\t\t");
		System.out.print("3:添加car\t\t");
		System.out.print("4:删除car\t\t");
		System.out.print("5:修改car信息\t\t");
		System.out.print("6:查询用户的信息\t\t");
		System.out.println("0:退出");
		System.out.println("===============================================================================================================");
		System.out.println("请输入你要进行的操作");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		flowAdmin.flow(i);
	}
}
