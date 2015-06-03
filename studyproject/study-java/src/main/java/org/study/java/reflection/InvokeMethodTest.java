package org.study.java.reflection;

import java.lang.reflect.Method;


public class InvokeMethodTest {
	public static void main(String[] args) {
		Class<Person> c = Person.class;
		try{
			Person p = c.newInstance();
			Method method = c.getMethod("setName", String.class);
			
			System.out.println("before invoke person="+p);
			method.invoke(p, "snail");
			System.out.println("after invoke person="+p);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
