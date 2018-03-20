package com.hwua.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import com.hwua.dao.CarManagementDAO;
import com.hwua.pojo.Car;
import com.hwua.util.template.Template;


public class CarDAOImpl implements CarManagementDAO<Car>{

	//添加操作
	/**
	 * c_name varchar, c_remarks varchar,brand_id number,type_id number,c_price number,c_borrwe number,c_number number
	 */
	public int add(Car car) {
		String sql = "insert into car values(sys_bookid.nextval,?,?,?,?,?,0,?,?)";
		return Template.DMLTemplate(sql,car.getC_name(),car.getC_remarks(),car.getC_brand(),car.getC_type(),car.getC_price(),car.getC_number(),car.getPorper());
		
	}

	//删除操作
	public int delete(BigDecimal i) {
		String sql = "delete car where c_id = ?";
		return Template.DMLTemplate(sql, i);
	}

	//更新car的总量
	public int upDateNum(BigDecimal num, BigDecimal id) {
		String sql = "update car  set c_number = ? where c_id = ?";
		return Template.DMLTemplate(sql, num , id);
	}
	//更新car的价格
	public int upDatePrice(BigDecimal price, BigDecimal id) {
		String sql = "update car  set c_price = ? where c_id = ?";
		return Template.DMLTemplate(sql, price , id);
	}
	//更新car的上架
	public int uppPor(BigDecimal id) {
		String sql = "update car  set porper = 'Y' where c_id = ?";
		return Template.DMLTemplate(sql, id);
	}
	//更新car的下架
	public int lowPor( BigDecimal id) {
		String sql = "update car set porper = 'N' where c_id = ?";
		int i = Template.DMLTemplate(sql, id);
		return i;
	}
	
	//查询borrwenum
	public BigDecimal getBorrwenum(BigDecimal id){
		String getBorrwe = "select c_borrwe from car where c_id = ?";
		return (BigDecimal) Template.selectOne(getBorrwe, id);
		
	}
	
	//查询剩状态为上架的 car的记录
	public List<Car> selects() {
		String sql = "select * from car where  porper = 'Y' order by c_id";
		List<Car> list = Template.DQLsTemplate(sql, Car.class);
		return list;
	}
	
	//查询所有的汽车信息
	public List<Car> Aselects() {
		String sql = "select * from car  order by c_id";
		List<Car> list = Template.DQLsTemplate(sql, Car.class);
		return list;
	}

	//查询对应id的car的信息
	public Car select(BigDecimal id) {
		String sql = "select* from car where c_id = ?";
		Car car = Template.DQLTemplate(sql, Car.class, id);
		return car;
	}
	//查询对应名称的car的信息
	public Car select(String name) {
		String sql = "select* from car where c_name = ?";
		Car car = Template.DQLTemplate(sql, Car.class, name);
		return car;
	}
	
	//查询指定的 type的 上架的车信息  
	public List<Car> selectByType(String type) {
		String sql = "select * from car where c_type like '%"+type+"%' and porper='Y'";
		return Template.DQLsTemplate(sql, Car.class);
	}
	
	//查询指定的 brand的上架的车 信息
	public List<Car> selectByBrand(String brand) {
		String sql = "select * from car where c_brand like '%"+brand+"%' and porper='Y'";
		return Template.DQLsTemplate(sql, Car.class);
	}
	
	//判断是id是否存在
	public boolean idExistent(BigDecimal id){
		String sql = "select count(*) from car where c_id=?";
		BigDecimal selectOne =(BigDecimal) Template.selectOne(sql, id);
		
		if(selectOne.intValue()==0){
			//不存在
			return  false;
		}
		return true;
		
	}
	//判断是borrwenum==0
	public boolean borrweIsnull(BigDecimal id){
		String sql = "select c_borrwe from car where c_id=?";
		BigDecimal selectOne =(BigDecimal) Template.selectOne(sql, id);
		if(selectOne.intValue()==0){
			return  true;
		}
		return false;
		
	}

	//查询上架的汽车的信息 并按id升序排列
	public List<Car> selectByIdLower() {
		String sql = "select * from car where porper='Y' order by c_id";
		List<Car> cars = Template.DQLsTemplate(sql, Car.class);
		return cars;
		
	}
	//查询上架的汽车的信息 并按id降序排列
	public List<Car> selectByIdUpper() {
		String sql = "select * from car where porper='Y' order by c_id desc";
		List<Car> cars = Template.DQLsTemplate(sql, Car.class);
		return cars;
		
	}

	@Override
	public int upDate(Car t, BigDecimal i) {
		// TODO Auto-generated method stub
		return 0;
	}
		
}