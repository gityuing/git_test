package com.hwua.view.user;

import java.util.Scanner;

import com.hwua.Logical_processing.uesr.LookCar;

public class ShowCar {
	// �鿴ͼ����Ϣ
	public static void showCar() {
		System.out.println("1:�鿴�����ϼܵĳ���");
		System.out.println("2:����Ʒ�Ʋ鿴�ϼܵĳ���");
		System.out.println("3:�������Ͳ鿴�ϼܵĳ���");
		System.out.println("4:���������������鿴�ĳ���");
		System.out.println("5:����������Ž���鿴�ϼܵĳ���");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		LookCar lc = new LookCar();
		lc.lookCar(i);
	}

	
}
