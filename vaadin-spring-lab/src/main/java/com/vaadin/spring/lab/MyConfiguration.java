package com.vaadin.spring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfiguration {

	@Bean(name="student_bean")
	@Scope(value="singleton")
	public Student getStudent() {
		return new Student();
	}
	
	@Bean
	public Address getAddress() {
		return new Address();
	}
}
