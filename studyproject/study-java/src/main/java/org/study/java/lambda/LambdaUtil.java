package org.study.java.lambda;

public class LambdaUtil {
	public void testAdder(Adder adder){
		double x = 10.10;
		double y = 20.20;
		double sum = adder.add(x, y);
		System.out.println("Using an Adder:");
		System.out.println(x+" + "+y+" = "+sum);
	}
	
	public void testJoiner(Joiner joiner){
		String s1= "Hello";
		String s2 = "World";
		String s3 = joiner.join(s1, s2);
		System.out.println("Using a Joiner:");
		System.out.println("\""+s1+"\" + \""+s2+"\" = "+s3);
	}
}
