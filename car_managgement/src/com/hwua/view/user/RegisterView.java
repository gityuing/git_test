package com.hwua.view.user;

import java.util.Scanner;

import com.hwua.Logical_processing.uesr.Register;
import com.hwua.pojo.User;

public class RegisterView {

	//�û�ע��
	public static boolean regis() {
		
		Scanner scanner  = new Scanner(System.in);
		System.out.println("�������û�����");
		String name = scanner.next();
		
		System.out.println("���������룺");
		String password = scanner.next();
		
		System.out.println("�������ֻ��ţ�");
		Long phone = scanner.nextLong();
		
		return Register.myRegister(name,password,phone);

	}

}
