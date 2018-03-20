package com.hwua.view.admin;

import com.hwua.dao.impl.BrandDAOImpl;
import com.hwua.pojo.Brand;

public class AddBrand {
	public static void add(String b_name){
		Brand brand = new Brand();
		brand.setB_name(b_name);
		
		BrandDAOImpl brandDAOImpl = new BrandDAOImpl();
		brandDAOImpl.add(brand);
	}
}
