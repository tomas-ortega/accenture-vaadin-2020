package com.vaadin.springboot.lab;

import org.springframework.stereotype.Component;

@Component
public class Address {
	private String address = "Calle Chikito Jarls!";
	
	public String getAddress() {
		return this.address;
	}
}
