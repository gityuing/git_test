package com.hwua.Logical_processing.admin;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.hwua.dao.impl.CarDAOImpl;
import com.hwua.pojo.Car;
import com.hwua.util.template.Template;
import com.hwua.view.ChoiceTypeBrand;

public class ALookCar {
	private static String xhx = "__________________________________________________________________________________________________________________________";
	private static String tablehad = "|�������\t|" + "��������\t|" + "��ע\t\t|"
			+ "Ʒ��\t\t|" + "����\t\t\t|" + "�����\t\t|" + "����\t\t|" + "�۸�\t\t|"
			+ "�Ƿ����";
	// ����Ա �鿴 car��Ϣ ��ʾ car ��������Ϣ
	// ���Բ鿴ָ��������
	private static Scanner scanner = new Scanner(System.in);
	private static CarDAOImpl carDAOImpl = new CarDAOImpl();

	public void lookCar(int i) {
		switch (i) {
		case 1:
			lookAll();
			break;
		case 2:
			lookById();
			break;
		case 3:
			lookByName();
			break;
		case 4:
			// ����
			lookByType();
			break;
		case 5:
			// Ʒ��
			lookByBrand();
			break;

		default:
			System.out.println("����������");
			break;
		}

	}

	//����������Ʒ�Ʋ�ѯ����
	private void lookByBrand() {
		int i = ChoiceTypeBrand.getBrand();
		String type = i + "";
		String sql = "select * from car where c_type like '%" + type + "%'";
		List<Car> cars = Template.DQLsTemplate(sql, Car.class);
		System.out.println(xhx);
		System.out.println(tablehad);
		for (Car car : cars) {
			if (car == null) {
				System.err.println("�����ǿյ�");
			} else {
				System.out.println(car.toStr());
			}
		}
		System.out.println(xhx);

	}

	//�������������Ͳ�ѯ����
	private void lookByType() {
		
		int i = ChoiceTypeBrand.getType();
		String type = i + "";
		String sql = "select * from car where c_type like '%" + type + "%'";
		List<Car> cars = Template.DQLsTemplate(sql, Car.class);
		System.out.println(xhx);
		System.out.println(tablehad);
		for (Car car : cars) {
			if (car == null) {
				System.err.println("�����ǿյ�");
			} else {
				System.out.println(car.toStr());
			}
		}
		System.out.println(xhx);
	}

	//�鿴��������
	public static void lookAll() {
		List<Car> cars = carDAOImpl.Aselects();
		System.out.println(xhx);
		System.out.println(tablehad);
		for (Car car : cars) {
			System.out.println(car.toStr());
		}
		System.out.println(xhx);

	}

	//����id��ѯ����
	private static void lookById() {
		System.out.println("������Ҫ��ѯ������id");
		long id = scanner.nextLong();
		Car car = carDAOImpl.select(new BigDecimal(id));
		if (car == null) {
			System.out.println("������������ı�Ų�����");
			return;
		}
		System.out.println(xhx);
		System.out.println(tablehad);
		System.out.println(car.toStr());
		System.out.println(xhx);

	}

	//�������������ֲ�ѯ����
	private static void lookByName() {
		System.out.println("������Ҫ��ѯ����������");
		String name = scanner.next();
		Car car = carDAOImpl.select(name);
		if (car == null) {
			System.out.println("����������������ֲ�����");
			return;
		}
		System.out.println(xhx);
		System.out.println(tablehad);
		System.out.println(car.toStr());
		System.out.println(xhx);
	}

}
