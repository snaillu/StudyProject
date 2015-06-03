package org.study.java.innerclass;

public class Outer1 {
	private int value = 9999;
	public void setValue(int value){
		this.value = value;
	}
	
	public void printValue(){
		System.out.println("Outer1 value="+value);
	}
	
	public class Inner{
		public void printValue(){
			System.out.println("Inner value="+value);
		}
	}
}
