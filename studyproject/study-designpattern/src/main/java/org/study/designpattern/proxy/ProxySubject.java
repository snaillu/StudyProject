package org.study.designpattern.proxy;

public class ProxySubject extends Subject {
	private RealSubject realSubject;
	
	public ProxySubject(){}
	
	@Override
	public void request() {
		preRequest();
		
		if(realSubject==null){
			realSubject = new RealSubject();
		}
		realSubject.request();
		postRequest();
	}
	
	private void preRequest(){
		System.out.println("preRequest--do something...");
	}
	
	private void postRequest(){
		System.out.println("postRequest--do something after...");
	}

}
