package es.guzman.tizona;

import com.vaadin.Application;

import es.guzman.tizona.screen.TizonaWindow;

public class TizonaApplication extends Application {

    @Override
    public void init() {

	// setTheme("chameleon-vaadin");

	// Redirect to login screen
	setMainWindow(new TizonaWindow());
	setTheme("tizonatheme");

    }

}
