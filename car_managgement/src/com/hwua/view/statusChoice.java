package com.hwua.view;

import java.util.Scanner;

public class statusChoice {
	public static int admin() {
		System.out.print("1:以管理员身份登陆\t\t");
		System.out.println("2:以普通用户身份登陆");
		
		Scanner scanner = new Scanner(System.in);
		int j = scanner.nextInt();
		if (!(j == 1 || j == 2)) {
			
			System.out.println("你输入有误！");
			admin();
		} 
		
		return j;
	}
	
}
