package com.vaadin.springboot.integration.lab.textfield;

import com.vaadin.data.Binder;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

public class TextFieldLab {
	public HorizontalLayout getRootLayout() {
		HorizontalLayout rootLayout =
				new HorizontalLayout();
		
		rootLayout.addComponent(this.getTextField());
		rootLayout.addComponent(this.getTextFieldWithValue());
		rootLayout.addComponent(this.getTextFieldWithValueConstructor());
		rootLayout.addComponent(this.getTextFieldWithMaxLenght());
		
		Binder<String> userNameValue = this.getBinderForTextFieldAndLabel("Pakito!");
		rootLayout.addComponent(this.getTextFieldWithBinderProperty(userNameValue));
		rootLayout.addComponent(this.getLabelWithBinderProperty(userNameValue));
		
		Label labeltoShowStringSize = this.getLabelWithCharacterCounter();
		TextField textFieldtoInputChar = this.getTextFieldCharacterCount(labeltoShowStringSize);
		
		rootLayout.addComponent(labeltoShowStringSize);
		rootLayout.addComponent(textFieldtoInputChar);
		
		return rootLayout;
	}
	
	private TextField getTextField() {
		TextField mytextField = new TextField();
		
		return mytextField;
	}
	
	private TextField getTextFieldWithValue() {
		TextField mytextField = new TextField();
		mytextField.setValue("Text added by setValue:");
		
		return mytextField;
	}
	
	private TextField getTextFieldWithValueConstructor() {
		TextField mytextField = new TextField("Text added by setValue:");
		
		return mytextField;
	}
	
	private TextField getTextFieldWithMaxLenght() {
		int maxLength = 10;
		TextField textField = 
				new TextField("Max Length: " + maxLength);
		
		textField.setMaxLength(maxLength);
		
		return textField;
	}
	
	private Binder<String> getBinderForTextFieldAndLabel(String userName) {
		Binder<String> binderProperty = new Binder<>();
		binderProperty.setBean(userName);
		
		return binderProperty;
	}
	
	private TextField getTextFieldWithBinderProperty(Binder<String> userNameBinder) {
		TextField myTextField = new TextField("Name: ");
		
		userNameBinder.forField(myTextField);
		
		return myTextField;
	}
	
	private Label getLabelWithBinderProperty(Binder<String> userNameBinder) {
		Label myLabel = new Label();
		
		myLabel.setCaption("Result: ");
		myLabel.setValue(userNameBinder.getBean());
		
		return myLabel;
	}
	
	private Label getLabelWithCharacterCounter() {
		Label counterLabel = new Label("0 Characters");
		
		return counterLabel;
	}
	
	private TextField getTextFieldCharacterCount(Label labelToShowCounter) {
		TextField myTextField = new TextField();
		
		myTextField.addValueChangeListener(event -> {
			int lenghtOfText = event.getValue()
									.length();
			labelToShowCounter.setValue("Number of characters: " + lenghtOfText);
		});
		
		return myTextField;
	}
}
