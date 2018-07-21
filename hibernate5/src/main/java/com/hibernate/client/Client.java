package com.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.domain.Employee;
import com.hibernate.util.HibernateUtil;


public class Client {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Employee emp = session.load(Employee.class, new Integer(1));
		System.out.println(emp);
		session.close();
		
	}
}
