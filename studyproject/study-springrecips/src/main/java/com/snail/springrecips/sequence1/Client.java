package com.snail.springrecips.sequence1;

import org.springframework.context.ApplicationContext;

import com.snail.springrecips.utils.SpringUtils;

public class Client {
	public static void main(String[] args) {
		ApplicationContext context = SpringUtils.getContext();
		SequenceGenerator generator = (SequenceGenerator)context.getBean("sequenceGenerator");
		
		System.out.println(generator.getSequence());
		System.out.println(generator.getSequence());
	}
}
