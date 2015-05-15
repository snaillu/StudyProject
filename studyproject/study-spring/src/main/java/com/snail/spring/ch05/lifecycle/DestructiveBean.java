package com.snail.spring.ch05.lifecycle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBean implements InitializingBean {

	private InputStream is = null;
	private String filePath = null;
	
	
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initilizing Bean");
		if(filePath==null)
			throw new IllegalArgumentException("You must specify the filepath property of "+this.getClass().getName());
		
		is = new FileInputStream(filePath);
	}
	
	public void destroy(){
		System.out.println("Destroying Bean");
		if(is!=null){
			try{
				is.close();
				is = null;
			}catch(IOException ex){
				System.err.println("WARN: An IOException occurred when trying to cloes the InputStream.");
			}
		}
	}
	
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:springconfig/applicationContext.xml");
		ctx.refresh();
		
		DestructiveBean bean = (DestructiveBean)ctx.getBean("destructiveBean");
		
		System.out.println("Calling destroy()");
		ctx.destroy();
		System.out.println("Called destroy()");
	}

}
