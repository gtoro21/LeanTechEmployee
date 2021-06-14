package com.leantech.model;

import java.io.Serializable;
import java.util.List;

public class positionListOutput implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -523838081895162777L;

	private long id;
	private String name;
	private List<EmployeeLess> employees;
	public positionListOutput() {
		super();
		// TODO Auto-generated constructor stub
	}
	public positionListOutput(long id, String name, List<EmployeeLess> employees) {
		super();
		this.id = id;
		this.name = name;
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "positionListOutput [id=" + id + ", name=" + name + ", employees=" + employees + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<EmployeeLess> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmployeeLess> employees) {
		this.employees = employees;
	}
	
	
}
