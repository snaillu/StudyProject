package org.study.java.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class LatchHelperService extends Thread {
	private int ID;
	private CountDownLatch latch;
	private Random rd = new Random();
	
	public LatchHelperService(int ID,CountDownLatch latch){
		this.ID = ID;
		this.latch = latch;
	}

	@Override
	public void run() {
		try{
			int startupTime = rd.nextInt(30)+1;
			System.out.println("Service #"+ID+" starting in "+startupTime+" seconds...");
			Thread.sleep(startupTime*1000);
			System.out.println("Service #"+ID +" has started...");
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			this.latch.countDown();
		}
	}
	
	
}
