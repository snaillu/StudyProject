package org.study.java.reflection;

import java.lang.reflect.Field;

public class FieldAccessTest {
	public static void main(String[] args) {
		Class<PublicPerson> c = PublicPerson.class;
		
		try{
			PublicPerson p = c.newInstance();
			Field name = c.getField("name");
			
			String nameVal = (String)name.get(p);
			System.out.println("Current name is "+nameVal);
			name.set(p, "snail");
			
			nameVal = (String)name.get(p);
			System.out.println("New name is "+nameVal);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
