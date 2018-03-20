package com.hwua.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import com.hwua.dao.CarManagementDAO;
import com.hwua.pojo.User;
import com.hwua.util.template.Template;
/**
 * b_user   
 * U_ID                                      NOT NULL NUMBER
 * U_NAME                                    NOT NULL VARCHAR2(20)
 * ID1                                                NUMBER
 * ID2                                                NUMBER
 * ID3
 * 当 用户注册时添加user
 * 当用户借书与还书时 更新book 的id 信息
 * 当用户注销时 首先要判断 是否 有借的书 未还    如果没有 则 delete 该用户
 * @author yuing
 *
 */
public class UserDAOImpl implements CarManagementDAO<User>{

	@Override
	public int add(User user) {
		String sql = "insert into c_user values(sys_bookId.nextval,?,?,?)";
		return Template.DMLTemplate(sql, user.getU_name(),user.getPhone(),user.getPassword());
	}
	public static void main(String[] args) {
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		userDAOImpl.add(new User("yuing", "1234"));
	}

	@Override
	public int delete(BigDecimal i) {
		String sql = "delete c_user where U_id = ?";
		return Template.DMLTemplate(sql, i);
	}

	@Override
	public int upDate(User user, BigDecimal i) {
		String sql = "update c_user set password = ? where u_id = ?";
		return Template.DMLTemplate(sql, user.getPassword(),i);
	}

	@Override
	public List<User> selects() {
		String sql = "select * from c_user";
		List<User> list = Template.DQLsTemplate(sql, User.class);
		return list;
	}
	
	//查询一个user对象
	@Override
	public User select(BigDecimal i) {
		String sql = "select * from c_user where u_id = ?";
		User user = Template.DQLTemplate(sql, User.class, i);
		return user;
	}
	
	//查询一个user对象
		public User select(String name) {
			String sql = "select * from c_user where u_name = ?";
			User user = Template.DQLTemplate(sql, User.class, name);
			return user;
		}
	
	
	//判断用户名是否存在
	public static boolean isName(String userName){
		String sql = "select count(u_name) from c_user where u_name = \'"+userName+"\'";
		BigDecimal a = (BigDecimal)Template.selectOne(sql);
		int i = a.intValue();
		if(i==0){
			return false;
		}
		return true;
	}

	
	//查询用户的密码
	public static String isPass(String userName){
		String sql = "select password from c_user where u_name = \'"+userName+"\'";
		System.out.println(sql);
		String password = (String)Template.selectOne(sql);
		return password;
	}

	
}