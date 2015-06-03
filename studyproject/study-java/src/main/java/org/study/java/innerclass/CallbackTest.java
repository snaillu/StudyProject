package org.study.java.innerclass;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class CallbackTest {
	private ArrayList<Callable> callableList = new ArrayList<Callable>();
	
	private void callback() throws Exception{
		int count = this.callableList.size();
		for(int i=0;i<count;i++){
			Callable c = this.callableList.get(i);
			c.call();
		}
	}
	
	public void register(Callable c){
		this.callableList.add(c);
	}
	
	public Callable generatedCallable(final int no){
		Callable c = new Callable(){
			public Object call() throws Exception {
				System.out.println("Called#"+no);
				
				return null;
			}
		};
		
		return c;
	}
	
	public static void main(String[] args) throws Exception {
		CallbackTest cbt = new CallbackTest();
		
		Callable c1 = cbt.generatedCallable(1);
		cbt.register(c1);
		Callable c2 = cbt.generatedCallable(2);
		cbt.register(c2);
		Callable c3 = cbt.generatedCallable(3);
		cbt.register(c3);
		
		cbt.callback();
	}
}
