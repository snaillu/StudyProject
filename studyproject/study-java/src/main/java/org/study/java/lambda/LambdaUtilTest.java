package org.study.java.lambda;

public class LambdaUtilTest {
	public static void main(String[] args) {
		LambdaUtil util = new LambdaUtil();
		
		util.testAdder((x,y) -> x+y);
		util.testJoiner((x,y)-> x+" "+y);
	}
}
