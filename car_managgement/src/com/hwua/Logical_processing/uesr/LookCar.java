package com.hwua.Logical_processing.uesr;

import java.util.List;
import java.util.Scanner;

import com.hwua.dao.impl.CarDAOImpl;
import com.hwua.pojo.Car;
import com.hwua.view.ChoiceTypeBrand;
import com.hwua.view.Myprint;
//��ͨ�û��鿴����
public class LookCar {
	static final String tableHad = "|�������\t\t|"+"��������\t\t|"+"��ע\t\t|"+"Ʒ��\t\t|"+"����\t\t\t|"+"�۸�\t\t\t|"+"ʣ����\t\t|"+"�Ƿ����";
	
	private static CarDAOImpl carDAOImpl = new CarDAOImpl();
	Scanner scanner = new Scanner(System.in);
	
	
	public void lookCar(int i){
		switch (i) {
		case 1:
			lookAll();
			break;
		case 2:
			//Ʒ��
			lookByBrand();
			break;
		case 3:
			//����
			
			lookByType();
			break;
		case 4:
			//id ����
			lookByIdLower();
			break;
		case 5:
			//id ����
			lookByIdUpper();
			
			break;
			
		default:
			System.out.println("����������");
			break;
		}
		
	}
	
	//id����
	private void lookByIdLower() {
		List<Car> cars = carDAOImpl.selectByIdLower();
		Myprint.myPrint(cars, tableHad);
	}

	//id����
	private void lookByIdUpper() {
		List<Car> cars = carDAOImpl.selectByIdUpper();
		Myprint.myPrint(cars, tableHad);
	}
	//��������
	private void lookByType() {
		System.out.println("��ѡ���Ӧ�����͵ı��");
		int i = ChoiceTypeBrand.getType();
		String type = i+"";
		List<Car> cars = carDAOImpl.selectByType(type);
		Myprint.myPrint(cars, tableHad);
		
	}
	//����Ʒ��
	private void lookByBrand() {
		System.out.println("��ѡ���Ӧ��Ʒ�Ƶı��");
		int i = ChoiceTypeBrand.getBrand();
		String brand = i+"";
		List<Car> cars = carDAOImpl.selectByBrand(brand);
		Myprint.myPrint(cars,tableHad);

	}

	//�鿴����
	public static void lookAll(){
		List<Car> cars = carDAOImpl.selects();
		Myprint.myPrint(cars,tableHad);
	}

}
