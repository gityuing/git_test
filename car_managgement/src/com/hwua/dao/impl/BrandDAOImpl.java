package com.hwua.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import com.hwua.dao.CarManagementDAO;
import com.hwua.pojo.Brand;
import com.hwua.util.template.Template;

public class BrandDAOImpl implements CarManagementDAO<Brand>{

	@Override
	public int add(Brand brand) {
		String sql = "insert into t_brand values(sys_bookid.nextval,?)";
		return Template.DMLTemplate(sql, brand.getB_name());
		
	}

	@Override
	public int delete(BigDecimal i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int upDate(Brand t, BigDecimal i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Brand> selects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Brand select(BigDecimal i) {
		// TODO Auto-generated method stub
		return null;
	}

}
