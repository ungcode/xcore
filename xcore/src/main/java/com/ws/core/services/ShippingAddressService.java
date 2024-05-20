package com.ws.core.services;

import com.ws.core.dao.ShippingAddressDao;
import com.ws.core.dto.ShippingAddressDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.ShippingAddress;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ShippingAddressService
    extends StandardService< ShippingAddress >
{

    @Inject
    protected ShippingAddressDao< ShippingAddress > dao;
    protected ShippingAddressService        service = null;

    @PostConstruct
    public void init()
    {
        service = new ShippingAddressService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store shippingAddress data in database
     * 
     * @param shippingAddress to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public ShippingAddressService persist( ShippingAddress shippingAddress )
	{
        final String TAG = "ShippingAddressService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( shippingAddress );
            service.setResponse( new StandardResponse< ShippingAddressDTO >( new ShippingAddressDTO().mapper( shippingAddress ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.SHIPPING_ADDRESS_SERVICE_PERSIST_CODE,
                      Error.SHIPPING_ADDRESS_SERVICE_PERSIST_LEVEL,
                      Error.SHIPPING_ADDRESS_SERVICE_PERSIST_TEXT,
                      new StandardResponse< ShippingAddress >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates shippingAddress with new supplied informations
     * 
     * @param __new object containing new address information
     * @return service class operation result
     * @see StandardResponse
     */

    public ShippingAddressService update( ShippingAddress __new )
    {

        final String TAG = "ShippingAddressService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            ShippingAddress shippingAddress = dao.fetch( __new.getId() );

            shippingAddress.merge( __new,
                                   shippingAddress );

            dao.update( shippingAddress );

            service.setResponse( new StandardResponse< ShippingAddressDTO >( new ShippingAddressDTO().mapper( shippingAddress ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.SHIPPING_ADDRESS_SERVICE_UPDATE_CODE,
                      Error.SHIPPING_ADDRESS_SERVICE_UPDATE_LEVEL,
                      Error.SHIPPING_ADDRESS_SERVICE_UPDATE_TEXT,
                      new StandardResponse< ShippingAddress >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete shippingAddress according to supplied identification
     * 
     * @param id identifies the shippingAddress to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public ShippingAddressService delete( Long id )
    {

        final String TAG = "ShippingAddressService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            ShippingAddress shippingAddress = dao.fetch( id );

            dao.delete( shippingAddress );

            service.setResponse( new StandardResponse< ShippingAddressDTO >( new ShippingAddressDTO().mapper( shippingAddress ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.SHIPPING_ADDRESS_SERVICE_DELETE_CODE,
                      Error.SHIPPING_ADDRESS_SERVICE_DELETE_LEVEL,
                      Error.SHIPPING_ADDRESS_SERVICE_DELETE_TEXT,
                      new StandardResponse< ShippingAddress >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted shippingAddresss
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public ShippingAddressService fetchAll()
    {

        final String TAG = "ShippingAddresssService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< ShippingAddressDTO >( new ShippingAddressDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.SHIPPING_ADDRESS_SERVICE_FETCH_ALL_CODE,
                      Error.SHIPPING_ADDRESS_SERVICE_FETCH_ALL_LEVEL,
                      Error.SHIPPING_ADDRESS_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< ShippingAddress >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve shippingAddress matching the supplied shippingAddress
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public ShippingAddressService fetch( long id )
    {

        final String TAG = "ShippingAddressService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< ShippingAddressDTO >( new ShippingAddressDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.SHIPPING_ADDRESS_SERVICE_FETCH_CODE,
                      Error.SHIPPING_ADDRESS_SERVICE_FETCH_LEVEL,
                      Error.SHIPPING_ADDRESS_SERVICE_FETCH_TEXT,
                      new StandardResponse< ShippingAddress >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );


        }
        return service;
    }

}
