package org.study.java.reflection;

public class NewInstanceTest {
	public static void main(String[] args) {
		Class<Person> c = Person.class;
		
		try {
			Person p = c.newInstance();
			System.out.println(p);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
