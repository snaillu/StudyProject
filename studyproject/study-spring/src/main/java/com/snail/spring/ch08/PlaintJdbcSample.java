package com.snail.spring.ch08;

import java.util.List;

import com.snail.spring.ch08.dao.ContactDao;
import com.snail.spring.ch08.dao.plain.PlainContactDao;
import com.snail.spring.ch08.domain.Contact;

public class PlaintJdbcSample {
	private static ContactDao dao = new PlainContactDao();
	
	public static void main(String[] args) {
		System.out.println("Listing initial contact data:");
		listAllContacts();
		
		System.out.println();
		
		System.out.println("Insert a new contact");
		Contact contact = new Contact();
		contact.setFirstName("snails");
		contact.setLastName("merrys");
		dao.insert(contact);
		System.out.println("List contact after contact create:");
		listAllContacts();
		
		System.out.println();
		dao.delete(contact.getId());
		System.out.println("listing contacts after delete new contact:");
		listAllContacts();
	}
	
	private static void listAllContacts(){
		List<Contact> contacts = dao.findAll();
		
		for(Contact contact:contacts)
			System.out.println(contact);
	}
}
