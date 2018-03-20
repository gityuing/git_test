package com.hwua.util.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hwua.util.jdbcUtil;

public class Template{
	//增删改
	public static int DMLTemplate(String sql, Object... obj) {
		Connection conn = jdbcUtil.getConn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps = addParameters(ps, obj);
			int i = ps.executeUpdate();
			
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbcUtil.close(conn, ps, null);
		}
		return 0;
	}
	
	
	//增删改  传入connection
		public static int DMLTemplate(Connection conn,PreparedStatement ps, String sql, Object... obj) throws SQLException {
				ps = conn.prepareStatement(sql);
				ps = addParameters(ps, obj);
				int i = ps.executeUpdate();
				return i;
			
		}
	
	
	
	//查询单个记录  单列单行
	public static Object selectOne(String sql,Object...obj){
		Connection conn = jdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps = addParameters(ps, obj);
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getObject(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbcUtil.close(conn, ps, rs);
		}
		return null;
	}

	//查询多行记录
	public static <T> List<T> DQLsTemplate(String sql, Class<T> classType,Object...obj){
		List<T> list = new ArrayList<>();
		Connection conn = jdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			T object = classType.newInstance();
			ps = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps = addParameters(ps, obj);
			rs = ps.executeQuery();
			rs.last();
			if(rs.getRow()==0){
				object=null;
				list.add(object);
				return list;
			}
			rs.beforeFirst();
			while (rs.next()) {
				object = ResultSetHandler.ResultSet(classType, rs);
				list.add(object);
			}
			jdbcUtil.close(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}finally{
			jdbcUtil.close(conn, ps, rs);
		}
		return list;

	}
	
	
	//查询一行记录 封装对象
	public static <T> T DQLTemplate(String sql,Class<T> classType,Object...obj){
		T object = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			object = classType.newInstance();
			conn = jdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps = addParameters(ps, obj);
			rs = ps.executeQuery();
			if(rs.next()){
				object = ResultSetHandler.ResultSet(classType, rs);
				return object;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtil.close(conn, ps, rs);
		}
		return null;
		
	}
	
	
	
	//添加参数
	private static PreparedStatement addParameters(PreparedStatement ps,Object...obj){
		if(obj!=null&&obj.length>0){
			for(int i = 1;i<=obj.length;i++){
				try {
					ps.setObject(i,obj[i-1]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ps;
	}

}