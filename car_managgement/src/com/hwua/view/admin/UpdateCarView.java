package com.hwua.view.admin;

import java.util.Scanner;

import com.hwua.Logical_processing.admin.UpadteCar;

public class UpdateCarView {
	//1.����������
	//2.�����ļ۸�
	//3.�������ϼ����¼�

	public static void update() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������Ҫ�޸������ı��");
		long id = scanner.nextLong();
		
		System.out.println("������Ҫ���Ĳ������:");
		System.out.println("1.�޸�����������");
		System.out.println("2.�޸������ļ۸�");
		System.out.println("3.�޸����������¼�״̬");
		
		int i= scanner.nextInt();
		
		UpadteCar upadteCar = new UpadteCar(id);
		
		switch (i) {
		case 1:
			upadteCar.updateNum();
			break;
		case 2:
			upadteCar.updatePrice();
			break;
		case 3:
			upadteCar.updatePorper();
			break;

		default:
			System.err.println("�����������");
			break;
		}
		
		
	}
	
}
