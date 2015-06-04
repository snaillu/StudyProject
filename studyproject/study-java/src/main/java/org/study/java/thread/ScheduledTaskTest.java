package org.study.java.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskTest {
	public static void main(String[] args) {
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(3);
		
		ScheduledTask task1 = new ScheduledTask(1);
		ScheduledTask task2 = new ScheduledTask(2);
		
		exec.schedule(task1, 2, TimeUnit.SECONDS);
		exec.scheduleAtFixedRate(task2, 5, 10, TimeUnit.SECONDS);
		
		
		try{
			TimeUnit.SECONDS.sleep(60);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		exec.shutdown();
	}
}
