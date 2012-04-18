package com.example.tizona;

import com.example.tizona.screen.TizonaWindow;
import com.vaadin.Application;

public class TizonaApplication extends Application {

    @Override
    public void init() {

	// setTheme("chameleon-vaadin");

	// Redirect to login screen
	setMainWindow(new TizonaWindow());

    }

}
