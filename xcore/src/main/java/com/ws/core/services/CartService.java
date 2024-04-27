package com.ws.core.services;

import com.ws.core.dao.CartDao;
import com.ws.core.dto.CartDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.Cart;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CartService
    extends StandardService< Cart >
{

    @Inject
    protected CartDao< Cart > dao;
    protected CartService        service = null;

    @PostConstruct
    public void init()
    {
        service = new CartService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store cart data in database
     * 
     * @param cart to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public CartService persist( Cart cart )
	{
        final String TAG = "CartService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( cart );
            service.setResponse( new StandardResponse< CartDTO >( new CartDTO().mapper( cart ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.CART_SERVICE_PERSIST_CODE,
                      Error.CART_SERVICE_PERSIST_LEVEL,
                      Error.CART_SERVICE_PERSIST_TEXT,
                      new StandardResponse< Cart >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates cart with new supplied informations
     * 
     * @param __new object containing new address information
     * @return service class operation result
     * @see StandardResponse
     */

    public CartService update( Cart __new )
    {

        final String TAG = "CartService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Cart cart = dao.fetch( __new.getId() );

            cart.merge( __new,
                        cart );

            dao.update( cart );

            service.setResponse( new StandardResponse< CartDTO >( new CartDTO().mapper( cart ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.CART_SERVICE_UPDATE_CODE,
                      Error.CART_SERVICE_UPDATE_LEVEL,
                      Error.CART_SERVICE_UPDATE_TEXT,
                      new StandardResponse< Cart >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete cart according to supplied identification
     * 
     * @param id identifies the cart to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public CartService delete( Long id )
    {

        final String TAG = "CartService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Cart cart = dao.fetch( id );

            dao.delete( cart );

            service.setResponse( new StandardResponse< CartDTO >( new CartDTO().mapper( cart ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.CART_SERVICE_DELETE_CODE,
                      Error.CART_SERVICE_DELETE_LEVEL,
                      Error.CART_SERVICE_DELETE_TEXT,
                      new StandardResponse< Cart >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted carts
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public CartService fetchAll()
    {

        final String TAG = "CartsService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< CartDTO >( new CartDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.CART_SERVICE_FETCH_ALL_CODE,
                      Error.CART_SERVICE_FETCH_ALL_LEVEL,
                      Error.CART_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< Cart >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve cart matching the supplied cart
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public CartService fetch( long id )
    {

        final String TAG = "CartService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< CartDTO >( new CartDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.CART_SERVICE_FETCH_CODE,
                      Error.CART_SERVICE_FETCH_LEVEL,
                      Error.CART_SERVICE_FETCH_TEXT,
                      new StandardResponse< Cart >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );


        }
        return service;
    }

}
