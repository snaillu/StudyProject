package com.snail.spring.ch04.mi;

public abstract class AbstractLookupDemoBean implements DemoBean {
	public abstract MyHelper getMyHelper();
	
	public void someOperation(){
		getMyHelper().doSomethingHelpful();
	}
}
