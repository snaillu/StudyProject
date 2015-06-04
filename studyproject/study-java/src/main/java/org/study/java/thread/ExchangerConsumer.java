package org.study.java.thread;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class ExchangerConsumer extends Thread {
	private Exchanger<ArrayList<Integer>> exchanger;
	private ArrayList<Integer> buffer = new ArrayList<Integer>();
	private Random rd = new Random();
	
	public ExchangerConsumer(Exchanger<ArrayList<Integer>> exchanger){
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		while(true){
			try{
				System.out.println("Consumer is waiting to exchange the data...");
				
				
				buffer = exchanger.exchange(buffer);
				System.out.println("Consumer has received:"+buffer);
				System.out.println("Consumer is emptying data form the buffer...");
				
				int sleepTime = rd.nextInt(20)+1;
				Thread.sleep(sleepTime*1000);
				
				this.emptyBuffer();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	public void emptyBuffer(){
		buffer.clear();
	}
	
	
}
