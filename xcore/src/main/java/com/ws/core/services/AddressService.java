package com.ws.core.services;

import com.ws.core.dao.AddressDao;
import com.ws.core.dto.AddressDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.Address;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AddressService
    extends StandardService< Address >
{

    @Inject
    protected AddressDao< Address > dao;
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
	public AddressService persist(Address address) 
	{
        final String TAG = "AddressService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

			dao.persist(address);
            service.setResponse( new StandardResponse< AddressDTO >( new AddressDTO().mapper( address ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

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

    public AddressService update( Address __new )
    {

        final String TAG = "AddressService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

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
