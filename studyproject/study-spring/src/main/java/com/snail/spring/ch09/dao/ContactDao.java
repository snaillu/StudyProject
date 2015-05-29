package com.snail.spring.ch09.dao;

import java.util.List;

import com.snail.spring.ch09.domain.Contact;

public interface ContactDao {
	public List<Contact> findAll();
	public List<Contact> findAllWithDetail();
	public Contact findById(Long id);
	public Contact save(Contact contact);
	public Contact delete(Contact contact);
}
