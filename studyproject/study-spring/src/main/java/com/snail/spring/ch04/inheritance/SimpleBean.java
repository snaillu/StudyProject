package com.snail.spring.ch04.inheritance;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
	public String name;
	public int age;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "SimpleBean [name=" + name + ", age=" + age + "]";
	}
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:springconfig/applicationContext.xml");
		ctx.refresh();
		
		SimpleBean parent = (SimpleBean)ctx.getBean("inheritParent");
		SimpleBean child = (SimpleBean)ctx.getBean("inheritChild");
		
		System.out.println("Parent:\n"+parent);
		System.out.println("Child:\n"+child);
	}
}
