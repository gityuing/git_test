package com.hwua.Logical_processing.uesr;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.Bidi;
import java.util.Date;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.hwua.control.initSys.Userobj;
import com.hwua.pojo.User;
import com.hwua.util.DateUtil;
import com.hwua.util.jdbcUtil;
import com.hwua.util.template.Template;

/**
 * ��car�Ĳ���
 * @author yuing
 *
 */
public class BackCar {
	
	public void backBook(long borrweId) {
		Userobj userobj = Userobj.getUserobj();
		BigDecimal userId = userobj.getUser().getU_id();
		
			//�ж�bookId�Ƿ����û��Ľ��ļ�¼��  �õ�������Ϣ��c_id
			String isExistSql = "select c_id from b_borrwe where b_id = ? and u_id=? and end_date is null";
			BigDecimal carId = (BigDecimal)Template.selectOne(isExistSql, new BigDecimal(borrweId), userId);
			if(carId==null){
				System.err.println("��� �賵��Ϣ�� û�иü�¼  ");
				return;
			}else{
				back(carId,new BigDecimal(borrweId));
			}
		
			
		
		
	}
	
	
	
	private static void back(BigDecimal carId,BigDecimal borrweId){
		
		//�õ�������
		String sqlString = "select borrwenum from b_borrwe where b_id = ?";
		BigDecimal num = (BigDecimal)Template.selectOne(sqlString, borrweId);
		
		//������
		Connection conn = jdbcUtil.getConn();
		PreparedStatement ps = null;
		try {
			conn.setAutoCommit(false);
			
			//���¸ü�¼�Ļ���ʱ��
			String updateBorrwe = "update b_borrwe set end_date = ? where b_id = ?";
			Date endDate = new Date();
			int i = Template.DMLTemplate(conn, ps ,updateBorrwe, DateUtil.date2str(endDate),borrweId);
			
			//����ͼ���  ������ --->��ǰ�Ľ�����-1
			//int i = 7/0;
			String updateBook = "update car set c_borrwe = c_borrwe-? where c_id = ?";
			int j = Template.DMLTemplate(conn, ps, updateBook, num,carId);
			
			if(i!=1 || j!=1){
				i = i/0;
			}
			System.out.println("��car�ɹ�");
			conn.commit();
			
			//�����Ǯ
			//1.�õ����ڲ�
			String sqlgetDate = "select sta_date from b_borrwe where b_id = ?";
			String staDate = (String)Template.selectOne(sqlgetDate, borrweId);
			Date sta = DateUtil.str2date(staDate);
			long datePoor = DateUtil.getDatePoor(sta, endDate);
			//2.�õ��۸�
			String sqlgetPrice = "select c_price from car where c_id = ?";
			BigDecimal price = (BigDecimal)Template.selectOne(sqlgetPrice, carId);
			
			System.out.println("��car�ɹ�����һ��������"+(datePoor*num.intValue()*price.doubleValue()));
			
			
			
		} catch (SQLException e) {
			try {
				System.err.println("��carʧ��");
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			jdbcUtil.close(conn, ps, null);
		}
		
		
	}
}
