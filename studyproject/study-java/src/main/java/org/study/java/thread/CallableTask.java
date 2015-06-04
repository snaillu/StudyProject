package org.study.java.thread;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {
	private int taskId;
	private int loopCounter;
	private Random rd = new Random();
	
	public CallableTask(int taskId,int loopCounter){
		this.taskId = taskId;
		this.loopCounter = loopCounter;
	}
	
	
	@Override
	public Integer call() throws Exception {
		int totalSleepTime = 0;
		for(int i=0;i<=loopCounter;i++){
			try{
				int sleepTime = rd.nextInt(10)+1;
				System.out.println("Task #"+this.taskId+" - Iterator #"+i+" is going to sleep for "+sleepTime+" seconds.");
				Thread.sleep(sleepTime*1000);
				totalSleepTime = totalSleepTime + sleepTime;
			}catch(InterruptedException e){
				System.out.println("Task #"+this.taskId+" has interrupted.");
				throw e;
			}
		}
		return totalSleepTime;
	}
	
}
