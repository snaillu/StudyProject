package org.study.java;

import java.util.Date;

public class TestDate extends Date {
	public static void main(String[] args) {
		new TestDate().test();
	}
	
	public void test(){
		System.out.println("  "+super.getClass().getName());
		System.out.println("  "+super.getClass().getSuperclass().getName());
	}
}
