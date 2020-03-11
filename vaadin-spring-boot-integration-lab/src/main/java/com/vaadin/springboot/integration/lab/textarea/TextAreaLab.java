package com.vaadin.springboot.integration.lab.textarea;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;

public class TextAreaLab {
	public HorizontalLayout getRootLayout() {
		HorizontalLayout rootLayout =
				new HorizontalLayout();
		
		rootLayout.addComponent(this.getTextAreaDefault());
		rootLayout.addComponent(this.getTextAreaWordWrap());
		rootLayout.addComponent(this.getTextAreaWithFixedSize());
		
		return rootLayout;
	}
	
	private TextArea getTextAreaDefault() {
		TextArea myTextArea = new TextArea();
		
		return myTextArea;
	}
	
	private TextArea getTextAreaWordWrap() {
		TextArea myTextArea = new TextArea();
		myTextArea.setWordWrap(false);
		myTextArea.setValue("This is the default value to the text area");
		
		return myTextArea;
	}
	
	private TextArea getTextAreaWithFixedSize() {
		TextArea myTextArea = new TextArea("Observations:");
		myTextArea.setWidth("400px");
		myTextArea.setHeight(700, Unit.PIXELS);
		
		myTextArea.setPlaceholder("Please Insert Text...");
		
		return myTextArea;
	}
}
