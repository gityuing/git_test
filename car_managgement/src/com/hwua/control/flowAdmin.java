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
		 * 	08	管理员查看汽车信息	全部汽车或指定汽车
			09	管理员添加汽车	根据提示添加一辆汽车
			10	管理员修改汽车信息	修改租赁价格、是否上架
			11	管理员查看租赁记录信息	根据用户id或汽车id

		 */
		switch (i) {
		case 1:
			// 查询car
			AShowCar.showCar();
			ChoiceAdmin.choice();
			break;

		case 2:
			//2:查看已经租借的car
			ShowBorrwe.showbor();
			ChoiceAdmin.choice();
			break;
		case 3:
			//添加car
			AddCarView.addCar();
			ChoiceAdmin.choice();
			break;
		case 4:
			// 4:删除car
			deleteCarView.deleCar();
			ChoiceAdmin.choice();
			break;
		case 5:
			//5:修改汽车的信息
			UpdateCarView.update();
			ChoiceAdmin.choice();
			break;
		case 6:
			//5:查询用户的信息
			ShowUser.showUser();
			ChoiceAdmin.choice();
			break;
		case 0:
			// 退出
			System.out.println("再见！");
			userobj.setUser(null);
			System.exit(0);
			break;

		default:
			System.out.println("你输入的操作有误！");
			break;
		}

	}

	private flowAdmin(int i) {
	}
}
