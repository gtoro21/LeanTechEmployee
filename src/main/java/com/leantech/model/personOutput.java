package com.leantech.model;

import java.io.Serializable;


public class personOutput implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1603167531783237080L;
	private String name;
    private String lastName;
    private String address;   
    private String cellPhone;
    private String cityName;
	public personOutput() {
		super();
		// TODO Auto-generated constructor stub
	}
	public personOutput(String name, String lastName, String address, String cellPhone, String cityName) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.cellPhone = cellPhone;
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "personOutput [name=" + name + ", lastName=" + lastName + ", address=" + address + ", cellPhone="
				+ cellPhone + ", cityName=" + cityName + "]";
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
