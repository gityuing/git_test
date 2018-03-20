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
		//查看car是否 处于 可租借状态
		String seleBook = "select * from car where c_id = ? and porper = 'Y'";
		Car car = Template.DQLTemplate(seleBook, Car.class, new BigDecimal(carId));
		if(car==null){
			System.err.println("输入的编号有误");
			return;
		}
		
		
		/*
		//借阅量不能大于总量
		String sqlTBook = "select c_number-c_borrwe from car where c_id = ?";
		BigDecimal number1 = (BigDecimal) Template.selectOne(sqlTBook, car.getC_id());
		if(number1.intValue()<=0){
			System.out.println("该车已经被借空");
			return;
		}
		
		*/
		
		//查看 省余的车的数量是否足够
		String sqlString = "select c_number-c_borrwe from car where c_id = ? and porper='Y'";
		BigDecimal numYL = (BigDecimal)Template.selectOne(sqlString, new BigDecimal(carId));
		if(num>numYL.intValue()){
			System.err.println("该车型的数量不足");
			return;
		}
		
		//查看是否满足借书的条件每个用户最多只能借 50car
		String sqlTUser = "select sum(borrwenum) from b_borrwe where u_id = ? and end_date is null group by u_id";
		BigDecimal number = (BigDecimal)Template.selectOne(sqlTUser,userId);
		if(number==null){
			if(num>50){
				System.err.println("每人最多借50量");
				return;
			}
		}else if((number.intValue()+num)>50){
			System.err.println("你剩余的租借数不足");
			return;
		}
		
		
		//处理事务
		Connection conn = null;
		PreparedStatement ps = null;
		
		// 回滚事件
		try {
			// 2.得到连接
			conn = jdbcUtil.getConn();
			// 加入事物处理
			conn.setAutoCommit(false);
			
			//1.增加一条借阅id
			String sqlBorrwe = "insert into b_borrwe (b_id,u_id,c_id,sta_date,borrwenum) values(sys_bookId.nextval,?,?,?,?)";
			int i = Template.DMLTemplate(conn, ps, sqlBorrwe, userId, car.getC_id(), DateUtil.date2str(new Date()),new BigDecimal(num));
			
			//2.修改图书信息中的   借阅量——>当前借阅量+num
			String sqlBook = "update car set c_borrwe = c_borrwe+? where c_id = ?";
			int j = Template.DMLTemplate(conn, ps, sqlBook, new BigDecimal(num),car.getC_id());
			if(i!=1 || j!=1){
				i = i/0;
			}
			
			System.out.println("借car成功");
			// 提交事物
			conn.commit();
		} catch (SQLException e) {
			System.err.println("借car失败！");
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
