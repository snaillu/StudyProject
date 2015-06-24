package org.study.designpattern.decorator;

public class Decotor implements Component {
	private Component component;
	
	public Decotor(Component component){
		this.component = component;
	}
	
	public Decotor(){
		
	}
	
	public void operation() {
		component.operation();
		System.out.println("Decotor operation executing... add something...");
	}

}
