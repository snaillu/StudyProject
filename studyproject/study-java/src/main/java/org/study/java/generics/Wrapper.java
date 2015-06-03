package org.study.java.generics;

public class Wrapper<T> {
	private T ref;
	
	public Wrapper(T ref){
		this.ref = ref;
	}

	public T getRef() {
		return ref;
	}

	public void setRef(T ref) {
		this.ref = ref;
	}
}
