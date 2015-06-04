package org.study.java.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MeetAtBarrier extends Thread {
	private CyclicBarrier barrier;
	private int ID;
	private static Random rd = new Random();
	
	public MeetAtBarrier(int ID,CyclicBarrier barrier){
		this.ID = ID;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try{
			int workTime = rd.nextInt(30)+1;
			System.out.println("Thread #"+ID+" is going to work for "+ workTime+" seconds");
			
			Thread.sleep(workTime*1000);
			
			System.out.println("Thread #"+ID +"　 is waiting at the barrier...");
			this.barrier.await();
			
			System.out.println("Thread #"+ID+" passed the barrier...");
		}catch(InterruptedException e){
			e.printStackTrace();
		}catch(BrokenBarrierException e){
			System.out.println("Barrier is broken...");
		}
	}
	
	public static void main(String[] args) {
		Runnable barrierAction = ()->System.out.println("We are all together. It's party time...");
		
		CyclicBarrier barrier = new CyclicBarrier(3,barrierAction);
		for(int i=1;i<=3;i++){
			MeetAtBarrier t = new MeetAtBarrier(i,barrier);
			t.start();
		}
	}
}
