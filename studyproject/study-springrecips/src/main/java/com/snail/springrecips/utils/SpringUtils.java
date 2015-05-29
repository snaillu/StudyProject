package com.snail.springrecips.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringUtils {
	public static ApplicationContext getContext(){
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:springconfig/applicationContext.xml");
		
		return ctx;
	}
}
