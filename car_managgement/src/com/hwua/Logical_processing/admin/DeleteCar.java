package com.hwua.Logical_processing.admin;

import java.math.BigDecimal;

import com.hwua.dao.impl.CarDAOImpl;

public class DeleteCar {
	//ɾ�� car��Ϣ
	public void deleteCar(long id){
		//�ж������id �Ƿ����
		CarDAOImpl carDAOImpl = new CarDAOImpl();
		boolean fl = carDAOImpl.idExistent(new BigDecimal(id));
		
		if(!fl){
			System.out.println("�������car��Ų���ȷ");
			return;
		}
		
		//�ж� �������� �Ƿ� �д����� ���� 
		fl = carDAOImpl.borrweIsnull(new BigDecimal(id));
		if(!fl){
			System.out.println("��������  �д����� ���� ������ɾ��");
			return;
		}
		
		int i = carDAOImpl.delete(new BigDecimal(id));
		if(i==1){
			System.out.println("ɾ���ɹ���");
		}else{
			System.out.println("ɾ��ʧ�ܣ�");
		}
	}
}
