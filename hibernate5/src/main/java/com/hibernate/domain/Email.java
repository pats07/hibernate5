package com.hibernate.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Emp_email")
@Access(value = AccessType.FIELD)
public class Email {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "email")
	private String email;

	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Email [id=" + id + ", email=" + email + ", employee="
				+ employee + "]";
	}

	
}
