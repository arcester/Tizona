package com.example.tizona.screen;

import java.util.ResourceBundle;

import org.vaadin.jouni.animator.AnimatorProxy;
import org.vaadin.jouni.animator.client.ui.VAnimatorProxy.AnimType;

import com.example.tizona.TizonaApplication;
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

public class LoginScreen extends Window {

    // Common objects
    private AnimatorProxy proxy = new AnimatorProxy();
    private TizonaApplication app;

    private Window subwindow;

    public LoginScreen() {

	// Initialize
	app = (TizonaApplication) getApplication();
	ResourceBundle tizonaStrings = ResourceBundle.getBundle("tizona-strings");

	// Initialize the "effects proxy"
	this.addComponent(proxy);

	// Aplicacion
	setCaption(tizonaStrings.getString("tizona.application"));

	// Create the subwindow
	subwindow = new Window(tizonaStrings.getString("tizona.login.titulo"));
	subwindow.setClosable(false);
	subwindow.setWidth("325px");
	subwindow.setHeight("130px");
	subwindow.setResizable(false);
	subwindow.setDraggable(false);
	subwindow.center();

	final GridLayout grid = new GridLayout(3, 2);
	grid.setSpacing(true);

	Label lblUsuario = new Label(tizonaStrings.getString("tizona.login.usuario"));
	grid.addComponent(lblUsuario, 0, 0);
	grid.setComponentAlignment(lblUsuario, Alignment.MIDDLE_RIGHT);

	TextField user = new TextField();
	grid.addComponent(user, 1, 0);
	grid.setComponentAlignment(user, Alignment.MIDDLE_CENTER);

	Label lblPassword = new Label(tizonaStrings.getString("tizona.login.password"));
	grid.addComponent(lblPassword, 0, 1);
	grid.setComponentAlignment(lblPassword, Alignment.MIDDLE_RIGHT);

	PasswordField pass = new PasswordField();
	grid.addComponent(pass, 1, 1);
	grid.setComponentAlignment(pass, Alignment.MIDDLE_CENTER);

	Button button = new Button(tizonaStrings.getString("tizona.login.login"));
	button.addListener(new ClickListener() {
	    @Override
	    public void buttonClick(ClickEvent event) {
		proxy.animate(subwindow, AnimType.FADE_OUT_REMOVE).setDuration(500).setDelay(0);
	    }
	});
	grid.addComponent(button, 2, 0, 2, 1);
	grid.setComponentAlignment(button, new Alignment(Bits.ALIGNMENT_VERTICAL_CENTER
		| Bits.ALIGNMENT_HORIZONTAL_CENTER));

	VerticalLayout layout = (VerticalLayout) subwindow.getContent();
	layout.addComponent(grid);
	
	// layout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);

	// VerticalLayout layout = (VerticalLayout) subwindow.getContent();
	// layout.setMargin(true);
	// layout.setSpacing(true);
	//
	//
	// HorizontalLayout horizontal = new HorizontalLayout();
	// // horizontal.setSpacing(true);
	// Label lblUsuario = new
	// Label(tizonaStrings.getString("tizona.login.usuario"));
	// lblUsuario.setWidth("80px");
	// horizontal.addComponent(lblUsuario);
	// horizontal.setComponentAlignment(lblUsuario, Alignment.MIDDLE_RIGHT);
	// TextField user = new TextField();
	// horizontal.addComponent(user);
	// layout.addComponent(horizontal);
	//
	// horizontal = new HorizontalLayout();
	// // horizontal.setSpacing(true);
	// Label lblPassword = new
	// Label(tizonaStrings.getString("tizona.login.password"));
	// lblPassword.setWidth("80px");
	// horizontal.addComponent(lblPassword);
	// horizontal.setComponentAlignment(lblPassword,
	// Alignment.MIDDLE_RIGHT);
	// PasswordField pass = new PasswordField();
	// horizontal.addComponent(pass);
	// layout.addComponent(horizontal);

	// Add the window to the screen
	this.addWindow(subwindow);

    }

}
