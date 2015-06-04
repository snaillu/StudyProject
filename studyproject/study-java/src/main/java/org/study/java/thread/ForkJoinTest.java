package org.study.java.thread;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinTest {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		
		RandomIntSum task = new RandomIntSum(8);
		
		long sum = pool.invoke(task);
		System.out.println("Sum is "+sum);
	}
}
