package com.vaadin.springboot.integration.lab;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.springboot.integration.lab.button.ButtonLab;
import com.vaadin.springboot.integration.lab.grid.GridLab;
import com.vaadin.springboot.integration.lab.label.LabelLab;
import com.vaadin.springboot.integration.lab.textarea.TextAreaLab;
import com.vaadin.springboot.integration.lab.textfield.TextFieldLab;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

//@SpringUI(path="/ui")
//@Title("This is the title page!")
//@Theme("valo")
public class MainView extends UI {

	@Override
	protected void init(VaadinRequest request) {
		//LabelLab labelLab = new LabelLab();
		//TextFieldLab textFieldLab = new TextFieldLab();
		//TextAreaLab textAreaLab = new TextAreaLab();
		//ButtonLab buttonLab = new ButtonLab();
		GridLab gridLab = new GridLab();
		
		setContent(gridLab.getRootLayout());
	}
}
