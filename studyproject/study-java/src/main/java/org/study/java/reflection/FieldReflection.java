package org.study.java.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class FieldReflection {
	public static void main(String[] args) {
		Class<Person> c = Person.class;
		ArrayList<String> fieldDescription =  getDeclaredFieldList(c);
		System.out.println("Declared Fields for "+c.getName());
		for(String desc:fieldDescription){
			System.out.println(desc);
		}
		
		fieldDescription = getFieldsList(c);
		System.out.println("\nAccessible Fields for "+c.getName());
		for(String desc:fieldDescription){
			System.out.println(desc);
		}
		
	}
	
	public static ArrayList<String> getFieldsList(Class c){
		Field[] fields = c.getFields();
		ArrayList<String> fieldsList = getFieldsDescription(fields);
		
		return fieldsList;
	}
	
	public static ArrayList<String> getDeclaredFieldList(Class c){
		Field[] fields = c.getDeclaredFields();
		ArrayList<String> fieldList = getFieldsDescription(fields);
		
		return fieldList;
	}
	
	public static ArrayList<String> getFieldsDescription(Field[] fields){
		ArrayList<String> fieldList = new ArrayList<String>();
		
		for(Field f : fields){
			int mod = f.getModifiers() & Modifier.fieldModifiers();
			String modifier = Modifier.toString(mod);
			
			Class<?> type = f.getType();
			String typeName = type.getSimpleName();
			
			String fieldName = f.getName();
			
			fieldList.add(modifier +"  "+typeName+"  "+fieldName);
		}
		
		return fieldList;
	}
}
