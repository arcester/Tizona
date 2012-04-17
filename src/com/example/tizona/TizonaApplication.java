package com.example.tizona;

import java.util.ResourceBundle;

import com.example.tizona.screen.LoginScreen;
import com.example.tizona.screen.TizonaWindow;
import com.vaadin.Application;

public class TizonaApplication extends Application {

    // Initialize the strings
    private static ResourceBundle tizonaStrings;
    static {
	tizonaStrings = ResourceBundle.getBundle("tizona-strings");
    }

    @Override
    public void init() {

	// setTheme("chameleon-vaadin");

	// Redirect to login screen
	setMainWindow(new TizonaWindow());
//	getMainWindow().setContent(new LoginScreen());

    }

    /**
     * Returns the localized string
     * 
     * @param key
     * @return
     */
    public static String getLocalizedString(String key) {
	return tizonaStrings.getString(key);
    }

}
