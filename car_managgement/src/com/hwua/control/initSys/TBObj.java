package com.hwua.control.initSys;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TBObj {
	private Map<BigDecimal, String> typeMap = new HashMap<BigDecimal, String>();
	private Map<BigDecimal, String> BrandMap = new HashMap<BigDecimal, String>();
	
	private static TBObj mapObj = null;
	
	private TBObj() {}
	
	public static TBObj getMapObj() {
		if(mapObj==null){
			mapObj = new TBObj();
		}
		return mapObj;

	}

	public Map<BigDecimal, String> getTypeMap() {
		return typeMap;
	}

	public void setTypeMap(Map<BigDecimal, String> typeMap) {
		this.typeMap = typeMap;
	}

	public Map<BigDecimal, String> getBrandMap() {
		return BrandMap;
	}

	public void setBrandMap(Map<BigDecimal, String> brandMap) {
		BrandMap = brandMap;
	}
}
