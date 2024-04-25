package com.ws.core.response;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


/**
 * This sets a base standard response for the entire API, the standard service
 * must aggregate this class.
 * 
 *
 * @version 1.0
 */
public class StandardResponse< T >
    implements Serializable
{
	
    private static final long serialVersionUID = 1L;
    private int               errorCode;
	private int errorLevel;
	private String errorText;
    private List< ? >         Data;
	

    public StandardResponse()
    {
		this.errorCode = 0;
		this.errorLevel = 0;
		this.errorText = "{}";
		setData(Arrays.asList(new String()));

	}
	
    public StandardResponse( T data )
    {
		this.errorCode = 0;
		this.errorLevel = 0;
		this.errorText = "{}";
		setData(asArray(data));

	}

    public StandardResponse( List< ? > Data )
    {
        this.errorCode = 0;
        this.errorLevel = 0;
        this.errorText = "{}";
        setData( Data );

    }

    public int getErrorCode()
    {
		return errorCode;
	}


    public void setErrorCode( int resultCode )
    {
		this.errorCode = resultCode;
	}


    public int getErrorLevel()
    {
		return errorLevel;
	}


    public void setErrorLevel( int level )
    {
		this.errorLevel = level;
	}


    public String getErrorText()
    {
		return errorText;
	}


	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

    public List< ? > getData()
    {
		return Data;
	}

    public void setData( List< ? > list )
    {
		Data = list;
	}
	
    public List< T > asArray( T t )
    {
		return Arrays.asList(t);
	}

}
