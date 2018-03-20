package com.hwua.Logical_processing;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hwua.control.initSys.TBObj;
import com.hwua.pojo.Brand;
import com.hwua.pojo.Type;
import com.hwua.util.template.Template;

public class Systeminit {
	public static void init(){
		TBObj mapObj = TBObj.getMapObj();
		Map<BigDecimal, String> tmap = new HashMap<BigDecimal, String>();
		Map<BigDecimal, String> bmap = new HashMap<BigDecimal, String>();
		
		//set  type
		String sql = "select*from t_type";
		List<Type> types = Template.DQLsTemplate(sql,Type.class);
		for (Type type : types) {
			tmap.put(type.getT_id(), type.getT_name());
			
		}
		mapObj.setTypeMap(tmap);
		
		
		//set   brand
		sql = "select*from t_brand";
		List<Brand> brands = Template.DQLsTemplate(sql,Brand.class);
		for (Brand brand : brands) {
			bmap.put(brand.getB_id(), brand.getB_name());
		}
		mapObj.setBrandMap(bmap);
	}

}
