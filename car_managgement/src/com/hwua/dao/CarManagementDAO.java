package com.hwua.dao;

import java.math.BigDecimal;
import java.util.List;


public  interface CarManagementDAO <T> {
	/**
	 * 
	 * @param t 传入一个对象 并将该对象存贮进数据库
	 * @return 返回 受影响的行数
	 */
	public int add(T t);
	
	/**
	 * 
	 * @param i 传入表对象的id，并删除这条数据
	 * @return 返回 受影响的行数
	 */
	public int delete(BigDecimal i);
	
	/**
	 * 
	 * @param t 传入 对象，
	 * @param i 要更新的数据的id
	 * @return 返回 受影响的行数
	 */
	public int upDate (T t,BigDecimal i);
	
	/**
	 * 
	 * @return 返回查询到的对象的集合
	 */
	public List<T> selects();
	
	/**
	 * 
	 * @param i 传入要查询的数据的id
	 * @return 查询的对象
	 */
	public T select(BigDecimal i);

}
