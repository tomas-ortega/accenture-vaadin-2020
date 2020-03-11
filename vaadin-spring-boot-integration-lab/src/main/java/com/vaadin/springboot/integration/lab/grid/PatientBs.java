package com.vaadin.springboot.integration.lab.grid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientBs {
	
	//@Autowired
	private PatientDAO patientDAO = new PatientDAO();
	
	public List<Patient> searchPatients() {
		List<Patient> dbPatientList;
		
		try {
			dbPatientList = this.patientDAO
								.searchPatients();
			
			return dbPatientList;
		} catch(Exception ex) {
			throw ex;
		}
	}
}
