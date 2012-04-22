package es.guzman.tizona.common;

import java.util.ResourceBundle;

/**
 * Esta clase se encarga de recuperar los Strings de la aplicación
 * 
 * @author guzman
 *
 */
public class StringsContainer {

    // Initialize the strings
    private static ResourceBundle tizonaStrings;
    static {
	tizonaStrings = ResourceBundle.getBundle("tizona-strings");
    }

    /**
     * Returns the localized string
     * 
     * @param key
     * @return
     */
    public static String getString(String key) {
	return tizonaStrings.getString(key);
    }
    
}
