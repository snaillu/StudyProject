package org.study.java.thread;

public class SimpleInterrupt {
	public static void main(String[] args) {
		System.out.println("#1:"+Thread.interrupted());
		
		Thread.currentThread().interrupt();
		
		System.out.println("#2:"+Thread.interrupted());
		
		System.out.println("#3:"+Thread.interrupted());
	}
}
