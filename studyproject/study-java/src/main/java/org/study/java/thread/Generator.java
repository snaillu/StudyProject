package org.study.java.thread;

import java.util.concurrent.atomic.AtomicLong;

public class Generator {
	private final AtomicLong value = new AtomicLong(1);
	
	public long getValue(){
		return value.incrementAndGet();
	}
	
	public static void main(String[] args) {
		Generator g = new Generator();
		System.out.println(g.getValue());
	}
}
