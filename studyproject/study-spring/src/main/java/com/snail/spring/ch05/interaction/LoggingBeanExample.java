package com.snail.spring.ch05.interaction;

import org.springframework.context.support.GenericXmlApplicationContext;

public class LoggingBeanExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:springconfig/applicationContext.xml");
		ctx.refresh();
		
		LoggingBean bean = (LoggingBean)ctx.getBean("loggingBean");
		bean.someOperation();
	}
}
