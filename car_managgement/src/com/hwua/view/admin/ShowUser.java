package com.hwua.view.admin;

import java.util.List;

import com.hwua.dao.impl.UserDAOImpl;
import com.hwua.pojo.User;

public class ShowUser {

	public static void showUser() {
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		List<User> users = userDAOImpl.selects();
		System.out.println("__________________________________________");
		System.out.println("id\t\tname\t\tphone");
		for (User user : users) {
			System.out.println(user.toString());
		}
		System.out.println("-------------------------------------------");
		
	}

}
