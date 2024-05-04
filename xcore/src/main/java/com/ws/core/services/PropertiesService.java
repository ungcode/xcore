package com.ws.core.services;

import com.ws.core.dao.PropertiesDao;
import com.ws.core.dto.PropertiesDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.Properties;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PropertiesService
    extends StandardService< Properties >
{

    @Inject
    protected PropertiesDao< Properties > dao;
    protected PropertiesService        service = null;

    @PostConstruct
    public void init()
    {
        service = new PropertiesService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store item data in database
     * 
     * @param properties to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public PropertiesService persist( Properties properties )
	{
        final String TAG = "ItemService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( properties );
            service.setResponse( new StandardResponse< PropertiesDTO >( new PropertiesDTO().mapper( properties ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.PROPERTIES_SERVICE_PERSIST_CODE,
                      Error.PROPERTIES_SERVICE_PERSIST_LEVEL,
                      Error.PROPERTIES_SERVICE_PERSIST_TEXT,
                      new StandardResponse< Properties >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates item with new supplied informations
     * 
     * @param __new object containing new address information
     * @return service class operation result
     * @see StandardResponse
     */

    public PropertiesService update( Properties __new )
    {

        final String TAG = "ItemService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Properties properties = dao.fetch( __new.getId() );

            properties.merge( __new,
                        properties );

            dao.update( properties );

            service.setResponse( new StandardResponse< PropertiesDTO >( new PropertiesDTO().mapper( properties ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.PROPERTIES_SERVICE_UPDATE_CODE,
                      Error.PROPERTIES_SERVICE_UPDATE_LEVEL,
                      Error.PROPERTIES_SERVICE_UPDATE_TEXT,
                      new StandardResponse< Properties >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete item according to supplied identification
     * 
     * @param id identifies the item to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public PropertiesService delete( Long id )
    {

        final String TAG = "ItemService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Properties properties = dao.fetch( id );

            dao.delete( properties );

            service.setResponse( new StandardResponse< PropertiesDTO >( new PropertiesDTO().mapper( properties ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.PROPERTIES_SERVICE_DELETE_CODE,
                      Error.PROPERTIES_SERVICE_DELETE_LEVEL,
                      Error.PROPERTIES_SERVICE_DELETE_TEXT,
                      new StandardResponse< Properties >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted items
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public PropertiesService fetchAll()
    {

        final String TAG = "ItemsService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< PropertiesDTO >( new PropertiesDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.PROPERTIES_SERVICE_FETCH_ALL_CODE,
                      Error.PROPERTIES_SERVICE_FETCH_ALL_LEVEL,
                      Error.PROPERTIES_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< Properties >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve item matching the supplied item
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public PropertiesService fetch( long id )
    {

        final String TAG = "ItemService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< PropertiesDTO >( new PropertiesDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.PROPERTIES_SERVICE_FETCH_CODE,
                      Error.PROPERTIES_SERVICE_FETCH_LEVEL,
                      Error.PROPERTIES_SERVICE_FETCH_TEXT,
                      new StandardResponse< Properties >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );


        }
        return service;
    }

}
