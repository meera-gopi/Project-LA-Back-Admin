package com.la.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long Id;

	@Column
	private String First_Name;

	@Column
	private String Last_Name;

	@OneToMany(mappedBy = "tch")
	private Set<Classes> cls;

	public Teacher() {
		super();
	}

	public Teacher(long id, String first_Name, String last_Name) {
		super();
		Id = id;
		First_Name = first_Name;
		Last_Name = last_Name;
	}

	public Teacher(String first_Name, String last_Name) {
		super();

		First_Name = first_Name;
		Last_Name = last_Name;
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

	public Set<Classes> getCls() {
		return cls;
	}

	public void setCls(Set<Classes> cls) {
		this.cls = cls;
	}

}
