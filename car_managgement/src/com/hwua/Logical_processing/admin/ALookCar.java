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
	private static String tablehad = "|汽车编号\t|" + "汽车名称\t|" + "备注\t\t|"
			+ "品牌\t\t|" + "类型\t\t\t|" + "租借量\t\t|" + "总量\t\t|" + "价格\t\t|"
			+ "是否可租";
	// 管理员 查看 car信息 显示 car 的详情信息
	// 可以查看指定的汽车
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
			// 类型
			lookByType();
			break;
		case 5:
			// 品牌
			lookByBrand();
			break;

		default:
			System.out.println("你的输入错误");
			break;
		}

	}

	//根据汽车的品牌查询汽车
	private void lookByBrand() {
		int i = ChoiceTypeBrand.getBrand();
		String type = i + "";
		String sql = "select * from car where c_type like '%" + type + "%'";
		List<Car> cars = Template.DQLsTemplate(sql, Car.class);
		System.out.println(xhx);
		System.out.println(tablehad);
		for (Car car : cars) {
			if (car == null) {
				System.err.println("这里是空的");
			} else {
				System.out.println(car.toStr());
			}
		}
		System.out.println(xhx);

	}

	//根据汽车的类型查询汽车
	private void lookByType() {
		
		int i = ChoiceTypeBrand.getType();
		String type = i + "";
		String sql = "select * from car where c_type like '%" + type + "%'";
		List<Car> cars = Template.DQLsTemplate(sql, Car.class);
		System.out.println(xhx);
		System.out.println(tablehad);
		for (Car car : cars) {
			if (car == null) {
				System.err.println("这里是空的");
			} else {
				System.out.println(car.toStr());
			}
		}
		System.out.println(xhx);
	}

	//查看所有汽车
	public static void lookAll() {
		List<Car> cars = carDAOImpl.Aselects();
		System.out.println(xhx);
		System.out.println(tablehad);
		for (Car car : cars) {
			System.out.println(car.toStr());
		}
		System.out.println(xhx);

	}

	//根据id查询汽车
	private static void lookById() {
		System.out.println("请输入要查询汽车的id");
		long id = scanner.nextLong();
		Car car = carDAOImpl.select(new BigDecimal(id));
		if (car == null) {
			System.out.println("你输入的汽车的编号不存在");
			return;
		}
		System.out.println(xhx);
		System.out.println(tablehad);
		System.out.println(car.toStr());
		System.out.println(xhx);

	}

	//根据汽车的名字查询汽车
	private static void lookByName() {
		System.out.println("请输入要查询汽车的名字");
		String name = scanner.next();
		Car car = carDAOImpl.select(name);
		if (car == null) {
			System.out.println("你输入的汽车的名字不存在");
			return;
		}
		System.out.println(xhx);
		System.out.println(tablehad);
		System.out.println(car.toStr());
		System.out.println(xhx);
	}

}
