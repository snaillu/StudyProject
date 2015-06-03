package org.study.java.thread;

public class LetMeSleep {
	public static void main(String[] args) {
		try{
			System.out.println("I am going to sleep for 5 seconds.");
			Thread.sleep(5000);
			System.out.println("I woke up.");
		}catch(Exception e){
			System.out.println("Someone interrupted me in my sleep.");
		}
		
		System.out.println("I am done.");
	}
}
