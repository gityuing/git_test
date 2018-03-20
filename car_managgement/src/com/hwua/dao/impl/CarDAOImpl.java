package com.hwua.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import com.hwua.dao.CarManagementDAO;
import com.hwua.pojo.Car;
import com.hwua.util.template.Template;


public class CarDAOImpl implements CarManagementDAO<Car>{

	//��Ӳ���
	/**
	 * c_name varchar, c_remarks varchar,brand_id number,type_id number,c_price number,c_borrwe number,c_number number
	 */
	public int add(Car car) {
		String sql = "insert into car values(sys_bookid.nextval,?,?,?,?,?,0,?,?)";
		return Template.DMLTemplate(sql,car.getC_name(),car.getC_remarks(),car.getC_brand(),car.getC_type(),car.getC_price(),car.getC_number(),car.getPorper());
		
	}

	//ɾ������
	public int delete(BigDecimal i) {
		String sql = "delete car where c_id = ?";
		return Template.DMLTemplate(sql, i);
	}

	//����car������
	public int upDateNum(BigDecimal num, BigDecimal id) {
		String sql = "update car  set c_number = ? where c_id = ?";
		return Template.DMLTemplate(sql, num , id);
	}
	//����car�ļ۸�
	public int upDatePrice(BigDecimal price, BigDecimal id) {
		String sql = "update car  set c_price = ? where c_id = ?";
		return Template.DMLTemplate(sql, price , id);
	}
	//����car���ϼ�
	public int uppPor(BigDecimal id) {
		String sql = "update car  set porper = 'Y' where c_id = ?";
		return Template.DMLTemplate(sql, id);
	}
	//����car���¼�
	public int lowPor( BigDecimal id) {
		String sql = "update car set porper = 'N' where c_id = ?";
		int i = Template.DMLTemplate(sql, id);
		return i;
	}
	
	//��ѯborrwenum
	public BigDecimal getBorrwenum(BigDecimal id){
		String getBorrwe = "select c_borrwe from car where c_id = ?";
		return (BigDecimal) Template.selectOne(getBorrwe, id);
		
	}
	
	//��ѯʣ״̬Ϊ�ϼܵ� car�ļ�¼
	public List<Car> selects() {
		String sql = "select * from car where  porper = 'Y' order by c_id";
		List<Car> list = Template.DQLsTemplate(sql, Car.class);
		return list;
	}
	
	//��ѯ���е�������Ϣ
	public List<Car> Aselects() {
		String sql = "select * from car  order by c_id";
		List<Car> list = Template.DQLsTemplate(sql, Car.class);
		return list;
	}

	//��ѯ��Ӧid��car����Ϣ
	public Car select(BigDecimal id) {
		String sql = "select* from car where c_id = ?";
		Car car = Template.DQLTemplate(sql, Car.class, id);
		return car;
	}
	//��ѯ��Ӧ���Ƶ�car����Ϣ
	public Car select(String name) {
		String sql = "select* from car where c_name = ?";
		Car car = Template.DQLTemplate(sql, Car.class, name);
		return car;
	}
	
	//��ѯָ���� type�� �ϼܵĳ���Ϣ  
	public List<Car> selectByType(String type) {
		String sql = "select * from car where c_type like '%"+type+"%' and porper='Y'";
		return Template.DQLsTemplate(sql, Car.class);
	}
	
	//��ѯָ���� brand���ϼܵĳ� ��Ϣ
	public List<Car> selectByBrand(String brand) {
		String sql = "select * from car where c_brand like '%"+brand+"%' and porper='Y'";
		return Template.DQLsTemplate(sql, Car.class);
	}
	
	//�ж���id�Ƿ����
	public boolean idExistent(BigDecimal id){
		String sql = "select count(*) from car where c_id=?";
		BigDecimal selectOne =(BigDecimal) Template.selectOne(sql, id);
		
		if(selectOne.intValue()==0){
			//������
			return  false;
		}
		return true;
		
	}
	//�ж���borrwenum==0
	public boolean borrweIsnull(BigDecimal id){
		String sql = "select c_borrwe from car where c_id=?";
		BigDecimal selectOne =(BigDecimal) Template.selectOne(sql, id);
		if(selectOne.intValue()==0){
			return  true;
		}
		return false;
		
	}

	//��ѯ�ϼܵ���������Ϣ ����id��������
	public List<Car> selectByIdLower() {
		String sql = "select * from car where porper='Y' order by c_id";
		List<Car> cars = Template.DQLsTemplate(sql, Car.class);
		return cars;
		
	}
	//��ѯ�ϼܵ���������Ϣ ����id��������
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