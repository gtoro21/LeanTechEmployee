package com.leantech.model;

import java.io.Serializable;



public class EmployeeLess implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -6894458281750234982L;
	
	private long id;
	private Long salary;
	private personOutput person;
	public EmployeeLess() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeLess(long id, Long salary, personOutput person) {
		super();
		this.id = id;
		this.salary = salary;
		this.person = person;
	}
	@Override
	public String toString() {
		return "EmployeeLess [id=" + id + ", salary=" + salary + ", person=" + person + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public personOutput getPerson() {
		return person;
	}
	public void setPerson(personOutput person) {
		this.person = person;
	} 		
	
	





}
