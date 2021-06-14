package com.leantech.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.sun.istack.NotNull;

@Entity
@Table(name = "person")
public class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8436060161363382917L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	
	@NotNull
    @Column(name= "name")
    private String name;

    @NotNull
    @Column(name= "last_name")
    private String lastName;
    
    @NotNull
    @Column(name= "address")
    private String address;
    
    @NotNull
    @Column(name= "cell_phone")
    private String cellPhone;
    
    @NotNull
    @Column(name= "city_name")
    private String cityName;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String lastName, String address, String cellPhone, String cityName) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.cellPhone = cellPhone;
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", address=" + address
				+ ", cellPhone=" + cellPhone + ", cityName=" + cityName + "]";
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
