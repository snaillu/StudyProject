package com.snail.spring.ch04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class NonSingleton {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:springconfig/applicationContext.xml");
		ctx.refresh();
		
		String s1 = (String)ctx.getBean("nonSingleton");
		String s2 = (String)ctx.getBean("nonSingleton");
		
		System.out.println("Identity Equals?: "+(s1==s2));
		System.out.println("Value Equal:? "+s1.equals(s2));
		System.out.println("s1="+s1);
		System.out.println("s2="+s2);
	}
}
