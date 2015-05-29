package com.snail.spring.ch09.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.snail.spring.ch09.dao.ContactDao;
import com.snail.spring.ch09.domain.Contact;

@Repository("contactDao")
@Transactional
public class ContactDaoImpl implements ContactDao {
	private Log log = LogFactory.getLog(ContactDaoImpl.class);
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Contact> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
	}

	public List<Contact> findAllWithDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	public Contact findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Contact save(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	public Contact delete(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
