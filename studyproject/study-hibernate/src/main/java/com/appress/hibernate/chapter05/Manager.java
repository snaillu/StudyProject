package com.appress.hibernate.chapter05;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.tutorial.util.HibernateUtil;

import com.appress.hibernate.chapter05.domain.Book;
import com.appress.hibernate.chapter05.domain.ReaderError;

public class Manager {
	public static void main(String[] args) {
		Manager m = new Manager();
		m.addBookAndError();
	}
	
	
	public void addBookAndError(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Book book = new Book();
		book.setTitle("Mongodb");
		session.persist(book);
		
		ReaderError error = new ReaderError();
		error.setBook(book);
		error.setContent("The chapter one is too simple.");
		error.setCreateDate(new Date());
		session.persist(error);
		
		session.getTransaction().commit();
		
	}
}
