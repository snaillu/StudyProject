package com.snail.spring.ch05.lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ShutdownHookExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:springconfig/applicationContext.xml");
		ctx.registerShutdownHook();
		ctx.refresh();
		
		DestructiveBean bean = (DestructiveBean)ctx.getBean("destructiveBean");
	}
}
