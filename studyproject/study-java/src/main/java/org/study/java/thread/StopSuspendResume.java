package org.study.java.thread;

public class StopSuspendResume extends Thread {
	private volatile boolean keepRunning = true;
	private boolean suspend = false;
	
	public synchronized void stopThread(){
		this.keepRunning = false;
		this.notify();
	}
	
	public synchronized void suspendThread(){
		this.suspend = true;
	}
	
	public synchronized void resumeThread(){
		this.suspend = false;
		this.notify();
	}

	@Override
	public void run() {
		System.out.println("Thread started...");
		
		while(keepRunning){
			try{
				System.out.println("Going to sleep");
				Thread.sleep(1000);
				
				synchronized(this){
					while(suspend){
						System.out.println("Suspend...");
						this.wait();
						System.out.println("Resumed...");
					}
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println("Thread stopped...");
	}
	
	public static void main(String[] args) {
		StopSuspendResume t = new StopSuspendResume();
		
		t.start();
		
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		t.suspendThread();
		
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		t.resumeThread();
		
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		t.stopThread();
	}
	
}
