package org.study.java.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodReflection {
	public static void main(String[] args) {
		Class<Person> c = Person.class;
		
		ArrayList<String> methodsDescripton = getDeclaredMethods(c);
		System.out.println("Declared methods for "+c.getName());
		for(String desc:methodsDescripton){
			System.out.println(desc);
		}
		
		methodsDescripton = getMethodList(c);
		System.out.println("\nMethods for "+c.getName());
		for(String desc:methodsDescripton){
			System.out.println(desc);
		}
	}
	
	public static ArrayList<String> getMethodList(Class c){
		Method[] methods = c.getMethods();
		ArrayList<String> methodsList = getMethodDescription(methods);
		
		return methodsList;
	}
	
	public static ArrayList<String> getDeclaredMethods(Class c){
		Method[] methods = c.getDeclaredMethods();
		ArrayList<String> methodsList = getMethodDescription(methods);
		
		return methodsList;
	}
	
	public static ArrayList<String> getMethodDescription(Method[] methods){
		ArrayList<String> methodList = new ArrayList<String>();
		
		for(Method m:methods){
			String modifiers = ExecutableUtil.getModifier(m);
			
			Class returnType = m.getReturnType();
			String returnTypeName = returnType.getSimpleName();
			
			String methodName = m.getName();
			
			ArrayList<String> paramsList = ExecutableUtil.getParameters(m);
			String params = ExecutableUtil.arrayListToString(paramsList, ",");
			
			String throwsClause = ExecutableUtil.getThrowsClause(m);
			methodList.add(modifiers+" "+returnType+" "+methodName+"("+params+")"+throwsClause);
		}
		
		return methodList;
	}
}
