package com.snail.springrecips.user.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserService {
	private final static Log log = LogFactory.getLog(UserService.class);
	
	public void get(long id){
		log.info("getUser method...");
	}
	
	public void save(String name,String pwd){
		log.info("save method...");
	}
	
	public void delete(long id) throws Exception{
		log.info("delete method...");
		throw new Exception("spring aop throwadvice demo.");
	}
}
