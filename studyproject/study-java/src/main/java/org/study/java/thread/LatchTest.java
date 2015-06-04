package org.study.java.thread;

import java.util.concurrent.CountDownLatch;

public class LatchTest {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2);
		
		LatchMainService ms = new LatchMainService(latch);
		ms.start();
		
		for(int i=1;i<=2;i++){
			LatchHelperService lhs = new LatchHelperService(i,latch);
			lhs.start();
		}
	}
}
