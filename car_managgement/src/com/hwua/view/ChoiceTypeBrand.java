package com.hwua.view;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import com.hwua.control.initSys.TBObj;

/**
 *  ��ӡ��ʾ ���û� ѡ�� type�� ��brand ���� ��Ӧ�ı��
 * @author yuing
 *
 */
public class ChoiceTypeBrand {
	static Scanner scanner = new Scanner(System.in);
	public static int getType() {
		TBObj mapObj = TBObj.getMapObj();
		Map<BigDecimal, String> typeMap = mapObj.getTypeMap();
		
		Set<Entry<BigDecimal, String>> entrySet = typeMap.entrySet();
		for (Entry<BigDecimal, String> entry : entrySet) {
			System.out.println(entry.getValue()+"("+entry.getKey()+")");
		}
		
		int i = scanner.nextInt();
		return i;
		

	}

	public static int getBrand() {
		TBObj mapObj = TBObj.getMapObj();
		Map<BigDecimal, String> brandMap = mapObj.getBrandMap();
		
		Set<Entry<BigDecimal, String>> entrySet = brandMap.entrySet();
		for (Entry<BigDecimal, String> entry : entrySet) {
			System.out.println(entry.getValue()+"("+entry.getKey()+")");
		}
		
		int i = scanner.nextInt();
		return i;
	}
}
