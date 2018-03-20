package com.hwua.Logical_processing.uesr;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.hwua.control.initSys.Userobj;
import com.hwua.pojo.Car;
import com.hwua.pojo.User;
import com.hwua.util.DateUtil;
import com.hwua.util.jdbcUtil;
import com.hwua.util.template.Template;

public class BorrweCar {
	public void borrweBook(long carId,int num) {
		Userobj userobj = Userobj.getUserobj();
		
		BigDecimal userId = userobj.getUser().getU_id();
		//�鿴car�Ƿ� ���� �����״̬
		String seleBook = "select * from car where c_id = ? and porper = 'Y'";
		Car car = Template.DQLTemplate(seleBook, Car.class, new BigDecimal(carId));
		if(car==null){
			System.err.println("����ı������");
			return;
		}
		
		
		/*
		//���������ܴ�������
		String sqlTBook = "select c_number-c_borrwe from car where c_id = ?";
		BigDecimal number1 = (BigDecimal) Template.selectOne(sqlTBook, car.getC_id());
		if(number1.intValue()<=0){
			System.out.println("�ó��Ѿ������");
			return;
		}
		
		*/
		
		//�鿴 ʡ��ĳ��������Ƿ��㹻
		String sqlString = "select c_number-c_borrwe from car where c_id = ? and porper='Y'";
		BigDecimal numYL = (BigDecimal)Template.selectOne(sqlString, new BigDecimal(carId));
		if(num>numYL.intValue()){
			System.err.println("�ó��͵���������");
			return;
		}
		
		//�鿴�Ƿ�������������ÿ���û����ֻ�ܽ� 50car
		String sqlTUser = "select sum(borrwenum) from b_borrwe where u_id = ? and end_date is null group by u_id";
		BigDecimal number = (BigDecimal)Template.selectOne(sqlTUser,userId);
		if(number==null){
			if(num>50){
				System.err.println("ÿ������50��");
				return;
			}
		}else if((number.intValue()+num)>50){
			System.err.println("��ʣ������������");
			return;
		}
		
		
		//��������
		Connection conn = null;
		PreparedStatement ps = null;
		
		// �ع��¼�
		try {
			// 2.�õ�����
			conn = jdbcUtil.getConn();
			// �������ﴦ��
			conn.setAutoCommit(false);
			
			//1.����һ������id
			String sqlBorrwe = "insert into b_borrwe (b_id,u_id,c_id,sta_date,borrwenum) values(sys_bookId.nextval,?,?,?,?)";
			int i = Template.DMLTemplate(conn, ps, sqlBorrwe, userId, car.getC_id(), DateUtil.date2str(new Date()),new BigDecimal(num));
			
			//2.�޸�ͼ����Ϣ�е�   ����������>��ǰ������+num
			String sqlBook = "update car set c_borrwe = c_borrwe+? where c_id = ?";
			int j = Template.DMLTemplate(conn, ps, sqlBook, new BigDecimal(num),car.getC_id());
			if(i!=1 || j!=1){
				i = i/0;
			}
			
			System.out.println("��car�ɹ�");
			// �ύ����
			conn.commit();
		} catch (SQLException e) {
			System.err.println("��carʧ�ܣ�");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally{
			jdbcUtil.close(conn, ps, null);
		}
	}
}
