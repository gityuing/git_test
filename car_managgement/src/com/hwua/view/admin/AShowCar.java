package com.hwua.view.admin;

import java.util.Scanner;

import com.hwua.Logical_processing.admin.ALookCar;

public class AShowCar {
	// ����Ա �鿴 car��Ϣ ��ʾ car ��������Ϣ
	// ���Բ鿴ָ��������

	public static void showCar() {
		System.out.println("1����ѯ������������Ϣ");
		System.out.println("2������id ��ѯ����");
		System.out.println("3���������Ʋ�ѯ ����");
		System.out.println("4���������Ͳ�ѯ ����");
		System.out.println("5������Ʒ�Ʋ�ѯ ����");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		ALookCar lookCar = new ALookCar();
		lookCar.lookCar(i);
	}
}
