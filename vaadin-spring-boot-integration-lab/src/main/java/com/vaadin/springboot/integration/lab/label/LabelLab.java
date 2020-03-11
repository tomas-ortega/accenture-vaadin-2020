package com.vaadin.springboot.integration.lab.label;

import com.vaadin.data.Binder;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class LabelLab {
	public HorizontalLayout getRootLayout() {
		HorizontalLayout rootLayout 
		= new HorizontalLayout();
		
		rootLayout.addComponent(this.getLabelWithouthText());
		rootLayout.addComponent(this.getLabelWithText());
		rootLayout.addComponent(this.getLabelWithContentModeText());
		rootLayout.addComponent(this.getLabelWithContentModePre());
		rootLayout.addComponent(this.getLabelWithContentModeHtml());
		rootLayout.addComponent(this.getLabelWidthDataBinding());
		
		return rootLayout;
	}
	
	//<label></label>
	private Label getLabelWithouthText() {
		Label singleLabel = new Label();
		
		return singleLabel;
	}
	
	//<label>Pakito Label!</label>
	private Label getLabelWithText() {
		Label singleLabel = new Label("Pakito Label!");
		
		return singleLabel;
	}
	
	//<label>Pakito Label!</label>
	private Label getLabelWithContentModeText() {
		Label singleLabel = new Label("Pakito Label!", ContentMode.TEXT);
		
		return singleLabel;
	}
	
	/*<pre>
	 * Hola, texto en HTML...
	 * :D
	 * </pre>*/
	private Label getLabelWithContentModePre() {
		Label singleLabel = new Label("Pakito Label! \n Second Line!", ContentMode.PREFORMATTED);
		
		return singleLabel;
	}
	
	private Label getLabelWithContentModeHtml() {
		Label singleLabel = new Label("<marquee><b>Pakito Label!</b></marquee>", ContentMode.HTML);
		
		return singleLabel;
	}
	
	private Label getLabelWidthDataBinding() {
		Binder<String> binderLabel = new Binder<>();
		Label labelWithBinder 
			= new Label("Pakito Binder!");
		
		binderLabel.setBean("Text to binder!");
		
		labelWithBinder.setValue(binderLabel.getBean());
		
		return labelWithBinder;
	}
}
