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
			// 查询car
			ShowCar.showCar();
			ChoiceUser.choice();
			break;

		case 2:
			//借车
			BorrweView.borrweBook();
			ChoiceUser.choice();
			break;
		case 3:
			//还车
			BackView.backCar();
			ChoiceUser.choice();
			break;
		case 4:
			// 查看借阅书籍
			LookBorrweBook.bb();
			ChoiceUser.choice();
			break;

		case 0:
			// 退出
			System.out.println("谢谢您的使用~_~");
			userobj.setUser(null);
			System.exit(0);
			break;

		default:
			System.out.println("你输入的操作有误！请重新输入");
			ChoiceUser.choice();
			break;
		}

	}

	private flowUser(int i) {
	}
}
