package org.study.java.thread;

public class CallTracker {
	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	
	public static void call(){
		int counter = 0;
		
		Integer counterObject = threadLocal.get();
		if(counterObject==null){
			counter = 1;
		}else{
			counter = counterObject.intValue();
			counter++;
		}
		
		threadLocal.set(counter);
		
		String threadName = Thread.currentThread().getName();
		System.out.println("Call counter for "+threadName+" = "+counter);
	}
}
