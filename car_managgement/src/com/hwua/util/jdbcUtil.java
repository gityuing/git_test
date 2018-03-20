package com.hwua.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class jdbcUtil {
	private static DataSource ds = null;

    static{
    	Properties p = new Properties();
    	try {
    		ClassLoader loader = Thread.currentThread().getContextClassLoader();
    		InputStream inputStream = loader.getResourceAsStream("config.properties");
			p.load(inputStream);
		} catch (Exception e) {
			throw new RuntimeException("�ļ�����ʧ��", e);
		}
    	try {
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			throw new RuntimeException("���ӳ�ʧ��", e);
		}

    }
	
	
	public static Connection getConn(){
		Connection conn = null;
		try {
			//�������ݿ�����
			conn = ds.getConnection();
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void close(Connection conn,Statement ps,ResultSet rs){
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
