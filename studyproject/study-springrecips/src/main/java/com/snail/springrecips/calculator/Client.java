package com.snail.springrecips.calculator;

import org.springframework.context.ApplicationContext;

import com.snail.springrecips.utils.SpringUtils;

public class Client {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringUtils.getContext();
		
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator)ctx.getBean("arithmeticCalculator");
		arithmeticCalculator.add(1, 2);
		arithmeticCalculator.sub(4, 3);
		arithmeticCalculator.mul(2, 3);
		arithmeticCalculator.div(4, 2);
	}
}
