package com.ws.core.services;

import com.ws.core.dao.SizeDao;
import com.ws.core.dto.SizeDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.Size;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class SizeService
    extends StandardService< Size >
{

    @Inject
    protected SizeDao< Size > dao;
    protected SizeService        service = null;

    @PostConstruct
    public void init()
    {
        service = new SizeService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store size data in database
     * 
     * @param size to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public SizeService persist( Size size )
	{
        final String TAG = "SizeService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( size );
            service.setResponse( new StandardResponse< SizeDTO >( new SizeDTO().mapper( size ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.SIZE_SERVICE_PERSIST_CODE,
                      Error.SIZE_SERVICE_PERSIST_LEVEL,
                      Error.SIZE_SERVICE_PERSIST_TEXT,
                      new StandardResponse< Size >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates size with new supplied informations
     * 
     * @param __new object containing new size information
     * @return service class operation result
     * @see StandardResponse
     */

    public SizeService update( Size __new )
    {

        final String TAG = "SizeService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Size size = dao.fetch( __new.getId() );

            size.merge( __new,
                        size );

            dao.update( size );

            service.setResponse( new StandardResponse< SizeDTO >( new SizeDTO().mapper( size ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.SIZE_SERVICE_UPDATE_CODE,
                      Error.SIZE_SERVICE_UPDATE_LEVEL,
                      Error.SIZE_SERVICE_UPDATE_TEXT,
                      new StandardResponse< Size >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete size according to supplied identification
     * 
     * @param id identifies the product to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public SizeService delete( Long id )
    {

        final String TAG = "SizeService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Size size = dao.fetch( id );

            dao.delete( size );

            service.setResponse( new StandardResponse< SizeDTO >( new SizeDTO().mapper( size ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.SIZE_SERVICE_DELETE_CODE,
                      Error.SIZE_SERVICE_DELETE_LEVEL,
                      Error.SIZE_SERVICE_DELETE_TEXT,
                      new StandardResponse< Size >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted sizes
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public SizeService fetchAll()
    {

        final String TAG = "SIzeService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< SizeDTO >( new SizeDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.SIZE_SERVICE_FETCH_ALL_CODE,
                      Error.SIZE_SERVICE_FETCH_ALL_LEVEL,
                      Error.SIZE_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< Size >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve size matching the supplied size
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public SizeService fetch( long id )
    {

        final String TAG = "SizeService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< SizeDTO >( new SizeDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.SIZE_SERVICE_FETCH_CODE,
                      Error.SIZE_SERVICE_FETCH_LEVEL,
                      Error.SIZE_SERVICE_FETCH_TEXT,
                      new StandardResponse< Size >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );


        }
        return service;
    }

}
