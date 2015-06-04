package org.study.java.thread;

import java.util.Random;

public class CallTrackerTest {
	public static void main(String[] args) {
		new Thread(CallTrackerTest::run).start();
		new Thread(CallTrackerTest::run).start();
	}
	
	public static void run(){
		Random random = new Random();
		
		int counter = random.nextInt(5)+1;
		System.out.println(Thread.currentThread().getName()+" generated counter:"+counter);
		
		for(int i=0;i<counter;i++){
			CallTracker.call();
		}
	}
}
