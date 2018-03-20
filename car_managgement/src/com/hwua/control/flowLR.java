package com.hwua.control;

import com.hwua.Logical_processing.admin.ALookCar;
import com.hwua.Logical_processing.uesr.LookCar;
import com.hwua.control.initSys.Userobj;
import com.hwua.view.ChoiceLRview;
import com.hwua.view.LandView;
import com.hwua.view.statusChoice;
import com.hwua.view.admin.ChoiceAdmin;
import com.hwua.view.user.ChoiceUser;
import com.hwua.view.user.RegisterView;

public class flowLR {

	static Userobj userobj = Userobj.getUserobj();
	

	public static void flowAdmin(int i) {
		switch (i) {
		case 0:
			System.exit(0);
			break;
		case 1:
			// 登陆
			//初始化
			if (userobj.getUser() != null) {
				userobj.setUser(null);
			}

			//判断是否管理员
			int j = statusChoice.admin();
			
			if(j==1){
				if(LandView.adminLand()){
					ALookCar.lookAll();
					ChoiceAdmin.choice();
				}else{
					ChoiceLRview.choice();
				}
			}else if(j==2){
				if(LandView.userLand()){
					LookCar.lookAll();
					ChoiceUser.choice();
				}else{
					ChoiceLRview.choice();
				}
			}

			break;
		case 2:
			// 注册
			if(RegisterView.regis()){
				ChoiceUser.choice();

			}else {
				ChoiceLRview.choice();
			}
			break;
		default:
			System.out.println("你输入的操作有误！");
			break;
		}

	}

	private flowLR(int i) {}

}
