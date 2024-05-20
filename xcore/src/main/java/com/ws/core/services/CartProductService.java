package com.ws.core.services;

import com.ws.core.dao.CartProductDao;
import com.ws.core.dto.CartProductDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.CartProduct;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CartProductService
    extends StandardService< CartProduct >
{

    @Inject
    protected CartProductDao< CartProduct > dao;
    protected CartProductService        service = null;

    @PostConstruct
    public void init()
    {
        service = new CartProductService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store cartProduct data in database
     * 
     * @param cartProduct to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public CartProductService persist( CartProduct cartProduct )
	{
        final String TAG = "CartProductService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( cartProduct );
            service.setResponse( new StandardResponse< CartProductDTO >( new CartProductDTO().mapper( cartProduct ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.CART_PRODUCT_SERVICE_PERSIST_CODE,
                      Error.CART_PRODUCT_SERVICE_PERSIST_LEVEL,
                      Error.CART_PRODUCT_SERVICE_PERSIST_TEXT,
                      new StandardResponse< CartProduct >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates cartProduct with new supplied informations
     * 
     * @param __new object containing new address information
     * @return service class operation result
     * @see StandardResponse
     */

    public CartProductService update( CartProduct __new )
    {

        final String TAG = "CartProductService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            CartProduct cartProduct = dao.fetch( __new.getId() );

            cartProduct.merge( __new,
                               cartProduct );

            dao.update( cartProduct );

            service.setResponse( new StandardResponse< CartProductDTO >( new CartProductDTO().mapper( cartProduct ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.CART_PRODUCT_SERVICE_UPDATE_CODE,
                      Error.CART_PRODUCT_SERVICE_UPDATE_LEVEL,
                      Error.CART_PRODUCT_SERVICE_UPDATE_TEXT,
                      new StandardResponse< CartProduct >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete cartProduct according to supplied identification
     * 
     * @param id identifies the cartProduct to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public CartProductService delete( Long id )
    {

        final String TAG = "CartProductService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            CartProduct cartProduct = dao.fetch( id );

            dao.delete( cartProduct );

            service.setResponse( new StandardResponse< CartProductDTO >( new CartProductDTO().mapper( cartProduct ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.CART_PRODUCT_SERVICE_DELETE_CODE,
                      Error.CART_PRODUCT_SERVICE_DELETE_LEVEL,
                      Error.CART_PRODUCT_SERVICE_DELETE_TEXT,
                      new StandardResponse< CartProduct >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted cartProducts
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public CartProductService fetchAll()
    {

        final String TAG = "CartItemsService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< CartProductDTO >( new CartProductDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.CART_PRODUCT_SERVICE_FETCH_ALL_CODE,
                      Error.CART_PRODUCT_SERVICE_FETCH_ALL_LEVEL,
                      Error.CART_PRODUCT_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< CartProduct >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve cartProduct matching the supplied cartProduct
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public CartProductService fetch( long id )
    {

        final String TAG = "CartProductService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< CartProductDTO >( new CartProductDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.CART_PRODUCT_SERVICE_FETCH_CODE,
                      Error.CART_PRODUCT_SERVICE_FETCH_LEVEL,
                      Error.CART_PRODUCT_SERVICE_FETCH_TEXT,
                      new StandardResponse< CartProduct >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );


        }
        return service;
    }

}
