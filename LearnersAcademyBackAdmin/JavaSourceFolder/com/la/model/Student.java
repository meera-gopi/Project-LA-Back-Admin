package com.la.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5533894846221392191L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long Id;

	@Column
	private String First_Name;

	@Column
	private String Last_Name;

	@Column
	private long Class_Id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Class_Id",insertable = false, updatable = false)
	private Classes cls;

	public Student() {
		super();
	}

	public Student(long id, String first_Name, String last_Name, long class_Id) {
		super();
		Id = id;
		First_Name = first_Name;
		Last_Name = last_Name;
		// Class_Id = class_Id;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public Classes getCls() {
		return cls;
	}

	public void setCls(Classes cls) {
		this.cls = cls;
	}

	public long getClass_Id() {
		return Class_Id;
	}

	public void setClass_Id(long class_Id) {
		Class_Id = class_Id;
	}

}
