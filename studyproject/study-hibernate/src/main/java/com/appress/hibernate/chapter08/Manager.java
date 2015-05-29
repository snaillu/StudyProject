package com.appress.hibernate.chapter08;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tutorial.util.HibernateUtil;

import com.appress.hibernate.chapter05.domain.Book;

public class Manager {
	public static void main(String[] args) {
		queryBookByCriteria();
	}
	
	public static void queryBookByCriteria(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Book.class);
		
		Criterion nameRest = Restrictions.eq("title", "Mongodb");
		criteria.add(nameRest);
		List books = criteria.list();
		
		Iterator<Book> it = books.iterator();
		while(it.hasNext()){
			Book b = it.next();
			System.out.println(b);
		}
	}
	
	public static List<Book> queryBookList(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Book book where book.title=:title");
		query.setParameter("title", "Mongodb");
		query.setFirstResult(0);
		query.setMaxResults(10);
		List<Book> list = query.list();
		System.out.println("size of book list:"+list.size());
		
		return list;
	}
	
	public static void queryBooks(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String sql = "from Book book where book.title='Pro Hibernate'";
		
		sql = "from Book book where book.title like '%Hiber%'";
		Query query = session.createQuery(sql);
		List books = query.list();
		
		Iterator<Book> it = books.iterator();
		while(it.hasNext()){
			Book b = it.next();
			System.out.println(b);
		}
	}
}
