package com.snail.spring.ch08;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.snail.spring.ch08.dao.ContactDao;
import com.snail.spring.ch08.domain.Contact;

public class Client {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:/springconfig/applicationContext.xml");
		ctx.refresh();
		
		ContactDao dao = ctx.getBean("contactDao",ContactDao.class);
		System.out.println(dao.findFirstNameById(2l));
		
		
		List<Contact> contacts = dao.findWithAllDetail();
		for(Contact contact:contacts){
			System.out.println(contact);
		}
		
	}
}
