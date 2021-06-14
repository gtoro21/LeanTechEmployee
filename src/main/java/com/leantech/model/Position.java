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
@Table(name = "position")
public class Position implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5891165777882605341L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	
	@NotNull
    @Column(name= "name")
    private String name;

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Position(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]";
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

	public Position(String name) {
		super();
		this.name = name;
	}

	
	
}
