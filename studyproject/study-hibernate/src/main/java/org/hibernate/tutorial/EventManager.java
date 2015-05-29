package org.hibernate.tutorial;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.domain.Person;
import org.hibernate.tutorial.util.HibernateUtil;

public class EventManager {
	public static void main(String[] args) {
		EventManager mgr = new EventManager();
		//mgr.createAndStoreEvent("This is notice from snail.", new Date());
		//mgr.createAndStorePerson(10, "Tom", "Jackson");
		//mgr.addPersonToEvent(1L, 1L);
		mgr.addEmailToPerson(1L, "luqu@live.cn");
		
		HibernateUtil.getSessionFactory().close();
	}
	
	private void addEmailToPerson(Long personId,String emailAddress){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Person aPerson = (Person)session.load(Person.class, personId);
		aPerson.getEmailAddresses().add(emailAddress);
		session.getTransaction().commit();
	}
	
	private void addPersonToEvent(Long personId,Long eventId){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Person person = (Person)session.load(Person.class, personId);
		Event event = (Event)session.load(Event.class, eventId);
		person.getEvents().add(event);
		
		session.getTransaction().commit();
	}
	
	private void createAndStoreEvent(String title,Date theDate){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Event event = new Event();
		event.setDate(theDate);
		event.setTitle(title);
		session.save(event);
		
		session.getTransaction().commit();
	}
	
	private void createAndStorePerson(int age,String firstName,String lastName){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Person person = new Person();
		person.setAge(age);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		session.save(person);
		
		session.getTransaction().commit();
	}
}
