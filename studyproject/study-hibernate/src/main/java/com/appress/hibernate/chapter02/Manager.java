package com.appress.hibernate.chapter02;

import org.hibernate.Session;
import org.hibernate.tutorial.util.HibernateUtil;

import com.appress.hibernate.chapter02.domain.Employee;
import com.appress.hibernate.chapter02.domain.UserInfo;

public class Manager {
	public static void main(String[] args) {
		Manager um = new Manager();
		//um.addUser("snail", 27, "snail@gmail.com");
		//um.addEmployee(10L,2000L,"snail");
		um.queryEmployee(10L, 2000L);
	}
	
	public void queryEmployee(Long department,Long idCard){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Employee employeeId = new Employee();
		employeeId.setDepartment(department);
		employeeId.setIdCard(idCard);
		
		Employee employee = (Employee)session.get(Employee.class, employeeId);
		
		System.out.println("UserName="+employee.getName());
	}
	
	public void addEmployee(Long deparment,Long idCard,String name){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Employee employee = new Employee(deparment,idCard,name);
		session.save(employee);
		session.getTransaction().commit();
		
		System.out.println("employee created.");
	}
	
	public void addUser(String name,int age,String email){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		UserInfo user = new UserInfo(name,new Long(age),email);
		session.save(user);
		session.getTransaction().commit();
		
		System.out.println("UserId="+user.getUserId());
	}
}
