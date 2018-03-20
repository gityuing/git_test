package com.hwua.test;

import com.hwua.Logical_processing.Systeminit;
import com.hwua.view.ChoiceLRview;

public class carTest {
	public static void main(String[] args) {
		
		System.out.println("欢迎进入租车系统");
		Systeminit.init();
		ChoiceLRview.choice();
	}
}
