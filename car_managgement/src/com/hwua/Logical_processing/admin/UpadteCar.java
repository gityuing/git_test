package com.hwua.Logical_processing.admin;

import java.math.BigDecimal;
import java.util.Scanner;

import com.hwua.dao.impl.CarDAOImpl;

public class UpadteCar {
	private static CarDAOImpl carDAOImpl = new CarDAOImpl();
	private static Scanner Scanner = new Scanner(System.in);
	
	private static BigDecimal id ;
	public UpadteCar(long id){
		this.id = new BigDecimal(id);
	}
	
	public  void updateNum() {
		if(!isId()){
			System.err.println("����ı�Ų�����");
			return;
		}
		
		System.out.println("������Ҫ���µ�����ֵ��");
		int num = Scanner.nextInt();
		
		//�ж�����������Ƿ�С�ڵ�ǰ�������
		
		
		BigDecimal Borrwenum = carDAOImpl.getBorrwenum(id);
		if(num < Borrwenum.intValue()){
			System.out.println("����������� ���� ��ǰ�������  �� �������ʧ");
			return;
		}
		
		int i = carDAOImpl.upDateNum(new BigDecimal(num), id);
		
		Success(i);
		
		
		
	}



	public  void updatePrice() {
		if(!isId()){
			System.err.println("����ı�Ų�����");
			return;
		}
		
		System.out.println("������۸�");
		double price = Scanner.nextDouble();
		
		int i = carDAOImpl.upDatePrice(new BigDecimal(price), id);
		
		Success(i);
	}

	public  void updatePorper() {
		if(!isId()){
			System.err.println("����ı�Ų�����");
			return;
		}
		
		System.out.println("1:�ϼ�");
		System.out.println("2:�¼�");
		int j = Scanner.nextInt();
		int i=0;
		switch (j) {
		case 1:
			i = carDAOImpl.uppPor(id);
			Success(i);
			break;
		case 2:
			i = carDAOImpl.lowPor(id);
			Success(i);
			break;

		default:
			System.out.println("��������");
			break;
		}
		
	}
	//�жϽ��
	private static void Success(int i) {
		if(i==1){
			System.out.println("�޸ĳɹ�");
		}else{
			System.out.println("�޸�ʧ��");
		}
		
	}
	//�ж�  car id �Ƿ�����
		private static boolean isId(){
			return  carDAOImpl.idExistent(id);
		}

}
