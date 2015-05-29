package com.snail.spring.ch08.dao;

import java.util.List;

import com.snail.spring.ch08.domain.Contact;

public interface ContactDao {
	public List<Contact> findAll();
	
	public List<Contact> findByFirstName(String name);
	
	public String findFirstNameById(Long id);
	
	public void insert(Contact contact);
	
	public void update(Contact contact);
	
	public void delete(Long contactId);
	
	public List<Contact> findWithAllDetail();
}
