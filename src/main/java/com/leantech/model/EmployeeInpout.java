package com.leantech.model;

import java.io.Serializable;

public class EmployeeInpout implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -937868651784926470L;
		
	private Long salary;
	private String position;
    private String name;
    private String lastName;
    private String address;
    private String cellPhone;
    private String cityName;
	public EmployeeInpout() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeInpout(Long salary, String position, String name, String lastName, String address, String cellPhone,
			String cityName) {
		super();
		this.salary = salary;
		this.position = position;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.cellPhone = cellPhone;
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "EmployeeInpout [salary=" + salary + ", position=" + position + ", name=" + name + ", lastName="
				+ lastName + ", address=" + address + ", cellPhone=" + cellPhone + ", cityName=" + cityName + "]";
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
    
    
}
