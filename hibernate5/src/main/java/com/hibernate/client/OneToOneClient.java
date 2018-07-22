package com.hibernate.client;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.hibernate.domain.Address;
import com.hibernate.domain.Email;
import com.hibernate.domain.Employee;
import com.hibernate.util.HibernateUtil;

public class OneToOneClient {

	public static void main(String[] args) {
		
		
		
		Employee emp1 = new Employee();
	//	emp1.setId(new Long(1));
		emp1.setFirst_name("Rahul1");
		emp1.setLast_name("Kumar");
		emp1.setSalary(new BigDecimal(34000));
		
		Address address = new Address();
		address.setCity("Ranchi");
		address.setState("Jharkhand");
		address.setStreet("Bariatu");
		address.setZipcode("834009");
	
		emp1.setAddress(address);
		address.setEmployee(emp1);
		
		Email email_1 = new Email();
		email_1.setEmail("rahul11@gmail.com");
		email_1.setEmployee(emp1);
		Email email_2 = new Email();
		email_2.setEmail("rahul12@gmail.com");
		email_2.setEmployee(emp1);
		
		Set<Email> emails = new HashSet<Email>();
		emails.add(email_1);
		emails.add(email_2);
		
		emp1.setEmails(emails);
	
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	/*	Long empid =  (Long) session.save(emp1);
		session.save(email_1);
		session.save(email_2);
	*/	
		Employee emp = session.load(Employee.class, new Long(1));
		
	//	Employee emp2 = session.load(Employee.class, new Long(1));
		System.out.println(emp);
		System.out.println(emp.getAddress());
		System.out.println(emp.getEmails());
	//	System.out.println(emp2);
	//	System.out.println(emp.getAddress());
	//	System.out.println(emp2.getAddress());
		
	//	System.out.println(empid);
		session.getTransaction().commit();
		session.close();

	}
}
