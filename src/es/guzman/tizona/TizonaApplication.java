package es.guzman.tizona;

import com.vaadin.Application;


public class TizonaApplication extends Application {

    private TizonaWindow mainWindow;
    
    @Override
    public void init() {

	// setTheme("chameleon-vaadin");

	// Redirect to login screen
	mainWindow = new TizonaWindow();
	setMainWindow(mainWindow);
	setTheme("tizonatheme");

    }
    
    public TizonaWindow getMainWindow() {
	return mainWindow;
    }

}
