package org.study.java.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTaskTest {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(3);
		
		CallableTask task = new CallableTask(2,3);
		
		Future<Integer> submittedTask = exec.submit(task);
		
		try{
			Integer result = submittedTask.get();
			System.out.println("Task's total sleep time:"+ result+" seconds.");
		}catch(ExecutionException e){
			System.out.println("Error in executing the task.");
		}catch(InterruptedException e){
			System.out.println("Task execution has been interrupted.");
		}
		
		exec.shutdown();
	}
}
