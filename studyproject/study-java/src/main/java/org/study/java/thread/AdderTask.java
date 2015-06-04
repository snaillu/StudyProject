package org.study.java.thread;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Phaser;

public class AdderTask extends Thread {
	private Phaser phaser;
	private String taskName;
	private List<Integer> list;
	private static Random rd = new Random();
	
	public AdderTask(String taskName,Phaser phaser,List<Integer> list){
		this.taskName = taskName;
		this.phaser = phaser;
		this.list = list;
	}

	@Override
	public void run() {
		do{
			int num = rd.nextInt(10)+1;
			System.out.println(taskName+" added "+num);
			list.add(num);
			
			phaser.arriveAndAwaitAdvance();
		}while(!phaser.isTerminated());
	}
}
