package org.study.java.reflection;

import java.lang.reflect.Field;

public class AccessPrivateField {
	public static void main(String[] args) {
		Class<Person> c = Person.class;
		
		try{
			Field name = c.getDeclaredField("name");
			Person p = c.newInstance();
			name.setAccessible(true);
			
			System.out.println("Current name is "+((String)name.get(p)));
			
			name.set(p, "SuperSnail");
			
			System.out.println("New name is "+((String)name.get(p)));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
