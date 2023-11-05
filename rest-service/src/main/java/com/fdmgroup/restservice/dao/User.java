package com.fdmgroup.restservice.dao;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

//@JsonIgnoreProperties({"name", "birth_Sdate"})
//@JsonFilter("IdFilter")
@Entity(name="user_details")
public class User {

	@Id
	@GeneratedValue
	@PositiveOrZero
//	@JsonIgnore // static filtering
	private long id;
	
	@Size(min=2, message="name must have at least 2 characters")
	private String name;
	
	@Past(message="birthdate must be in the past")
//	@JsonProperty("birth_date")
	private LocalDate birthdate;
	
	public User() {
		
	}
	
	public User(final long id, final String name, final LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
}
