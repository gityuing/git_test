package com.hwua.view.user;

import java.util.Scanner;

import com.hwua.Logical_processing.uesr.BorrweCar;

public class BorrweView {

	public static void borrweBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������car��id");
		long id = sc.nextLong();
		System.out.println("��������������");
		int num = sc.nextInt();
		BorrweCar bb = new BorrweCar();
		bb.borrweBook(id,num);
	}
	

}
