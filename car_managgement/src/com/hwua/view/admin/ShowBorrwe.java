package com.hwua.view.admin;

import java.util.Scanner;

import com.hwua.Logical_processing.admin.LookBorrwe;

public class ShowBorrwe {
	public static void showbor(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("1:�鿴����δ���ļ�¼");
		System.out.println("2:����car�ı�Ų鿴��¼");
		System.out.println("3:����user�ı�Ų鿴��¼");
		System.out.println("4:�鿴���м�¼");
		
		int i = scanner.nextInt();
		LookBorrwe.lookb_b(i);
		
	}
}
