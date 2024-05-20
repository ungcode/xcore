package com.ws.core.services;

import com.ws.core.dao.UserAddressDao;
import com.ws.core.dto.UserAddressDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.UserAddress;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class UserAddressService
    extends StandardService< UserAddress >
{

    @Inject
    protected UserAddressDao< UserAddress > dao;
    protected UserAddressService        service = null;

    @PostConstruct
    public void init()
    {
        service = new UserAddressService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store userAddress data in database
     * 
     * @param userAddress to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public UserAddressService persist( UserAddress userAddress )
	{
        final String TAG = "UserAddressService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( userAddress );
            service.setResponse( new StandardResponse< UserAddressDTO >( new UserAddressDTO().mapper( userAddress ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.USER_ADDRESS_SERVICE_PERSIST_CODE,
                      Error.USER_ADDRESS_SERVICE_PERSIST_LEVEL,
                      Error.USER_ADDRESS_SERVICE_PERSIST_TEXT,
                      new StandardResponse< UserAddress >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates userAddress with new supplied informations
     * 
     * @param __new object containing new userAddress information
     * @return service class operation result
     * @see StandardResponse
     */

    public UserAddressService update( UserAddress __new )
    {

        final String TAG = "UserAddressService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            UserAddress userAddress = dao.fetch( __new.getId() );

            userAddress.merge( __new,
                               userAddress );

            dao.update( userAddress );

            service.setResponse( new StandardResponse< UserAddressDTO >( new UserAddressDTO().mapper( userAddress ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.USER_ADDRESS_SERVICE_UPDATE_CODE,
                      Error.USER_ADDRESS_SERVICE_UPDATE_LEVEL,
                      Error.USER_ADDRESS_SERVICE_UPDATE_TEXT,
                      new StandardResponse< UserAddress >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete userAddress according to supplied identification
     * 
     * @param id identifies the userAddress to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public UserAddressService delete( Long id )
    {

        final String TAG = "UserAddressService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            UserAddress userAddress = dao.fetch( id );

            dao.delete( userAddress );

            service.setResponse( new StandardResponse< UserAddressDTO >( new UserAddressDTO().mapper( userAddress ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.USER_ADDRESS_SERVICE_DELETE_CODE,
                      Error.USER_ADDRESS_SERVICE_DELETE_LEVEL,
                      Error.USER_ADDRESS_SERVICE_DELETE_TEXT,
                      new StandardResponse< UserAddress >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted userAddresses
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public UserAddressService fetchAll()
    {

        final String TAG = "UserAddressService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< UserAddressDTO >( new UserAddressDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.USER_ADDRESS_SERVICE_FETCH_ALL_CODE,
                      Error.USER_ADDRESS_SERVICE_FETCH_ALL_LEVEL,
                      Error.USER_ADDRESS_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< UserAddress >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve userAddress matching the supplied userAddress
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public UserAddressService fetch( long id )
    {

        final String TAG = "UserAddressService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< UserAddressDTO >( new UserAddressDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.USER_ADDRESS_SERVICE_FETCH_CODE,
                      Error.USER_ADDRESS_SERVICE_FETCH_LEVEL,
                      Error.USER_ADDRESS_SERVICE_FETCH_TEXT,
                      new StandardResponse< UserAddress >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
            System.out.println( e.getLocalizedMessage() );

        }
        return service;
    }

}
