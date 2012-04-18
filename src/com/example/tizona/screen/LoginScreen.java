package com.example.tizona.screen;

import java.util.ResourceBundle;

import org.vaadin.jouni.animator.AnimatorProxy.Animation;
import org.vaadin.jouni.animator.AnimatorProxy.AnimationEvent;
import org.vaadin.jouni.animator.AnimatorProxy.AnimationListener;

import com.example.tizona.TizonaApplication;
import com.vaadin.terminal.gwt.client.ui.AlignmentInfo.Bits;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class LoginScreen extends CustomComponent {

    // Common objects
    private TizonaApplication app;

    private Window subwindow;

    private Animation animationFromButton;

    public LoginScreen() {

	// Initialize
	app = (TizonaApplication) getApplication();
	ResourceBundle tizonaStrings = ResourceBundle.getBundle("tizona-strings");

	VerticalLayout mainLayout = new VerticalLayout();
	mainLayout.setImmediate(false);
	mainLayout.setWidth("100%");
	mainLayout.setHeight("100%");
	mainLayout.setMargin(false);
	setCompositionRoot(mainLayout);

	setWidth("100.0%");
	setHeight("100.0%");
	
	mainLayout.addComponent(new Label("login"));

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
		    doLogin();
//		animationFromButton = proxy.animate(subwindow, AnimType.FADE_OUT_REMOVE).setDuration(500).setDelay(0);
	    }
	});
	grid.addComponent(button, 2, 0, 2, 1);
	grid.setComponentAlignment(button, new Alignment(Bits.ALIGNMENT_VERTICAL_CENTER
		| Bits.ALIGNMENT_HORIZONTAL_CENTER));

	VerticalLayout layout = (VerticalLayout) subwindow.getContent();
	layout.addComponent(grid);

	// Manage the animation from the button
//	proxy.addListener(new AnimationListener() {
//	    public void onAnimation(AnimationEvent event) {
//		if (event.getAnimation() == animationFromButton) {
////		    app.setMainWindow(new MainScreen());
//		    doLogin();
//		}
//	    }
//	});

	// Add the window to the screen
	app.getMainWindow();
	getWindow().addWindow(subwindow);

    }

    private void doLogin() {
//	app.getMainWindow().removeAllComponents();
	System.out.println("hola");
//	app.
//	app.getMainWindow().setContent(new MainScreen());
//	app.setMainWindow(new MainScreen());
    }
    
}