package com.vaadin.springboot.integration.lab.navigation;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.springboot.integration.lab.grid.GridLab;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class FirstView extends VerticalLayout implements View {
	public static String FIRST_VIEW = "firstView";
	
	@Override
	public void enter(ViewChangeEvent event) {
		GridLab gridLab = new GridLab();
		
		addComponent(gridLab.getRootLayout());
	}
}
