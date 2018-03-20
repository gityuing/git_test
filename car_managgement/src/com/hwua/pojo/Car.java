package com.hwua.pojo;

import java.math.BigDecimal;
import java.util.Map;

import com.hwua.control.initSys.TBObj;

//domain类 :Xxx,比如:Employee.
//DAO接    口:IXxxDAO/IXxxDao 
//DAO实现类:XxxDAOImpl/XxxDaoImpl
//DAO测试类: XxxDAOTest
/**
 * B_BOOK表     ID   B_NAME   B_BORRWE   COLUMN4
 * @author yuing
 *
 */
public class Car {
	private BigDecimal c_id;
	private String c_name;
	private String c_remarks;
	private BigDecimal c_brand;
	private BigDecimal c_type;
	private BigDecimal c_price;
	private BigDecimal c_borrwe;
	private BigDecimal c_number;
	private String porper = "Y";
	
	
	private static Map<BigDecimal, String> typeMap;
	private static Map<BigDecimal, String> brandMap;
	
	static{
		TBObj mapObj = TBObj.getMapObj();
		typeMap = mapObj.getTypeMap();
		brandMap = mapObj.getBrandMap();
	}
	
	public Car(){}
	
	public Car(String c_name, String c_remarks, BigDecimal c_brand,
			BigDecimal c_type, BigDecimal c_price, BigDecimal c_borrwe,
			BigDecimal c_number,String porper) {
		super();
		this.c_name = c_name;
		this.c_remarks = c_remarks;
		this.c_brand = c_brand;
		this.c_type = c_type;
		this.c_price = c_price;
		this.c_borrwe = c_borrwe;
		this.c_number = c_number;
		this.porper = porper;
	}
	
	public BigDecimal getC_id() {
		return c_id;
	}

	public void setC_id(BigDecimal c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_remarks() {
		return c_remarks;
	}
	public void setC_remarks(String c_remarks) {
		this.c_remarks = c_remarks;
	}
	
	public BigDecimal getC_brand() {
		return c_brand;
	}

	public void setC_brand(BigDecimal c_brand) {
		this.c_brand = c_brand;
	}

	public BigDecimal getC_type() {
		return c_type;
	}

	public void setC_type(BigDecimal c_type) {
		this.c_type = c_type;
	}

	public BigDecimal getC_price() {
		return c_price;
	}
	public void setC_price(BigDecimal c_price) {
		this.c_price = c_price;
	}
	public BigDecimal getC_borrwe() {
		return c_borrwe;
	}
	public void setC_borrwe(BigDecimal c_borrwe) {
		this.c_borrwe = c_borrwe;
	}
	public BigDecimal getC_number() {
		return c_number;
	}
	public void setC_number(BigDecimal c_number) {
		this.c_number = c_number;
	}
	

	public String getPorper() {
		return porper;
	}

	public void setPorper(String porper) {
		this.porper = porper.toUpperCase();
	}

	//普通用户
	public String toString() {
		String jj = "";
		
		String tabStr = "\t\t";
		int i = this.getC_number().intValue()-this.getC_borrwe().intValue();
		if(i>0){
			jj = "是";
		}else{
			jj = "否";
		}
		return "|"+this.getC_id()+tabStr+
				"|"+this.getC_name()+tabStr+
				"|"+this.getC_remarks()+tabStr+
				"|"+brandMap.get(this.getC_brand())+"("+this.getC_brand()+")"+tabStr+
				"|"+typeMap.get(this.getC_type())+"("+this.getC_type()+")"+tabStr+
				"|"+this.getC_price().doubleValue()+"￥/天"+tabStr+
				"|"+i+tabStr+
				"|"+jj;
	}
	
	//管理员
	public String toStr() {
		String tabStr = "\t\t";
		String por = "";
		if(this.porper.equals("Y")){
			por = "是";
		}else {
			por = "否";
		}
		return "|"+this.getC_id()+"\t"+
				"|"+this.getC_name()+"\t"+
				"|"+this.getC_remarks()+tabStr+
				"|"+brandMap.get(this.getC_brand())+"("+this.getC_brand()+")"+tabStr+
				"|"+typeMap.get(this.getC_type())+"("+this.getC_type()+")"+tabStr+
				"|"+this.getC_borrwe()+tabStr+
				"|"+this.getC_number()+tabStr+
				"|"+this.getC_price()+"/天"+tabStr+
				por;
	}

}
