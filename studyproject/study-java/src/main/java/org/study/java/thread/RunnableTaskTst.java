package org.study.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTaskTst {
	public static void main(String[] args) {
		final int THREAD_COUNT = 3;
		final int LOOP_COUNT = 3;
		final int TASK_COUNT = 5;
		
		ExecutorService exec = Executors.newFixedThreadPool(THREAD_COUNT);
		
		for(int i=1;i<=TASK_COUNT;i++){
			RunnableTask task = new RunnableTask(i,LOOP_COUNT);
			exec.submit(task);
		}
		
		exec.shutdown();
	}
}
