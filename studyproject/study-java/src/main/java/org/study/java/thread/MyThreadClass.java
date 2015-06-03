package org.study.java.thread;

public class MyThreadClass extends Thread {

	@Override
	public void run() {
		System.out.println("Hello Java Thread!");
	}
	
	public static void main(String[] args) {
		MyThreadClass c = new MyThreadClass();
		c.start();
		
		Runnable aRunnable = ()-> System.out.println("Hell,World!");
		Thread thread = new Thread(aRunnable);
		thread.start();
	}
}
