package com.ws.core.services;

import com.ws.core.dao.ColorDao;
import com.ws.core.dto.ColorDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.Color;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ColorService
    extends StandardService< Color >
{

    @Inject
    protected ColorDao< Color > dao;
    protected ColorService        service = null;

    @PostConstruct
    public void init()
    {
        service = new ColorService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store color data in database
     * 
     * @param color to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public ColorService persist( Color color )
	{
        final String TAG = "ColorService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( color );
            service.setResponse( new StandardResponse< ColorDTO >( new ColorDTO().mapper( color ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.COLOR_SERVICE_PERSIST_CODE,
                      Error.COLOR_SERVICE_PERSIST_LEVEL,
                      Error.COLOR_SERVICE_PERSIST_TEXT,
                      new StandardResponse< Color >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates color with new supplied informations
     * 
     * @param __new object containing new address information
     * @return service class operation result
     * @see StandardResponse
     */

    public ColorService update( Color __new )
    {

        final String TAG = "ColorService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Color color = dao.fetch( __new.getId() );

            color.merge( __new,
                         color );

            dao.update( color );

            service.setResponse( new StandardResponse< ColorDTO >( new ColorDTO().mapper( color ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.COLOR_SERVICE_UPDATE_CODE,
                      Error.COLOR_SERVICE_UPDATE_LEVEL,
                      Error.COLOR_SERVICE_UPDATE_TEXT,
                      new StandardResponse< Color >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete color according to supplied identification
     * 
     * @param id identifies the product to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public ColorService delete( Long id )
    {

        final String TAG = "ColorService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Color color = dao.fetch( id );

            dao.delete( color );

            service.setResponse( new StandardResponse< ColorDTO >( new ColorDTO().mapper( color ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.COLOR_SERVICE_DELETE_CODE,
                      Error.COLOR_SERVICE_DELETE_LEVEL,
                      Error.COLOR_SERVICE_DELETE_TEXT,
                      new StandardResponse< Color >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted colors
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public ColorService fetchAll()
    {

        final String TAG = "ColorService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< ColorDTO >( new ColorDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.COLOR_SERVICE_FETCH_ALL_CODE,
                      Error.COLOR_SERVICE_FETCH_ALL_LEVEL,
                      Error.COLOR_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< Color >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve color matching the supplied color
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public ColorService fetch( long id )
    {

        final String TAG = "ColorService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< ColorDTO >( new ColorDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.COLOR_SERVICE_FETCH_CODE,
                      Error.COLOR_SERVICE_FETCH_LEVEL,
                      Error.COLOR_SERVICE_FETCH_TEXT,
                      new StandardResponse< Color >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );


        }
        return service;
    }

}
