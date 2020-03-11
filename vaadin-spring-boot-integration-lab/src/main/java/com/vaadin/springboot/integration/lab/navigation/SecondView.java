package com.vaadin.springboot.integration.lab.navigation;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class SecondView extends VerticalLayout implements View {
	public static String SECOND_VIEW = "secondView";
	
	@Override
	public void enter(ViewChangeEvent event) {
		Label label = new Label("Second View");
		addComponent(label);
	}
}
