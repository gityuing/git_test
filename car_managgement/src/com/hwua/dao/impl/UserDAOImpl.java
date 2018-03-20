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
 * �� �û�ע��ʱ���user
 * ���û������뻹��ʱ ����book ��id ��Ϣ
 * ���û�ע��ʱ ����Ҫ�ж� �Ƿ� �н���� δ��    ���û�� �� delete ���û�
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
	
	//��ѯһ��user����
	@Override
	public User select(BigDecimal i) {
		String sql = "select * from c_user where u_id = ?";
		User user = Template.DQLTemplate(sql, User.class, i);
		return user;
	}
	
	//��ѯһ��user����
		public User select(String name) {
			String sql = "select * from c_user where u_name = ?";
			User user = Template.DQLTemplate(sql, User.class, name);
			return user;
		}
	
	
	//�ж��û����Ƿ����
	public static boolean isName(String userName){
		String sql = "select count(u_name) from c_user where u_name = \'"+userName+"\'";
		BigDecimal a = (BigDecimal)Template.selectOne(sql);
		int i = a.intValue();
		if(i==0){
			return false;
		}
		return true;
	}

	
	//��ѯ�û�������
	public static String isPass(String userName){
		String sql = "select password from c_user where u_name = \'"+userName+"\'";
		System.out.println(sql);
		String password = (String)Template.selectOne(sql);
		return password;
	}

	
}