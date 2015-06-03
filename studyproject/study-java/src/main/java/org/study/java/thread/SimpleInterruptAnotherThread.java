package org.study.java.thread;

public class SimpleInterruptAnotherThread {
	public static void run(){
		int counter = 0;
		while(!Thread.interrupted()){
			counter++;
		}
		System.out.println("Counter:"+counter);
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(SimpleInterruptAnotherThread::run);
		t.start();
		
		try{
			Thread.currentThread().sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		t.interrupt();
	}
}
