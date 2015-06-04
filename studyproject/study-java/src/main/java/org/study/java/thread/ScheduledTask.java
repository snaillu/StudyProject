package org.study.java.thread;

import java.time.LocalDateTime;

public class ScheduledTask implements Runnable {
	private int taskId;
	
	public ScheduledTask(int taskId){
		this.taskId = taskId;
	}
	
	@Override
	public void run() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println("Task #"+this.taskId+" ran at "+currentDateTime);
	}
}
