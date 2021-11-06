package com.la.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "user")

public class User {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long Id;

	@Column
	private String FirstName;

	@Column
	private String LastName;

	@Column
	private String UserId;

	@Column
	private String password;

	@Column
	private long User_Type_Id;

	public User() {

	}

	public User(long id, String firstName, String lastName, String userId, String password, long user_Type_Id) {
		super();
		Id = id;
		FirstName = firstName;
		LastName = lastName;
		UserId = userId;
		this.password = password;
		User_Type_Id = user_Type_Id;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getUser_Type_Id() {
		return User_Type_Id;
	}

	public void setUser_Type_Id(long user_Type_Id) {
		User_Type_Id = user_Type_Id;
	}

}
