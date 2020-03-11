package com.vaadin.springboot.integration.lab.button;

import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;

public class ButtonLab {
	
	public HorizontalLayout getRootLayout() {
		HorizontalLayout rootLayout 
		= new HorizontalLayout();
	
		rootLayout.addComponent(this.getButtonWithText());
		rootLayout.addComponent(this.getButtonWithClickListener(rootLayout));
		rootLayout.addComponent(this.getButtonWithDefaultNotification());
		rootLayout.addComponent(this.getButtonWithCustomNotification());
		
		return rootLayout;
	}
	
	private Button getButtonWithText() {
		Button myButton = new Button("Save");
		
		return myButton;
	}
	
	private Button getButtonWithClickListener(HorizontalLayout rootLayout) {
		Button buttonWithListener = new Button("Open");
		
		buttonWithListener.addClickListener(event -> {
			rootLayout.addComponent(new Label("Open Button Pressed!"));
		});
		
		return buttonWithListener;
	}
	
	private Button getButtonWithDefaultNotification() {
		Button myButton = new Button("Click Me!");
		
		myButton.addClickListener(event -> Notification.show("Client Not Found (404) :D"));
		
		return myButton;
	}
	
	private Button getButtonWithCustomNotification() {
		Button myButton = new Button("Click Me!");
		
		Notification.show("The client will be inserted",
						  Notification.Type.HUMANIZED_MESSAGE);
		
		//myButton.addClickListener(event -> errorNotification.show(Page.getCurrent()));
		myButton.addClickListener(event -> {
			Notification errorNotification = new Notification("Clients",
					  "Error when insert",
					  Notification.Type.ERROR_MESSAGE);

				errorNotification.setPosition(Position.TOP_RIGHT);
				errorNotification.setDelayMsec(5000);
				
				errorNotification.show(Page.getCurrent());
		});
		
		return myButton;
	}
}
