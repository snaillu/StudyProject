package com.snail.spring.ch05.factory;

import java.security.MessageDigest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>,InitializingBean {
	private String algorithmName = "MD5";
	private MessageDigest messageDigest = null;
	
	public void afterPropertiesSet() throws Exception {
		messageDigest = MessageDigest.getInstance(algorithmName);
	}
	
	public void setAlgorithmName(String algorithmName){
		this.algorithmName = algorithmName;
	}

	public MessageDigest getObject() throws Exception {
		return messageDigest;
	}

	public Class<?> getObjectType() {
		return MessageDigest.class;
	}

	public boolean isSingleton() {
		return true;
	}

}
