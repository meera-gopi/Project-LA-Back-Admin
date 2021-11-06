package com.la.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "classes")

public class Classes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6540884104788227886L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long Class_Id;

	@Column
	private String Class_Name;

	@Column
	private long Sub_Id;

	@Column
	private long Teacher_Id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Sub_Id", referencedColumnName = "Id", insertable = false, updatable = false)
	private Subject sub;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Teacher_Id", referencedColumnName = "Id", insertable = false, updatable = false)
	private Teacher tch;

	@Column
	private String Start_Time;

	@Column
	private String End_Time;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cls", cascade = CascadeType.ALL)
	// @JoinColumn(name="Id",insertable = false, updatable = false)
	private Set<Student> std;

	public Classes() {
		super();
	}

	public long getClass_Id() {
		return Class_Id;
	}

	public void setClass_Id(long class_Id) {
		Class_Id = class_Id;
	}

	public String getClass_Name() {
		return Class_Name;
	}

	public void setClass_Name(String class_Name) {
		Class_Name = class_Name;
	}

	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
	}

	public Teacher getTch() {
		return tch;
	}

	public void setTch(Teacher tch) {
		this.tch = tch;
	}

	public String getStart_Time() {
		return Start_Time;
	}

	public void setStart_Time(String start_Time) {
		Start_Time = start_Time;
	}

	public String getEnd_Time() {
		return End_Time;
	}

	public void setEnd_Time(String end_Time) {
		End_Time = end_Time;
	}

	public Set<Student> getStd() {
		return std;
	}

	public void setStd(Set<Student> std) {
		this.std = std;
	}

	public long getSub_Id() {
		return Sub_Id;
	}

	public void setSub_Id(long sub_Id) {
		Sub_Id = sub_Id;
	}

	public long getTeacher_Id() {
		return Teacher_Id;
	}

	public void setTeacher_Id(long teacher_Id) {
		Teacher_Id = teacher_Id;
	}

}
