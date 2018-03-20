package com.hwua.pojo;

import java.math.BigDecimal;


public class User {
	private BigDecimal u_id;
	private String  u_name;
	private String password;
	private BigDecimal phone;
	
	@Override
	public String toString() {
		return "|"+u_id+
				"\t\t|"+u_name+
				"\t\t|"+phone;
	}

	public User() {}
	
	public User(String u_name,String password){
		this.u_name = u_name;
		this.password = password;
	}
	public User(String u_name,String password,BigDecimal phone){
		this.u_name = u_name;
		this.password = password;
		this.phone = phone;
	}
	
	

	public BigDecimal getPhone() {
		return phone;
	}

	public void setPhone(BigDecimal phone) {
		this.phone = phone;
	}

	public User(BigDecimal u_id, String u_name, String password) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.password = password;
	}

	public BigDecimal getU_id() {
		return u_id;
	}

	public void setU_id(BigDecimal u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	
}
