package com.la.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subject")

public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long Id;

	@Column
	private String Sub_Name;

	@OneToOne(mappedBy = "sub")
	private Classes cls;

	public Subject() {
		super();
	}

	public Subject(long id, String sub_Name) {
		super();
		Id = id;
		Sub_Name = sub_Name;
	}

	public Subject(String sub_Name) {
		super();

		Sub_Name = sub_Name;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getSub_Name() {
		return Sub_Name;
	}

	public void setSub_Name(String sub_Name) {
		Sub_Name = sub_Name;
	}



}
