package com.ws.core.services;

import com.ws.core.dao.ProductDao;
import com.ws.core.dto.ProductDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.Product;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProductService
    extends StandardService< Product >
{

    @Inject
    protected ProductDao< Product > dao;
    protected ProductService        service = null;

    @PostConstruct
    public void init()
    {
        service = new ProductService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store product data in database
     * 
     * @param product to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public ProductService persist( Product product )
	{
        final String TAG = "ProductService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( product );
            service.setResponse( new StandardResponse< ProductDTO >( new ProductDTO().mapper( product ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.PRODUCT_SERVICE_PERSIST_CODE,
                      Error.PRODUCT_SERVICE_PERSIST_LEVEL,
                      Error.PRODUCT_SERVICE_PERSIST_TEXT,
                      new StandardResponse< Product >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates product with new supplied informations
     * 
     * @param __new object containing new address information
     * @return service class operation result
     * @see StandardResponse
     */

    public ProductService update( Product __new )
    {

        final String TAG = "ProductService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Product product = dao.fetch( __new.getId() );

            product.merge( __new,
                           product );

            dao.update( product );

            service.setResponse( new StandardResponse< ProductDTO >( new ProductDTO().mapper( product ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.PRODUCT_SERVICE_UPDATE_CODE,
                      Error.PRODUCT_SERVICE_UPDATE_LEVEL,
                      Error.PRODUCT_SERVICE_UPDATE_TEXT,
                      new StandardResponse< Product >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete product according to supplied identification
     * 
     * @param id identifies the product to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public ProductService delete( Long id )
    {

        final String TAG = "ProductService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Product product = dao.fetch( id );

            dao.delete( product );

            service.setResponse( new StandardResponse< ProductDTO >( new ProductDTO().mapper( product ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.PRODUCT_SERVICE_DELETE_CODE,
                      Error.PRODUCT_SERVICE_DELETE_LEVEL,
                      Error.PRODUCT_SERVICE_DELETE_TEXT,
                      new StandardResponse< Product >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted products
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public ProductService fetchAll()
    {

        final String TAG = "ProductService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< ProductDTO >( new ProductDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.PRODUCT_SERVICE_FETCH_ALL_CODE,
                      Error.PRODUCT_SERVICE_FETCH_ALL_LEVEL,
                      Error.PRODUCT_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< Product >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve product matching the supplied address
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public ProductService fetch( long id )
    {

        final String TAG = "ProductService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< ProductDTO >( new ProductDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.PRODUCT_SERVICE_FETCH_CODE,
                      Error.PRODUCT_SERVICE_FETCH_LEVEL,
                      Error.PRODUCT_SERVICE_FETCH_TEXT,
                      new StandardResponse< Product >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );


        }
        return service;
    }

}
