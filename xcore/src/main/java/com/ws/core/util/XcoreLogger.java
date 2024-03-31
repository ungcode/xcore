package com.ws.core.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class XcoreLogger {
	private static final String LOGGER_TYPE = "Xcore";
	private final static Logger LOGGER = LogManager.getLogger(LOGGER_TYPE);

	public static final void info(String location, String message)
	{
    StringBuffer buffer = new StringBuffer();
    buffer.append(location);
		buffer.append(" | ");
    buffer.append(message);

		LOGGER.info(buffer);


  }
  
  public static final void debug(String location, String message) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(location);
    buffer.append("| ");
    buffer.append(message);
		LOGGER.debug(buffer);

	}

	public static final void trace(String location, String message)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(location);
		buffer.append("| ");
		buffer.append(message);
		LOGGER.trace(buffer);

	}

	public static final void error(String location, String message)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(location);
		buffer.append("| ");
		buffer.append(message);
		LOGGER.error(buffer);

  }
}