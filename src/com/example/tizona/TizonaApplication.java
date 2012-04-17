package com.example.tizona;

import java.util.ResourceBundle;

import org.vaadin.jouni.animator.AnimatorProxy;

import com.example.tizona.screen.LoginScreen;
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
	setMainWindow(new LoginScreen());

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
