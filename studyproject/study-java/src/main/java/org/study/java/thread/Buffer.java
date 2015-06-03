package org.study.java.thread;

public class Buffer {
	private int data;
	private boolean empty;
	
	public Buffer(){
		this.empty = false;
	}
	
	public synchronized void produce(int newData){
		while(!this.empty){
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		this.data = newData;
		
		//set the empty flag to false, so the consumer may consume the data
		this.empty = false;
		
		//Notify the waiting consumer in the wait set
		this.notify();
		
		System.out.println("Produced:"+newData);
	}
	
	public synchronized int consume(){
		while(this.empty){
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		this.empty = true;
		
		//Notify the waiting producer in the wait set
		this.notify();
		
		System.out.println("Consumed:"+data);
		
		return data;
	}
}
