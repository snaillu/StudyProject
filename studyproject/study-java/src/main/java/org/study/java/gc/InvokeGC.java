package org.study.java.gc;

public class InvokeGC {
	public static void createObjects(int count){
		for(int i=0;i<count;i++){
			new String("This is snail");
		}
	}
	
	public static void main(String[] args) {
		long m1,m2,m3;
		
		Runtime rt = Runtime.getRuntime();
		
		for(int i=0;i<3;i++){
			m1 = rt.freeMemory();
			
			createObjects(3000);
			
			m2 = rt.freeMemory();
			
			System.gc();
			
			m3 = rt.freeMemory();
			
			System.out.println("m1="+m1+" ,m2="+m2+" ,m3="+m3+" \nMemory freed by gc()="+(m3-m2));
		}
	}
}
