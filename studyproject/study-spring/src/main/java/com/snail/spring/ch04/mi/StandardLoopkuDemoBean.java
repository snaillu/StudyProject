package com.snail.spring.ch04.mi;

public class StandardLoopkuDemoBean implements DemoBean {
	private MyHelper myHelper;
	
	public void setMyHelper(MyHelper myHelper){
		this.myHelper = myHelper;
	}
	
	public MyHelper getMyHelper() {
		return this.myHelper;
	}

	public void someOperation() {
		myHelper.doSomethingHelpful();
	}
}
