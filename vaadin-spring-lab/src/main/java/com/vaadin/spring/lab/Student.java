package com.vaadin.spring.lab;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	private String studentName;
	
	@Autowired
	private Address address;
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
