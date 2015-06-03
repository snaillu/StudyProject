package org.study.java.innerclass;

public class Outer2 {
	private int value = 999;
	
	public void setValue(int value){
		this.value = value;
	}
	
	public void printValue(){
		System.out.println("Outer2 value="+value);
	}
	
	public class Inner{
		private int value = 888;
		
		public void printValue(){
			System.out.println("Inner value="+value);
		}
	}
}
