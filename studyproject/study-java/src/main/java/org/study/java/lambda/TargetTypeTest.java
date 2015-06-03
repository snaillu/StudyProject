package org.study.java.lambda;

public class TargetTypeTest {
	public static void main(String[] args) {
		Adder adder = (x,y)-> x+y;
		Joiner joiner = (x,y) -> x+y;
		
		
		double sum1 = adder.add(10.11, 10.22);
		System.out.println("sum1="+sum1);
		
		String str1 = joiner.join("Hello,", "Snail");
		System.out.println("str1="+str1);
	}
}
