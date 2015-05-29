package com.appress.hibernate.chapter11;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.tutorial.util.HibernateUtil;

import com.appress.hibernate.chapter02.domain.UserInfo;

public class Manager {
	
	public static void main(String[] args) {
		addUserBatch();
	}
	
	public static void addUserBatch(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.setCacheMode(CacheMode.IGNORE);
		
		long start = System.currentTimeMillis();
		for(int i=0;i<100000;i++){
			UserInfo u = new UserInfo("snail"+i,28L,"luqu@qq.com");
			if(i%100==0){
				session.flush();
				session.clear();
			}
			session.save(u);
		}
		
		System.out.println("time estimate:"+(System.currentTimeMillis()-start)+" ms");
		session.getTransaction().commit();
	}
	
	public static void removeAllUser(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<UserInfo> users = session.createQuery("select user from UserInfo user").list();
		System.out.println("before delete user count:"+users.size());
		
		session.createQuery("delete UserInfo").executeUpdate();
		
		users = session.createQuery("select user from UserInfo user").list();
		System.out.println("after delete user count:"+users.size());
		
		session.getTransaction().commit();
	}
}
