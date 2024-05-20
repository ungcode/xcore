package com.ws.core.services;

import com.ws.core.i18n.I18nConfig;
import com.ws.core.response.StandardResponse;
import java.util.Arrays;


/**
 * This is a meddle tie service class by which all concrete services must
 * inherit from it.
 * 
 *
 * @version 1.0
 */
public class StandardService<T> {

    private StandardResponse< ? > response;

    public void setError( final int errorCore,
                          final int errorLevel,
                          final String errorText )
    {

		response.setErrorCode(errorCore);
		response.setErrorLevel(errorLevel);
		response.setErrorText(errorText);

	}

	public StandardResponse<?> getResponse() {
		return response;
	}

	public void setResponse(StandardResponse<?> response) {
		this.response = response;
	}

	public void setError(final int errorCode, 
						 final int errorLevel, 
						 final String errorText, 
						 final StandardResponse<T> response) 
	{
		response.setData(Arrays.asList(new String()));
		setResponse(response);
		setError(errorCode, 
				 errorLevel, 
				 I18nConfig.getMessage(errorText));
	}

}
