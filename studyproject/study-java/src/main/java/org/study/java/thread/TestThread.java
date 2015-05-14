package org.study.java.thread;

public class TestThread implements Runnable {

	public void run() {
		for(int i=0;i<30;i++){
			System.out.println(Thread.currentThread().getName()+"--"+i);
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new TestThread());
		Thread t2 = new Thread(new TestThread());
		
		t1.start();
		t2.start();
	}

}
