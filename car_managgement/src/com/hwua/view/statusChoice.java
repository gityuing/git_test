package com.hwua.view;

import java.util.Scanner;

public class statusChoice {
	public static int admin() {
		System.out.print("1:�Թ���Ա��ݵ�½\t\t");
		System.out.println("2:����ͨ�û���ݵ�½");
		
		Scanner scanner = new Scanner(System.in);
		int j = scanner.nextInt();
		if (!(j == 1 || j == 2)) {
			
			System.out.println("����������");
			admin();
		} 
		
		return j;
	}
	
}
