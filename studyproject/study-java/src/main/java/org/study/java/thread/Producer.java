package org.study.java.thread;

import java.util.Random;

public class Producer extends Thread {
	private Buffer buffer;
	
	public Producer(Buffer buffer){
		this.buffer = buffer;
	}

	@Override
	public void run() {
		Random rd = new Random();
		while(true){
			int n = rd.nextInt();
			buffer.produce(n);
		}
	}
	
	
}
