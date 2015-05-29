package com.snail.springrecips.shop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:springconfig/applicationContext.xml");
		
		Product aa = (Product)ctx.getBean("aaa");
		Product cdrw = (Product)ctx.getBean("cdrw");
		
		System.out.println(aa);
		System.out.println(cdrw);
	}
}
