package com.hwua.control;

import com.hwua.control.initSys.Userobj;
import com.hwua.view.user.BackView;
import com.hwua.view.user.BorrweView;
import com.hwua.view.user.ChoiceUser;
import com.hwua.view.user.LookBorrweBook;
import com.hwua.view.user.ShowCar;

public class flowUser {

	static Userobj userobj = Userobj.getUserobj();

	public static void flow(int i) {
		switch (i) {
		case 1:
			// ��ѯcar
			ShowCar.showCar();
			ChoiceUser.choice();
			break;

		case 2:
			//�賵
			BorrweView.borrweBook();
			ChoiceUser.choice();
			break;
		case 3:
			//����
			BackView.backCar();
			ChoiceUser.choice();
			break;
		case 4:
			// �鿴�����鼮
			LookBorrweBook.bb();
			ChoiceUser.choice();
			break;

		case 0:
			// �˳�
			System.out.println("лл����ʹ��~_~");
			userobj.setUser(null);
			System.exit(0);
			break;

		default:
			System.out.println("������Ĳ�����������������");
			ChoiceUser.choice();
			break;
		}

	}

	private flowUser(int i) {
	}
}
