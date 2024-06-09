package com.ws.core.services;

import com.ws.core.dao.AddressDao;
import com.ws.core.dao.CountryDao;
import com.ws.core.dto.AddressDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.Address;
import com.ws.core.models.Country;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.ParseJSON;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AddressService
    extends StandardService< Address >
{

    @Inject
    protected AddressDao< Address > dao;
    @Inject
    protected CountryDao< Country > countryDao;
    protected AddressService        service = null;

    @PostConstruct
    public void init()
    {
        service = new AddressService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store address data in database
     * 
     * @param address to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public AddressService persist( JsonObject data )
	{
        final String TAG = "AddressService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );
            ParseJSON obj = new ParseJSON( data );

            Address address = obj.GetObj( Address.class );

            // if exists country id fetch country to update country of address
            if( address.getCountry().getId() != null )
            {
                Long id = address.getCountry().getId();
                Country c = countryDao.fetch( id );
                address.setCountry( c );
            }

			dao.persist(address);
            service.setResponse( new StandardResponse< AddressDTO >( new AddressDTO().mapper( address ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {
            e.printStackTrace();
            setError( Error.ADDRESS_SERVICE_PERSIST_CODE,
                      Error.ADDRESS_SERVICE_PERSIST_LEVEL,
                      Error.ADDRESS_SERVICE_PERSIST_TEXT,
					 new StandardResponse<Address>());

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates address with new supplied informations
     * 
     * @param __new object containing new address information
     * @return service class operation result
     * @see StandardResponse
     */

    public AddressService update( JsonObject data )
    {

        final String TAG = "AddressService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            ParseJSON obj = new ParseJSON( data );
            Address __new = obj.GetObj( Address.class );
            Address address = dao.fetch( __new.getId() );

            address.merge( __new,
                             address );

            dao.update( address );

            service.setResponse( new StandardResponse< AddressDTO >( new AddressDTO().mapper( address ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.ADDRESS_SERVICE_UPDATE_CODE,
                      Error.ADDRESS_SERVICE_UPDATE_LEVEL,
                      Error.ADDRESS_SERVICE_UPDATE_TEXT,
                      new StandardResponse< Address >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete address according to supplied identification
     * 
     * @param id identifies the address to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public AddressService delete( Long id )
    {

        final String TAG = "AddressService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Address address = dao.fetch( id );

            dao.delete( address );

            service.setResponse( new StandardResponse< AddressDTO >( new AddressDTO().mapper( address ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.ADDRESS_SERVICE_DELETE_CODE,
                      Error.ADDRESS_SERVICE_DELETE_LEVEL,
                      Error.ADDRESS_SERVICE_DELETE_TEXT,
                      new StandardResponse< Address >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted addresses
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public AddressService fetchAll()
    {

        final String TAG = "AddressService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< AddressDTO >( new AddressDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.ADDRESS_SERVICE_FETCH_ALL_CODE,
                      Error.ADDRESS_SERVICE_FETCH_ALL_LEVEL,
                      Error.ADDRESS_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< Address >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve address matching the supplied address
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public AddressService fetch( long id )
    {

        final String TAG = "AddressService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< AddressDTO >( new AddressDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.ADDRESS_SERVICE_FETCH_CODE,
                      Error.ADDRESS_SERVICE_FETCH_LEVEL,
                      Error.ADDRESS_SERVICE_FETCH_TEXT,
                      new StandardResponse< Address >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
            System.out.println( e.getLocalizedMessage() );

        }
        return service;
    }

}
