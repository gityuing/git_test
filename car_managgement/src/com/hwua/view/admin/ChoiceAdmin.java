package com.hwua.view.admin;

import java.util.Scanner;

import com.hwua.control.flowAdmin;

public class ChoiceAdmin {
	public static void choice() {

		System.out.println("===============================================================================================================");
		System.out.print("1:��ѯcar\t\t");
		//�鿴������������    c_id		c_name		c_borrwe		ʣ����
		System.out.print("2:�鿴����car\t\t");
		System.out.print("3:���car\t\t");
		System.out.print("4:ɾ��car\t\t");
		System.out.print("5:�޸�car��Ϣ\t\t");
		System.out.print("6:��ѯ�û�����Ϣ\t\t");
		System.out.println("0:�˳�");
		System.out.println("===============================================================================================================");
		System.out.println("��������Ҫ���еĲ���");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		flowAdmin.flow(i);
	}
}
