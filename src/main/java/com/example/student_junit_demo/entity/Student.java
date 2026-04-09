package com.example.student_junit_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int sid;
	private String sname;
	private String sschool;
	private String sphone;

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSschool() {
		return sschool;
	}

	public void setSschool(String sschool) {
		this.sschool = sschool;
	}

	public Student(int sid, String sname, String sschool, String sphone) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sschool = sschool;
		this.sphone = sphone;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
