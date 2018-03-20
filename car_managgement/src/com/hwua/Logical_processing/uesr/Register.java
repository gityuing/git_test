package com.hwua.Logical_processing.uesr;

import java.math.BigDecimal;

import com.hwua.control.initSys.Userobj;
import com.hwua.dao.impl.UserDAOImpl;
import com.hwua.pojo.User;
import com.hwua.util.template.Template;
/**
 * ʵ��ע��Ĺ���
 * @author yuing
 *
 */
public class Register {
	public static boolean myRegister(String name,String password,Long phone){
		//�ж��û����Ƿ��Ѵ���
		String sqlString = "select count(*) from C_user where U_name = ?";
		BigDecimal j = (BigDecimal)Template.selectOne(sqlString, name.toUpperCase());
		
		if(j.intValue()!=0){
			System.out.println("��������û����Ѵ��� ");
			return false;
		}
		
		Userobj userobj = Userobj.getUserobj();
		boolean fl = UserDAOImpl.isName(name);
		if(!fl){
			User user = new User(name, password, new BigDecimal(phone));
			int i = new UserDAOImpl().add(user);
			if(i==1){
				System.out.println("�û������ɹ�");
				userobj.setUser(user);
				return true;
			}else{
				System.out.println("�û�ʧ�ܣ�������");
		
			}
		}else{
			userobj.setUser(null);
			System.out.println("��������û��������ã�");
		}
		return false;
		
		
	
	}

}
