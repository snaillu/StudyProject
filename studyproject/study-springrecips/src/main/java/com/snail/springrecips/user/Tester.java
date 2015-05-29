package com.snail.springrecips.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import com.snail.springrecips.user.service.UserService;
import com.snail.springrecips.utils.SpringUtils;

public class Tester {
	private final static Log log = LogFactory.getLog(Tester.class);
	
	public static void main(String[] args) {
		ApplicationContext cxt = SpringUtils.getContext();
		
		UserService service = (UserService)cxt.getBean("userService");
		
		service.get(1L);
		service.save("snail", "12");
		
		try {
			service.delete(2L);
		} catch (Exception e) {
			log.warn("exception occur "+e.getMessage());
		}
	}
}
