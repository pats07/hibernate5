package com.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Address {

	@Id
	@GeneratedValue( generator = "gen")
	@GenericGenerator( name = "gen", strategy="foreign",
					   parameters = @Parameter( name = "property", value = "employee"))
	@Column(name = "id")
	private long id;

	@Column(name = "street_name")
	private String street;
	
	@Column(name = "city_name")
	private String city;
	
	@Column(name = "state_name")
	private String state;
	
	@Column(name = "zipcode")
	private String zipcode;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", zipcode=" + zipcode + ", employee="
				+ employee + "]";
	}

	
}
