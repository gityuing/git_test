package com.hwua.view.user;

import java.math.BigDecimal;
import java.util.Scanner;

import com.hwua.Logical_processing.uesr.BackCar;
import com.hwua.Logical_processing.uesr.LookBorweCar;

public class BackView {

	public static void backCar() {
		LookBorweCar.lookb_b();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("������Ҫ��car������ţ�");
		long caarId = scanner.nextLong();
		
		BackCar bb = new BackCar();
		bb.backBook( caarId);
	}

}
