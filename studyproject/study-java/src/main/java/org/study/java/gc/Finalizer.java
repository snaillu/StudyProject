package org.study.java.gc;

public class Finalizer {
	private int id;
	
	public Finalizer(int id){
		this.id = id;
	}
	
	public void finalize(){
		if(id%100==0){
			System.out.println("finalize() called for "+id);
		}
	}
	
	public static void main(String[] args) {
		for(int i=1;i<=500000;i++){
			new Finalizer(i);
		}
		
		System.gc();
	}
}
