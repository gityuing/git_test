package com.hwua.view.admin;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.hwua.Logical_processing.admin.AddCar;
import com.hwua.control.initSys.TBObj;
import com.hwua.util.template.Template;
import com.hwua.view.ChoiceTypeBrand;

public class AddCarView {
	private static Scanner scanner = new Scanner(System.in);

	public static void addCar() {
		System.out.println("������car������");
		String c_name = scanner.next();

		System.out.println("������car�ı�ע");
		String c_remarks = scanner.next();

		System.out.println("������car��Ʒ�Ʊ��");
		int c_brand = ChoiceTypeBrand.getBrand();

		System.out.println("������car�����ͱ��");
		int c_type = ChoiceTypeBrand.getType();

		System.out.println("������car/��ļ۸�");
		double price = scanner.nextDouble();

		System.out.println("������car������");
		int number = scanner.nextInt();

		System.out.println("ѡ���Ƿ��ϼ� y/n ");
		String porper = scanner.next();

		AddCar addCar = new AddCar();
		addCar.addCar(c_name, c_remarks, new BigDecimal(c_brand), new BigDecimal(c_type),
				new BigDecimal(price), new BigDecimal(number), porper);
	}

}
