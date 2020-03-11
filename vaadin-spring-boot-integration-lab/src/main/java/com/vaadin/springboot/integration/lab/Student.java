package com.vaadin.springboot.integration.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	@Autowired
	private Address address;
	
	public String showInfo() {
		return this.address.getAddress();
	}
}
