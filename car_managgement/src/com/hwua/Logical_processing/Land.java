package com.hwua.Logical_processing;

import java.math.BigDecimal;
import java.util.Scanner;

import com.alibaba.druid.stat.TableStat.Name;
import com.hwua.control.initSys.Userobj;
import com.hwua.dao.impl.UserDAOImpl;
import com.hwua.pojo.User;
import com.hwua.util.template.Template;

/**
 * 登陆的操作
 * @author yuing
 *
 */
public class Land {

	public boolean userLongin(String name,String password) {
		//判断用户 输入的用户名是否正确
		String sqlString = "select count(*) from c_user where U_name = ?";
		BigDecimal i = (BigDecimal)Template.selectOne(sqlString, name);
		
		if(i.intValue()==0){
			System.out.println("你输入的用户名不存在 ");
			return false;
		}
		return longin(name, password);
	}
	
	
	public boolean adminLongin(String name, String password) {
		if(!(name.equals("admin"))){
			System.out.println("你输入的用户名不存在 ");
			return false;
		}
		return longin(name, password);
	}
	
	
	private boolean longin(String name,String password){
		Userobj userobj = Userobj.getUserobj();
		userobj.setUser(new User(name,password));
		
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		User user = userDAOImpl.select(userobj.getUser().getU_name());
		
		if(user!=null){

			if(user.getPassword().equals(userobj.getUser().getPassword())){
				userobj.setUser(user);
				System.out.println("登陆成功");
				System.out.println("--------------------------------------------------------------------"+userobj.getUser().getU_name()+"---");
				
				return true;

			}else {
				
				System.out.println("密码错误");
			}
		}else{
			System.out.println("你输入的用户名不存在");
			userobj.setUser(null);
		}
		
		return false;
		
		
	}

	

}