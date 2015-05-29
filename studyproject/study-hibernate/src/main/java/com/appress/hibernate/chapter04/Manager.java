package com.appress.hibernate.chapter04;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.tutorial.util.HibernateUtil;

import com.appress.hibernate.chapter04.domain.AudioDisc;
import com.appress.hibernate.chapter04.domain.Disc;
import com.appress.hibernate.chapter04.domain.VideoDisc;

public class Manager {
	public static void main(String[] args) {
		Manager m = new Manager();
		//m.addDis();
		m.queryDisc();
	}
	
	public void queryDisc(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Disc d");
		List<Disc> list = query.list();
		
		Iterator<Disc> it = list.iterator();
		while(it.hasNext()){
			Disc dc = it.next();
			System.out.println(dc +"   "+dc.getClass().getName());
		}
	}
	
	public void addDis(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Disc disc = new Disc();
		disc.setName("Blank CDR");
		disc.setPrice(199);
		
		session.save(disc);
		
		VideoDisc videoDisc = new VideoDisc();
		videoDisc.setName("Blazing Saddles");
		videoDisc.setPrice(1499);
		videoDisc.setDirector("Mel Brooks");
		videoDisc.setLanguage("English");
		session.save(videoDisc);
		
		AudioDisc audioDisc = new AudioDisc();
		audioDisc.setName("Grace Under Pressure");
		audioDisc.setPrice(999);
		audioDisc.setArtist("Rush");
		audioDisc.setTrackCount(9);
		session.save(audioDisc);
		
		session.getTransaction().commit();
	}
}
