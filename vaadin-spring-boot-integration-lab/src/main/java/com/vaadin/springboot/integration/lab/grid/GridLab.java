package com.vaadin.springboot.integration.lab.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.components.grid.GridSelectionModel;
import com.vaadin.ui.components.grid.MultiSelectionModel;
import com.vaadin.ui.components.grid.SingleSelectionModel;

@Component
public class GridLab {
	
	//@Autowired
	private PatientBs patientBs = new PatientBs();
	
	public HorizontalLayout getRootLayout() {
		HorizontalLayout rootLayout 
		= new HorizontalLayout();
		
		rootLayout.addComponent(this.getPatientSupectCovid19());
		
		/*rootLayout.addComponent(this.getBasicGrid());
		rootLayout.addComponent(this.getGridWithHeightMode());
		rootLayout.addComponent(this.getGridWithColumnOrder());
		
		//Delete single Item
		List<Patient> patientListDeleteSingle =
				this.patientBs.searchPatients();
		Grid<Patient> gridDeleteSingle =
				this.getGridDeleteSingle(patientListDeleteSingle);
		
		rootLayout.addComponent(gridDeleteSingle);
		rootLayout.addComponent(this.getButtonDeleteSingle(gridDeleteSingle, 
														   patientListDeleteSingle));*/
		
		return rootLayout;	
	}
	
	private Grid<Patient> getBasicGrid() {
		Grid<Patient> waitPatientList
				= new Grid<>();
		List<Patient> dbPatientList = new ArrayList<>();
		
		dbPatientList.add(new Patient("NHX7436A", 3, "Hospital Carlos Haya"));
		dbPatientList.add(new Patient("NHCUJGLA", 2, "Hospital Axarquía"));
		dbPatientList.add(new Patient("NHUBXDG4", 1, "Hospital Materno Infantil"));
		
		waitPatientList.addColumn(Patient::getHistoryNumber)
						.setCaption("NHC");
		
		waitPatientList.addColumn(Patient::getCenterId)
						.setCaption("Center ID");
		
		waitPatientList.addColumn(Patient::getCenterName)
						.setCaption("Center Name");
		
		waitPatientList.setItems(dbPatientList);
		
		return waitPatientList;
	}
	
	private Grid<Patient> getGridWithHeightMode() {
		Grid<Patient> waitPatientList
				= new Grid<>();
		List<Patient> dbPatientList = new ArrayList<>();
		
		dbPatientList.add(new Patient("NHX7436A", 3, "Hospital Carlos Haya"));
		dbPatientList.add(new Patient("NHCUJGLA", 2, "Hospital Axarquía"));
		dbPatientList.add(new Patient("NHUBXDG4", 1, "Hospital Materno Infantil"));
		
		waitPatientList.addColumn(Patient::getHistoryNumber)
						.setCaption("NHC");
		
		waitPatientList.addColumn(Patient::getCenterId)
						.setCaption("Center ID");
		
		waitPatientList.addColumn(Patient::getCenterName)
						.setCaption("Center Name");
		
		waitPatientList.setItems(dbPatientList);
		
		waitPatientList.setHeightMode(HeightMode.ROW);
		waitPatientList.setHeightByRows(2);
		
		return waitPatientList;
	}
	
	private Grid<Patient> getGridWithColumnOrder() {
		Grid<Patient> waitPatientList
				= new Grid<>();
		List<Patient> dbPatientList = new ArrayList<>();
		
		dbPatientList.add(new Patient("NHX7436A", 3, "Hospital Carlos Haya"));
		dbPatientList.add(new Patient("NHCUJGLA", 2, "Hospital Axarquía"));
		dbPatientList.add(new Patient("NHUBXDG4", 1, "Hospital Materno Infantil"));
		
		waitPatientList.addColumn(Patient::getHistoryNumber)
						.setCaption("NHC");
		
		waitPatientList.addColumn(Patient::getCenterId)
						.setCaption("Center ID");
		
		waitPatientList.addColumn(Patient::getCenterName)
						.setCaption("Center Name");
		
		waitPatientList.setItems(dbPatientList);
		
		waitPatientList.setHeightMode(HeightMode.ROW);
		waitPatientList.setHeightByRows(dbPatientList.size());
		
		waitPatientList.setColumnOrder(waitPatientList.getColumns().get(2),
									   waitPatientList.getColumns().get(1),
									   waitPatientList.getColumns().get(0));
		
		return waitPatientList;
	}
	
	private Grid<Patient> getGridDeleteSingle(List<Patient> patientList) {
		Grid<Patient> waitPatientList
				= new Grid<>();
		
		waitPatientList.addColumn(Patient::getHistoryNumber)
						.setCaption("NHC");
		
		waitPatientList.addColumn(Patient::getCenterId)
						.setCaption("Center ID");
		
		waitPatientList.addColumn(Patient::getCenterName)
						.setCaption("Center Name");
		
		waitPatientList.setItems(patientList);
		
		waitPatientList.setHeightMode(HeightMode.ROW);
		waitPatientList.setHeightByRows(patientList.size());
		waitPatientList.setSelectionMode(SelectionMode.MULTI);
		
		waitPatientList.setColumnOrder(waitPatientList.getColumns().get(2),
									   waitPatientList.getColumns().get(1),
									   waitPatientList.getColumns().get(0));
		
		return waitPatientList;
	}
	
	private Button getButtonDeleteSingle(Grid<Patient> grid,
										List<Patient> patientList) {
		Button deleteButton = new Button();
		
		deleteButton.setCaption("Delete");
		
		deleteButton.addClickListener(event -> {
			GridSelectionModel singleModel =
					(GridSelectionModel) grid.getSelectionModel();
			
			singleModel.getSelectedItems()
					   .forEach(singlePatient -> 
					   		patientList.remove(singlePatient));
			
			grid.getDataProvider().refreshAll();
			/*Optional<Patient> optionalSelected = singleModel.getSelectedItem();
			
			if(optionalSelected.isPresent()) {
				patientList.remove(optionalSelected.get());
				grid.getDataProvider().refreshAll();
			} else {
				Notification.show("Please select a patient!");
			}*/
			
			System.out.println(patientList.size());
		});
		
		return deleteButton;
	}
	
	private Grid<Patient> getPatientSupectCovid19() {
		List<Patient> patientList = new ArrayList<>();
		patientList.add(new Patient("AXDF", 1, "HOSP.1", true));
		patientList.add(new Patient("AXDFXDD", 2, "HOSP.2", false));
		
		Grid<Patient> patientGrid = new Grid<Patient>();
		
		Column<Patient, String> columnNHC = 
				patientGrid.addColumn(Patient::getHistoryNumber)
							.setCaption("NHC");
		
		Column<Patient, Boolean> columnCovid19 =
				patientGrid.addColumn(Patient::getCovid19)
							.setCaption("COVID-19");
		
		patientGrid.setItems(patientList);
		
		columnCovid19.setStyleGenerator(currentPatient -> {
			if (currentPatient.getCovid19()) {
				return "red";
			} else {
				return "green";
			}
		});
		
		return patientGrid;
	}
	
}
