package com.java8.pruebas;

import java.util.ArrayList;
import java.util.List;

import com.java8.pruebas.interfaces.IinterfaceReturnMethod;
import com.java8.pruebas.interfaces.IinterfaceWithOneParameter;
import com.java8.pruebas.interfaces.IinterfaceWithoutParameters;

public class App {
    public static void main( String[] args ) {
       //App.usingInterfaceLamdaWithoutParameters();
    	//App.usingInterfaceLambdaWithOneParameter();
    	//App.usingInterfaceReturnMethod();
    	App.iterateByStream();
    }
    
    public static void usingInterfaceLamdaWithoutParameters() {
    	IinterfaceWithoutParameters sayHelloByName =
    			() -> System.out.println("Hello Pako!");

    	sayHelloByName.sayHello();
    }
    
    public static void usingInterfaceLambdaWithOneParameter() {
    	String userName = "Pako!";
    	
    	IinterfaceWithOneParameter sayHelloByName =
    			(oneUser) -> System.out.println("Hello: " + oneUser);
    			
    	sayHelloByName.sayHello(userName);
    }
    
    public static void usingInterfaceReturnMethod() {
    	//Using java anonymous class 
    	IinterfaceReturnMethod stringConverterAnonymous =
    			new IinterfaceReturnMethod() {
					
					@Override
					public String stringConversion(String rawString) {
						return rawString.toUpperCase();
					}
				};
				
		System.out.println(stringConverterAnonymous.stringConversion("aaa"));
		
		//Using java lambda expression
		IinterfaceReturnMethod stringConverterLambda =
				incomingData -> {
					return incomingData.toUpperCase();
				};
				
		System.out.println(stringConverterLambda.stringConversion("bbb"));
    }
    
    public static void iterateByStream() {
    	List<String> cityList = new ArrayList<>(); 
    	cityList.add("Málaga");
    	cityList.add("Córdoba");
    	
    	cityList.forEach(singleCity -> System.out.println("CITY: " + singleCity));
    	
    	System.out.println("-----------------------");
    	
    	//For each
    	for (String singleCity: cityList) {
    		System.out.println("City: " + singleCity);
    	}
    	
    	System.out.println("-----------------------");
    	
    	//Stream
    	cityList.stream()
    			.filter((currentCity) -> currentCity.contains("M"))
    			.map(currentCity -> {
    				return currentCity = currentCity.toUpperCase();
    			})
    			.forEach(singleCity -> System.out.println("CITY: " + singleCity));
    }
}
