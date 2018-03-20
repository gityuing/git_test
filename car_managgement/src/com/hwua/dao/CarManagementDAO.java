package com.hwua.dao;

import java.math.BigDecimal;
import java.util.List;


public  interface CarManagementDAO <T> {
	/**
	 * 
	 * @param t ����һ������ �����ö�����������ݿ�
	 * @return ���� ��Ӱ�������
	 */
	public int add(T t);
	
	/**
	 * 
	 * @param i ���������id����ɾ����������
	 * @return ���� ��Ӱ�������
	 */
	public int delete(BigDecimal i);
	
	/**
	 * 
	 * @param t ���� ����
	 * @param i Ҫ���µ����ݵ�id
	 * @return ���� ��Ӱ�������
	 */
	public int upDate (T t,BigDecimal i);
	
	/**
	 * 
	 * @return ���ز�ѯ���Ķ���ļ���
	 */
	public List<T> selects();
	
	/**
	 * 
	 * @param i ����Ҫ��ѯ�����ݵ�id
	 * @return ��ѯ�Ķ���
	 */
	public T select(BigDecimal i);

}
