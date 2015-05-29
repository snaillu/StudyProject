package org.appress.hibernate.ch02;

import java.util.List;

import org.appress.hibernate.ch02.domain.Message;
import org.hibernate.Session;
import org.hibernate.tutorial.util.HibernateUtil;

public class MessageManager {
	public static void main(String[] args) {
		queryMessage();
	}
	
	private static void saveMessage(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String msg = "This is today msg.";
		Message message = new Message(msg);
		session.save(message);
		
		session.getTransaction().commit();
	}
	
	private static void queryMessage(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List messages = session.createQuery("select m from Message m").list();
		System.out.println("message length:"+messages.size());
	}
}
