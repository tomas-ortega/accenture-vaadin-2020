package com.vaadin.springboot.integration.lab.navigation;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
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
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path="/ui")
@Title("This is the title page!")
@Theme("accenture")
public class MainView extends UI {

	@Override
	protected void init(VaadinRequest request) {
		setContent(this.getNavigation());
	}
	
	private VerticalLayout getNavigation() {
		VerticalLayout root = new VerticalLayout();
		
		Button gotoFirstView = new Button("Navigate to first view");
		Button gotoSecondView = new Button("Navigate to second view");
		
		Panel viewContainer = new Panel();
		Navigator navigator = new Navigator(this, viewContainer);
		
		navigator.addView(FirstView.FIRST_VIEW, new FirstView());
		navigator.addView(SecondView.SECOND_VIEW, new SecondView());
		navigator.addView("", new FirstView());
		
		root.addComponent(new HorizontalLayout(gotoFirstView, gotoSecondView));
		root.addComponent(viewContainer);
		
		gotoFirstView.addClickListener(event -> navigator.navigateTo(FirstView.FIRST_VIEW));
		gotoSecondView.addClickListener(event -> navigator.navigateTo(SecondView.SECOND_VIEW));
		
		return root;
	}
}
