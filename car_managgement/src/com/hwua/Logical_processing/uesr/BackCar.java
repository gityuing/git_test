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
 * 还car的操作
 * @author yuing
 *
 */
public class BackCar {
	
	public void backBook(long borrweId) {
		Userobj userobj = Userobj.getUserobj();
		BigDecimal userId = userobj.getUser().getU_id();
		
			//判断bookId是否在用户的借阅记录中  得到借阅信息的c_id
			String isExistSql = "select c_id from b_borrwe where b_id = ? and u_id=? and end_date is null";
			BigDecimal carId = (BigDecimal)Template.selectOne(isExistSql, new BigDecimal(borrweId), userId);
			if(carId==null){
				System.err.println("你的 借车信息中 没有该记录  ");
				return;
			}else{
				back(carId,new BigDecimal(borrweId));
			}
		
			
		
		
	}
	
	
	
	private static void back(BigDecimal carId,BigDecimal borrweId){
		
		//得到借阅量
		String sqlString = "select borrwenum from b_borrwe where b_id = ?";
		BigDecimal num = (BigDecimal)Template.selectOne(sqlString, borrweId);
		
		//事务处理
		Connection conn = jdbcUtil.getConn();
		PreparedStatement ps = null;
		try {
			conn.setAutoCommit(false);
			
			//更新该记录的还书时间
			String updateBorrwe = "update b_borrwe set end_date = ? where b_id = ?";
			Date endDate = new Date();
			int i = Template.DMLTemplate(conn, ps ,updateBorrwe, DateUtil.date2str(endDate),borrweId);
			
			//更新图书的  借阅量 --->当前的借阅量-1
			//int i = 7/0;
			String updateBook = "update car set c_borrwe = c_borrwe-? where c_id = ?";
			int j = Template.DMLTemplate(conn, ps, updateBook, num,carId);
			
			if(i!=1 || j!=1){
				i = i/0;
			}
			System.out.println("还car成功");
			conn.commit();
			
			//计算价钱
			//1.得到日期差
			String sqlgetDate = "select sta_date from b_borrwe where b_id = ?";
			String staDate = (String)Template.selectOne(sqlgetDate, borrweId);
			Date sta = DateUtil.str2date(staDate);
			long datePoor = DateUtil.getDatePoor(sta, endDate);
			//2.得到价格
			String sqlgetPrice = "select c_price from car where c_id = ?";
			BigDecimal price = (BigDecimal)Template.selectOne(sqlgetPrice, carId);
			
			System.out.println("还car成功！您一共消费了"+(datePoor*num.intValue()*price.doubleValue()));
			
			
			
		} catch (SQLException e) {
			try {
				System.err.println("还car失败");
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
