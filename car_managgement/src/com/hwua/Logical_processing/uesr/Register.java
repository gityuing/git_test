package com.hwua.Logical_processing.uesr;

import java.math.BigDecimal;

import com.hwua.control.initSys.Userobj;
import com.hwua.dao.impl.UserDAOImpl;
import com.hwua.pojo.User;
import com.hwua.util.template.Template;
/**
 * 实现注册的功能
 * @author yuing
 *
 */
public class Register {
	public static boolean myRegister(String name,String password,Long phone){
		//判断用户名是否已存在
		String sqlString = "select count(*) from C_user where U_name = ?";
		BigDecimal j = (BigDecimal)Template.selectOne(sqlString, name.toUpperCase());
		
		if(j.intValue()!=0){
			System.out.println("你输入的用户名已存在 ");
			return false;
		}
		
		Userobj userobj = Userobj.getUserobj();
		boolean fl = UserDAOImpl.isName(name);
		if(!fl){
			User user = new User(name, password, new BigDecimal(phone));
			int i = new UserDAOImpl().add(user);
			if(i==1){
				System.out.println("用户创建成功");
				userobj.setUser(user);
				return true;
			}else{
				System.out.println("用户失败，请重试");
		
			}
		}else{
			userobj.setUser(null);
			System.out.println("你输入的用户名不可用，");
		}
		return false;
		
		
	
	}

}
