package com.example.tizona.screen;

import com.example.tizona.common.StringsContainer;
import com.vaadin.terminal.gwt.client.ui.AlignmentInfo.Bits;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class TizonaWindow extends Window {

    private Window subwindow;

    public TizonaWindow() {

	// Título de la aplicación
	setCaption(StringsContainer.getString("tizona.application"));

	showLogin();

    }

    private void showLogin() {

	// Create the subwindow
	subwindow = new Window(StringsContainer.getString("tizona.login.titulo"));
	subwindow.setClosable(false);
	subwindow.setWidth("335px");
	subwindow.setHeight("130px");
	subwindow.setResizable(false);
	subwindow.setDraggable(false);
	subwindow.center();

	final GridLayout grid = new GridLayout(3, 2);
	grid.setSpacing(true);

	Label lblUsuario = new Label(StringsContainer.getString("tizona.login.usuario"));
	grid.addComponent(lblUsuario, 0, 0);
	grid.setComponentAlignment(lblUsuario, Alignment.MIDDLE_RIGHT);

	TextField user = new TextField();
	grid.addComponent(user, 1, 0);
	grid.setComponentAlignment(user, Alignment.MIDDLE_CENTER);

	Label lblPassword = new Label(StringsContainer.getString("tizona.login.password"));
	grid.addComponent(lblPassword, 0, 1);
	grid.setComponentAlignment(lblPassword, Alignment.MIDDLE_RIGHT);

	PasswordField pass = new PasswordField();
	grid.addComponent(pass, 1, 1);
	grid.setComponentAlignment(pass, Alignment.MIDDLE_CENTER);

	Button button = new Button(StringsContainer.getString("tizona.login.login"));
	button.addListener(new ClickListener() {
	    @Override
	    public void buttonClick(ClickEvent event) {
		doLogin();
	    }
	});
	grid.addComponent(button, 2, 0, 2, 1);
	grid.setComponentAlignment(button, new Alignment(Bits.ALIGNMENT_VERTICAL_CENTER
		| Bits.ALIGNMENT_HORIZONTAL_CENTER));

	VerticalLayout layout = (VerticalLayout) subwindow.getContent();
	layout.addComponent(grid);

	// Add the window to the screen
	addWindow(subwindow);

    }

    private void doLogin() {
	if (true) {
	    removeWindow(subwindow);
	    setContent(new MainScreen());
	}
    }

}
