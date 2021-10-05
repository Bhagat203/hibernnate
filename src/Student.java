package com.ty.hibernate.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public 	class Student implements Serializable{

	@Id
	private int rollno;
	private String name;
	private long phno ;
	private String standrad;
	public int getRollno() {
		return rollno;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", phno=" + phno + ", standrad=" + standrad + "]";
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public String getStandrad() {
		return standrad;
	}
	public void setStandrad(String standrad) {
		this.standrad = standrad;
	}
	
	
}
