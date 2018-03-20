package com.hwua.view.admin;

import java.util.Scanner;

import com.hwua.Logical_processing.admin.LookBorrwe;

public class ShowBorrwe {
	public static void showbor(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("1:查看所有未还的记录");
		System.out.println("2:根据car的编号查看记录");
		System.out.println("3:根据user的编号查看记录");
		System.out.println("4:查看所有记录");
		
		int i = scanner.nextInt();
		LookBorrwe.lookb_b(i);
		
	}
}
