package com.hwua.view.user;

import java.util.Scanner;

import com.hwua.Logical_processing.uesr.Register;
import com.hwua.pojo.User;

public class RegisterView {

	//用户注册
	public static boolean regis() {
		
		Scanner scanner  = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = scanner.next();
		
		System.out.println("请输入密码：");
		String password = scanner.next();
		
		System.out.println("请输入手机号：");
		Long phone = scanner.nextLong();
		
		return Register.myRegister(name,password,phone);

	}

}
