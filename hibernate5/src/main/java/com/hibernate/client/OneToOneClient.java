package com.hibernate.client;

import java.math.BigDecimal;

import org.hibernate.Session;

import com.hibernate.domain.Address;
import com.hibernate.domain.Employee;
import com.hibernate.util.HibernateUtil;

public class OneToOneClient {

	public static void main(String[] args) {
		
		
		
		Employee emp1 = new Employee();
	//	emp1.setId(new Long(1));
		emp1.setFirst_name("Rahul");
		emp1.setLast_name("Kumar");
		emp1.setSalary(new BigDecimal(34000));
		
		Address address = new Address();
		address.setCity("Ranchi");
		address.setState("Jharkhand");
		address.setStreet("Bariatu");
		address.setZipcode("834009");
	
		emp1.setAddress(address);
		address.setEmployee(emp1);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	//	Long empid =  (Long) session.save(emp1);
		Employee emp = session.load(Employee.class, new Long(1));
		System.out.println(emp);
	//	System.out.println(emp.getAddress());
		session.getTransaction().commit();
		session.close();
			
	}
}
