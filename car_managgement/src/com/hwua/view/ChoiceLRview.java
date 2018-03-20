package com.hwua.view;

import java.util.Scanner;

import com.hwua.control.flowLR;

public class ChoiceLRview {
	public static void choice(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("====================================");
		System.out.print("1:µÇÂ½\t\t");
		System.out.print("2:×¢²á\t\t");
		System.out.println("0:ÍË³ö");
		System.out.println("====================================");
		int i = scanner.nextInt();
		flowLR.flowAdmin(i);
	}
}
