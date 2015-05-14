package com.snail.spring.ch04;

import org.springframework.stereotype.Service;

@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

	public String getMessage() {
		return "Hello World.";
	}
}
