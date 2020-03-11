package com.vaadin.springboot.integration.lab.grid;

public class Patient {
	private String historyNumber;
	private Integer centerId;
	private String centerName;
	private Boolean covid19;
	
	public Boolean getCovid19() {
		return covid19;
	}

	public void setCovid19(Boolean covid19) {
		this.covid19 = covid19;
	}

	public Patient(String historyNumber, Integer centerId, String centerName) {
		this.historyNumber = historyNumber;
		this.centerId = centerId;
		this.centerName = centerName;
	}
	
	public Patient(String historyNumber, 
					Integer centerId, 
					String centerName,
					Boolean covid19) {
		this.historyNumber = historyNumber;
		this.centerId = centerId;
		this.centerName = centerName;
		this.covid19 = covid19;
	}
	
	public String getHistoryNumber() {
		return historyNumber;
	}
	
	public void setHistoryNumber(String historyNumber) {
		this.historyNumber = historyNumber;
	}
	
	public Integer getCenterId() {
		return centerId;
	}
	
	public void setCenterId(Integer centerId) {		
		this.centerId = centerId;
	}
	
	public String getCenterName() {
		return centerName;
	}
	
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
}
