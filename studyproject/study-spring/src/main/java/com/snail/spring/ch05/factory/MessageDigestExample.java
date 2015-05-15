package com.snail.spring.ch05.factory;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:springconfig/applicationContext.xml");
		ctx.refresh();
		
		MessageDigester digester = (MessageDigester)ctx.getBean("digester");
		digester.digest("Hello snail.");
	}
}
