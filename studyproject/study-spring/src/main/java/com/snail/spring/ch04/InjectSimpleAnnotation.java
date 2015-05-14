package com.snail.spring.ch04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleAnn")
public class InjectSimpleAnnotation {
	@Value("Snail")
	private String name;
	
	@Value("27")
	private int age;
	
	@Value("1.79")
	private float height;
	
	@Value("true")
	private boolean programmer;
	
	@Value("1221929121")
	private Long ageInSeconds;
	
	@Override
	public String toString() {
		return "InjectSimpleAnnotation [name=" + name + ", age=" + age + ", height="
				+ height + ", programmer=" + programmer + ", ageInSeconds="
				+ ageInSeconds + "]";
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:springconfig/applicationContext.xml");
		ctx.refresh();
		
		InjectSimpleAnnotation simple = (InjectSimpleAnnotation)ctx.getBean("injectSimpleAnn");
		System.out.println(simple);
	}
	
}
