package com.hwua.control;

import com.hwua.control.initSys.Userobj;
import com.hwua.view.admin.AShowCar;
import com.hwua.view.admin.AddCarView;
import com.hwua.view.admin.ChoiceAdmin;
import com.hwua.view.admin.ShowBorrwe;
import com.hwua.view.admin.ShowUser;
import com.hwua.view.admin.UpdateCarView;
import com.hwua.view.admin.deleteCarView;

public class flowAdmin {

	static Userobj userobj = Userobj.getUserobj();
	
	public static void main(String[] args) {

	}

	public static void flow(int i) {
		/**
		 * 	08	����Ա�鿴������Ϣ	ȫ��������ָ������
			09	����Ա�������	������ʾ���һ������
			10	����Ա�޸�������Ϣ	�޸����޼۸��Ƿ��ϼ�
			11	����Ա�鿴���޼�¼��Ϣ	�����û�id������id

		 */
		switch (i) {
		case 1:
			// ��ѯcar
			AShowCar.showCar();
			ChoiceAdmin.choice();
			break;

		case 2:
			//2:�鿴�Ѿ�����car
			ShowBorrwe.showbor();
			ChoiceAdmin.choice();
			break;
		case 3:
			//���car
			AddCarView.addCar();
			ChoiceAdmin.choice();
			break;
		case 4:
			// 4:ɾ��car
			deleteCarView.deleCar();
			ChoiceAdmin.choice();
			break;
		case 5:
			//5:�޸���������Ϣ
			UpdateCarView.update();
			ChoiceAdmin.choice();
			break;
		case 6:
			//5:��ѯ�û�����Ϣ
			ShowUser.showUser();
			ChoiceAdmin.choice();
			break;
		case 0:
			// �˳�
			System.out.println("�ټ���");
			userobj.setUser(null);
			System.exit(0);
			break;

		default:
			System.out.println("������Ĳ�������");
			break;
		}

	}

	private flowAdmin(int i) {
	}
}
