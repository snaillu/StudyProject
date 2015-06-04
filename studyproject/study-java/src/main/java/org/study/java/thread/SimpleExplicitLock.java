package org.study.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleExplicitLock {
	private Lock myLock = new ReentrantLock();
	
	public void updateResource(){
		myLock.lock();
		
		try{
			System.out.println("do something...");
		}finally{
			myLock.unlock();
		}
	}
}
