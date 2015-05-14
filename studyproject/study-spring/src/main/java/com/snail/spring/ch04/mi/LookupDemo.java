package com.snail.spring.ch04.mi;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:springconfig/applicationContext.xml");
		ctx.refresh();
		
		DemoBean abstarctBean = (DemoBean)ctx.getBean("abstractLookupBean");
		DemoBean standardBean = (DemoBean)ctx.getBean("standardLookupBean");
		
		displayInfo(standardBean);
		displayInfo(abstarctBean);
	}
	
	public static void displayInfo(DemoBean bean){
		MyHelper helper1 = bean.getMyHelper();
		MyHelper helper2 = bean.getMyHelper();
		
		System.out.println("Helper Instance the Same?: "+(helper1==helper2));
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("lookupDemo");
		
		for(int i=0;i<100000;i++){
			MyHelper helper = bean.getMyHelper();
			helper.doSomethingHelpful();
		}
		
		stopWatch.stop();
		System.out.println("100000 gets took "+ stopWatch.getLastTaskTimeMillis()+"ms");
	}
}
