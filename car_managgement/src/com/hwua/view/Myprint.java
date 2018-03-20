package com.hwua.view;


import java.util.List;

import com.hwua.Logical_processing.uesr.LookBorweCar;

public class Myprint {
	static final String xhx = "__________________________________________________________________________________________________________________________________";

	public static <T> void myPrint(List<T> list,String tableHad){
			
			System.out.println(xhx);
			System.out.println(tableHad);
			for (T obj : list) {
				if(obj == null){
					System.err.println("这里是空的~~");
				}else{
					System.out.println(obj.toString());
				}
			}
			System.out.println(xhx);
			
	}
}
