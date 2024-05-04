package com.ws.core.services;

import com.ws.core.dao.ImageDao;
import com.ws.core.dto.ImageDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.Image;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ImageService
    extends StandardService< Image >
{

    @Inject
    protected ImageDao< Image > dao;
    protected ImageService        service = null;

    @PostConstruct
    public void init()
    {
        service = new ImageService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store item data in database
     * 
     * @param image to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public ImageService persist( Image image )
	{
        final String TAG = "ImageService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( image );
            service.setResponse( new StandardResponse< ImageDTO >( new ImageDTO().mapper( image ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.PROPERTIES_SERVICE_PERSIST_CODE,
                      Error.PROPERTIES_SERVICE_PERSIST_LEVEL,
                      Error.PROPERTIES_SERVICE_PERSIST_TEXT,
                      new StandardResponse< Image >() );

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

    public ImageService update( Image __new )
    {

        final String TAG = "ImageService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Image image = dao.fetch( __new.getId() );

            image.merge( __new,
                         image );

            dao.update( image );

            service.setResponse( new StandardResponse< ImageDTO >( new ImageDTO().mapper( image ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.PROPERTIES_SERVICE_UPDATE_CODE,
                      Error.PROPERTIES_SERVICE_UPDATE_LEVEL,
                      Error.PROPERTIES_SERVICE_UPDATE_TEXT,
                      new StandardResponse< Image >() );
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

    public ImageService delete( Long id )
    {

        final String TAG = "ImageService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Image image = dao.fetch( id );

            dao.delete( image );

            service.setResponse( new StandardResponse< ImageDTO >( new ImageDTO().mapper( image ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.PROPERTIES_SERVICE_DELETE_CODE,
                      Error.PROPERTIES_SERVICE_DELETE_LEVEL,
                      Error.PROPERTIES_SERVICE_DELETE_TEXT,
                      new StandardResponse< Image >() );
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

    public ImageService fetchAll()
    {

        final String TAG = "ItemsService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< ImageDTO >( new ImageDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.PROPERTIES_SERVICE_FETCH_ALL_CODE,
                      Error.PROPERTIES_SERVICE_FETCH_ALL_LEVEL,
                      Error.PROPERTIES_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< Image >() );
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

    public ImageService fetch( long id )
    {

        final String TAG = "ImageService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< ImageDTO >( new ImageDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.PROPERTIES_SERVICE_FETCH_CODE,
                      Error.PROPERTIES_SERVICE_FETCH_LEVEL,
                      Error.PROPERTIES_SERVICE_FETCH_TEXT,
                      new StandardResponse< Image >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );


        }
        return service;
    }

}
