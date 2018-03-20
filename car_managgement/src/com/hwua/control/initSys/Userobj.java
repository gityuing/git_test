package com.hwua.control.initSys;

import com.hwua.pojo.User;

public class Userobj {
	private static Userobj userobj = null;
	
	private static User user = null;
	
	private Userobj() {}
	
	public static Userobj getUserobj() {	
		if(userobj ==null){
			userobj = new Userobj();
		}
		return userobj;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		Userobj.user = user;
	}
}
