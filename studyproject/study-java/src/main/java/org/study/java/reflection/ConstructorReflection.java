package org.study.java.reflection;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class ConstructorReflection {
	public static void main(String[] args) {
		Class<Person> c = Person.class;
		
		System.out.println("Construtor for "+c.getName());
		Constructor[] constructors = c.getConstructors();
		ArrayList<String> constructorsDescList = getConstructorsDescription(constructors);
		for(String desc:constructorsDescList){
			System.out.println(desc);
		}
	}
	
	public static ArrayList<String> getConstructorsDescription(Constructor[] constructors){
		ArrayList<String> constructorList = new ArrayList<String>();
		
		for(Constructor constructor:constructors){
			String modifier = ExecutableUtil.getModifier(constructor);
			String constructorName = constructor.getName();
			
			ArrayList<String> paramsList = ExecutableUtil.getParameters(constructor);
			String parms = ExecutableUtil.arrayListToString(paramsList, ",");
			
			String throwsClause = ExecutableUtil.getThrowsClause(constructor);
			constructorList.add(modifier+" "+constructorName+"("+parms+")"+throwsClause);
		}
		return constructorList;
	}
}
