package com.hwua.view.user;

import java.util.Scanner;

import com.hwua.control.flowUser;

public class ChoiceUser {
	public static void choice(){
		
		System.out.println("============================================"
				+ "================================================");
		System.out.print("1:��ѯcar\t\t");
		System.out.print("2:��car\t\t");
		System.out.print("3:��car\t\t");
		System.out.print("4:�鿴�Ѿ�����car\t\t");
		System.out.println("0:�˳�");
		
		System.out.println("============================================="
				+ "===============================================");
		System.out.println("��������Ҫ���еĲ���");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		flowUser.flow(i);
	}
}
