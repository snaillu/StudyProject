package com.snail.spring.ch04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareStringComponents {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:springconfig/applicationContext.xml");
		ctx.refresh();
		
		MessageProvider messageProvider = ctx.getBean("messageProvider",MessageProvider.class);
		System.out.println(messageProvider.getMessage());
	}
}
