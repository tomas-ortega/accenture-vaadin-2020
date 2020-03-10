package com.vaadin.spring.lab;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args ) {
    	ApplicationContext applicationContext =
    			new AnnotationConfigApplicationContext(MyConfiguration.class);
      
      Student singleStudent = 
    		  (Student) applicationContext.getBean("student_bean");
      
      System.out.println("ADDRESS STUDENT: " + singleStudent.getAddress().getAddress());
    }
    
    public static void test() {
    	List<String> myStringList = new ArrayList<>();
    	myStringList.add("A");
    	myStringList.add("B");
    	myStringList.add("C");
    	
    	
    	
    	myStringList.forEach(singleString -> {
    		String myString = null;
    		
    		myString = singleString;
    		
    		//safsafsdfasfd
    	});
    }
}
