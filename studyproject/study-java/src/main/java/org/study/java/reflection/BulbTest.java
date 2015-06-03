package org.study.java.reflection;

public class BulbTest {
	public static void main(String[] args) {
		BulbTest t = new BulbTest();
		//t.classLiteral();
		//t.forName();
		//t.forNameVersion2();
		t.createObject();
	}
	
	public static void classLiteral(){
		Class<Bulb> c = Bulb.class;
	}
	
	public static void forName(){
		try{
			String className = "org.study.java.reflection.Bulb";
			Class c = Class.forName(className);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void forNameVersion2(){
		try{
			String className = "org.study.java.reflection.Bulb";
			boolean initialize = false;
			ClassLoader cloader = BulbTest.class.getClassLoader();
			
			Class c = Class.forName(className,initialize,cloader);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void createObject(){
		new Bulb();
	}
}
