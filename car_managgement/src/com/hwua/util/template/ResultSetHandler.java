package com.hwua.util.template;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ResultSetHandler {
	public static <T> T ResultSet(Class<T> classType,ResultSet rs){
		try {
			T object = classType.newInstance();
			BeanInfo info = Introspector.getBeanInfo(classType, Object.class);
			PropertyDescriptor[] pds = info.getPropertyDescriptors();
				for (PropertyDescriptor pd : pds) {
					//得到属�?名的大写（字段名�? 
					String propertName = pd.getName().toUpperCase();
					//调用属�?的set方法 给属性赋�?
					Method wMethod = pd.getWriteMethod();
					
					Object values = rs.getObject(propertName);
					if(values==null){
						continue;
					}
					wMethod.invoke(object,values);
					
				}
			return object;
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;

	}
}
