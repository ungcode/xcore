package com.ws.core.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * perform application internationalization
 */

public class I18nConfig {
	
	/**
	 * properties by default locale
	 * @param key lookup message key
	 * @return message value
	 */
	public static String getMessage(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages");
		return bundle.getString(key);
	}
	
    /**
     * properties by supplied locale
     * 
     * @param key lookup message key
     * @param locale supplied locale
     * @return message value
     */

	public  static String getMessage(String key, Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
		return bundle.getString(key);
	}

}
