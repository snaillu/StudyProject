package org.study.java.reflection;

import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

public class ClassReflection {
	public static void main(String[] args) {
		String classDesc = getClassDescription(Person.class);
		System.out.println(classDesc);
	}
	public static String getClassDescription(Class c){
		StringBuilder classDesc = new StringBuilder();
		
		int modifierBits = 0;
		String keyword = "";
		
		if(c.isPrimitive()){
			
		}else if(c.isInterface()){
			modifierBits = c.getModifiers()&Modifier.interfaceModifiers();
			
			if(c.isAnnotation()){
				keyword = "@interface";
			}else{
				keyword = "interface";
			}
		}else if(c.isEnum()){
			modifierBits = c.getModifiers() & Modifier.classModifiers();
			keyword = "enum";
		}else{
			modifierBits = c.getModifiers() & Modifier.classModifiers();
			keyword = "class";
		}
		
		//convert modifiers to their string representation
		String modifiers = Modifier.toString(modifierBits);
		
		classDesc.append(modifiers);
		classDesc.append("  "+keyword);
		classDesc.append("  "+c.getSimpleName());
		classDesc.append(getGenericTypeParams(c));
		
		Class superClass = c.getSuperclass();
		if(superClass!=null){
			String superClassSimpleName = superClass.getSimpleName();
			classDesc.append(" extends "+ superClassSimpleName);
		}
		
		String interfaces = ClassReflection.getClassInterfaces(c);
		if(interfaces != null){
			classDesc.append(" implements ").append(interfaces);
		}
		
		return classDesc.toString();
	}
	
	public static String getClassInterfaces(Class c){
		Class[] interfaces = c.getInterfaces();
		String interfaceList = null;
		if(interfaces.length>0){
			String[] interfaceNames = new String[interfaces.length];
			for(int i=0;i<interfaces.length;i++){
				interfaceNames[i] = interfaces[i].getSimpleName();
			}
			interfaceList = String.join(", ", interfaceNames);
		}
		
		return interfaceList;
	}
	
	public static String getGenericTypeParams(Class c){
		StringBuilder sb = new StringBuilder();
		TypeVariable<?>[] typeParms = c.getTypeParameters();
		
		if(typeParms.length>0){
			String[] paramNames = new String[typeParms.length];
			for(int i=0;i<typeParms.length;i++){
				paramNames[i] = typeParms[i].getTypeName();
			}
			
			sb.append("<");
			sb.append(String.join(",", paramNames));
			sb.append(">");
		}
		
		return sb.toString();
	}
}
