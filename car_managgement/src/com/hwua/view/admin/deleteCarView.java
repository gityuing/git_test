package com.hwua.view.admin;

import java.util.Scanner;

import com.hwua.Logical_processing.admin.DeleteCar;

public class deleteCarView {
	public static void deleCar(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("������Ҫɾ�� car �ı��");
		long id = scanner.nextLong();
		DeleteCar dele = new DeleteCar();
		dele.deleteCar(id);
		
	}

}
