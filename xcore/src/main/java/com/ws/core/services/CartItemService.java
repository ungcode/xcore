package com.ws.core.services;

import com.ws.core.dao.CartItemDao;
import com.ws.core.dto.CartItemDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.CartItem;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CartItemService
    extends StandardService< CartItem >
{

    @Inject
    protected CartItemDao< CartItem > dao;
    protected CartItemService        service = null;

    @PostConstruct
    public void init()
    {
        service = new CartItemService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store cartItem data in database
     * 
     * @param cartItem to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public CartItemService persist( CartItem cartItem )
	{
        final String TAG = "CartItemService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( cartItem );
            service.setResponse( new StandardResponse< CartItemDTO >( new CartItemDTO().mapper( cartItem ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.CART_ITEM_SERVICE_PERSIST_CODE,
                      Error.CART_ITEM_SERVICE_PERSIST_LEVEL,
                      Error.CART_ITEM_SERVICE_PERSIST_TEXT,
                      new StandardResponse< CartItem >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates cartItem with new supplied informations
     * 
     * @param __new object containing new address information
     * @return service class operation result
     * @see StandardResponse
     */

    public CartItemService update( CartItem __new )
    {

        final String TAG = "CartItemService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            CartItem cartItem = dao.fetch( __new.getId() );

            cartItem.merge( __new,
                            cartItem );

            dao.update( cartItem );

            service.setResponse( new StandardResponse< CartItemDTO >( new CartItemDTO().mapper( cartItem ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.CART_ITEM_SERVICE_UPDATE_CODE,
                      Error.CART_ITEM_SERVICE_UPDATE_LEVEL,
                      Error.CART_ITEM_SERVICE_UPDATE_TEXT,
                      new StandardResponse< CartItem >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete cartItem according to supplied identification
     * 
     * @param id identifies the cartItem to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public CartItemService delete( Long id )
    {

        final String TAG = "CartItemService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            CartItem cartItem = dao.fetch( id );

            dao.delete( cartItem );

            service.setResponse( new StandardResponse< CartItemDTO >( new CartItemDTO().mapper( cartItem ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.CART_ITEM_SERVICE_DELETE_CODE,
                      Error.CART_ITEM_SERVICE_DELETE_LEVEL,
                      Error.CART_ITEM_SERVICE_DELETE_TEXT,
                      new StandardResponse< CartItem >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted cartItems
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public CartItemService fetchAll()
    {

        final String TAG = "CartItemsService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< CartItemDTO >( new CartItemDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.CART_ITEM_SERVICE_FETCH_ALL_CODE,
                      Error.CART_ITEM_SERVICE_FETCH_ALL_LEVEL,
                      Error.CART_ITEM_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< CartItem >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve cartItem matching the supplied cartItem
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public CartItemService fetch( long id )
    {

        final String TAG = "CartItemService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< CartItemDTO >( new CartItemDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.CART_ITEM_SERVICE_FETCH_CODE,
                      Error.CART_ITEM_SERVICE_FETCH_LEVEL,
                      Error.CART_ITEM_SERVICE_FETCH_TEXT,
                      new StandardResponse< CartItem >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );


        }
        return service;
    }

}
