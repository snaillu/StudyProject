package com.appress.hibernate.chapter12;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.hibernate.tutorial.util.HibernateUtil;

import com.appress.hibernate.chapter02.domain.UserInfo;

public class Manager {
	public static void main(String[] args) {
		test2LCache();
	}
	
	public static void queryUserInfo(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		UserInfo user1 = (UserInfo)session.get(UserInfo.class, 100003L);
		UserInfo user2 = (UserInfo)session.get(UserInfo.class, 100003L);
		UserInfo user3 = (UserInfo)session.get(UserInfo.class, 100004L);
		System.out.println("query is ok.");
	}
	
	
	public static void test2LCache(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Statistics stats = sf.getStatistics();
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		
		UserInfo user = new UserInfo();
		user.setName("snail");
		user.setAge(28L);
		user.setEmail("luqu@live.cn");
		
		session.persist(user);
		session.getTransaction().commit();
		
		sf.getCache().evictAllRegions();
		
		session = sf.openSession();
		session.beginTransaction();
		
		UserInfo u1 = (UserInfo)session.byId(UserInfo.class).load(user.getUserId());
		UserInfo u2 = (UserInfo)session.byId(UserInfo.class).load(user.getUserId());
		
		System.out.println("u1==user:"+(u1==user));
		
		session.getTransaction().commit();
		
		System.out.println("secondLevelPutCount="+stats.getSecondLevelCachePutCount());
	}
}
