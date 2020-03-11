package com.vaadin.springboot.integration.lab.grid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PatientDAO {
	
	public List<Patient> searchPatients() {
		List<Patient> dbPatientList = new ArrayList<>();
		
		dbPatientList.add(new Patient("NHX7436A", 3, "Hospital Carlos Haya"));
		dbPatientList.add(new Patient("NHCUJGLA", 2, "Hospital Axarquía"));
		dbPatientList.add(new Patient("NHUBXDG4", 1, "Hospital Materno Infantil"));
		
		return dbPatientList;
	}
}
