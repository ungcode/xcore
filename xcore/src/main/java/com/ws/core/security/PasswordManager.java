package com.ws.core.security;

import java.util.Properties;

import org.mindrot.jbcrypt.BCrypt;

import com.ws.core.security.encypt.XcoreCipher;
import com.ws.core.security.hashing.Hashing;
import com.ws.core.util.DBProperties;
import com.ws.core.util.XcoreLogger;

/**
 * PasswordManager a utility class responsible of handling password related
 * logic
 */
public class PasswordManager
{

	public static final String HASHED = "hashed";
	public static final String SALT = "salt";

	private final Integer COST = DBProperties.COST;

	/**
	 * handle the result of hashed password
	 * 
	 * @param password supplied password
	 * @return value pair object of hashed password and its salt
	 */
	public Properties getProperties(String password)
	{
		final String TAG = "PasswordManager.getProperties";
		Properties properties = new Properties(1);
		try
		{
			XcoreCipher cipher = new XcoreCipher();

			XcoreLogger.debug(TAG, "Start");

			String salt = BCrypt.gensalt(COST.intValue());
			Hashing hashing = new Hashing(COST.intValue(), salt);
			properties.setProperty(SALT, salt);
			properties.setProperty(HASHED, cipher.encrypt(hashing.doHash(password)));

			XcoreLogger.debug(TAG, "end");
		} catch (Exception e)
		{
			XcoreLogger.error(TAG, e.getMessage());
		}

		return properties;

	}

	/**
	 * Verify if supplied password hash matches the hash stored in the db
	 * 
	 * @param password plan text password
	 * @param hashed   db stored hashed
	 * @return true or false for success or failure
	 */
	public boolean isValid(String password, String dbHashed)
	{
		Hashing hashing = new Hashing();
		return hashing.verifyHash(password, dbHashed);
	}

}
