package com.ws.core.services;

import com.ws.core.dao.CountryDao;
import com.ws.core.dto.CountryDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.Country;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CountryService
    extends StandardService< Country >
{

    @Inject
    protected CountryDao< Country > dao;
    protected CountryService        service = null;

    @PostConstruct
    public void init()
    {
        service = new CountryService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store Country data in database
     * 
     * @param Country to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public CountryService persist( Country country )
	{
        final String TAG = "CountryService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( country );
            service.setResponse( new StandardResponse< CountryDTO >( new CountryDTO().mapper( country ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.COUNTRY_SERVICE_DELETE_CODE,
                      Error.COUNTRY_SERVICE_DELETE_LEVEL,
                      Error.COUNTRY_SERVICE_DELETE_TEXT,
                      new StandardResponse< Country >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates Country with new supplied informations
     * 
     * @param __new object containing new address information
     * @return service class operation result
     * @see StandardResponse
     */

    public CountryService update( Country __new )
    {

        final String TAG = "CountryService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Country Country = dao.fetch( __new.getId() );

            Country.merge( __new,
                           Country );

            dao.update( Country );

            service.setResponse( new StandardResponse< CountryDTO >( new CountryDTO().mapper( Country ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.COUNTRY_SERVICE_UPDATE_CODE,
                      Error.COUNTRY_SERVICE_UPDATE_LEVEL,
                      Error.COUNTRY_SERVICE_UPDATE_TEXT,
                      new StandardResponse< Country >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete Country according to supplied identification
     * 
     * @param id identifies the product to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public CountryService delete( Long id )
    {

        final String TAG = "CountryService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Country Country = dao.fetch( id );

            dao.delete( Country );

            service.setResponse( new StandardResponse< CountryDTO >( new CountryDTO().mapper( Country ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.COUNTRY_SERVICE_DELETE_CODE,
                      Error.COUNTRY_SERVICE_DELETE_LEVEL,
                      Error.COUNTRY_SERVICE_DELETE_TEXT,
                      new StandardResponse< Country >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted Countries
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public CountryService fetchAll()
    {

        final String TAG = "CountryService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< CountryDTO >( new CountryDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.COUNTRY_SERVICE_DELETE_CODE,
                      Error.COUNTRY_SERVICE_DELETE_LEVEL,
                      Error.COUNTRY_SERVICE_DELETE_TEXT,
                      new StandardResponse< Country >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve Country matching the supplied Country
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public CountryService fetch( long id )
    {

        final String TAG = "CountryService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< CountryDTO >( new CountryDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.COUNTRY_SERVICE_FETCH_CODE,
                      Error.COUNTRY_SERVICE_FETCH_LEVEL,
                      Error.COUNTRY_SERVICE_FETCH_TEXT,
                      new StandardResponse< Country >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );


        }
        return service;
    }

}
