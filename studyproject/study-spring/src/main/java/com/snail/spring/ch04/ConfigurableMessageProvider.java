package com.snail.spring.ch04;

public class ConfigurableMessageProvider implements MessageProvider {
	private String message;
	
	public ConfigurableMessageProvider(String message){
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

}
