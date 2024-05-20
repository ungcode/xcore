package com.ws.core.services;

import com.ws.core.dao.ProductDao;
import com.ws.core.dto.ProductDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.Product;
import com.ws.core.pagination.Pagination;
import com.ws.core.pagination.PaginationResult;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class ProductService
    extends StandardService< Product >
{

    @Inject
    protected ProductDao< Product > dao;
    protected ProductService            service = null;

    @PostConstruct
    public void init()
    {
        service = new ProductService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store productItem data in database
     * 
     * @param productItem to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public ProductService persist( Product productItem )
	{
        final String TAG = "ProductItemService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( productItem );
            service.setResponse( new StandardResponse< ProductDTO >( new ProductDTO().mapper( productItem ) ) );

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
     * updates productItem with new supplied informations
     * 
     * @param __new object containing new address information
     * @return service class operation result
     * @see StandardResponse
     */

    public ProductService update( Product __new )
    {

        final String TAG = "ProductItemService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Product productItem = dao.fetch( __new.getId() );

            productItem.merge( __new,
                               productItem );

            dao.update( productItem );

            service.setResponse( new StandardResponse< ProductDTO >( new ProductDTO().mapper( productItem ) ) );

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
     * delete productItem according to supplied identification
     * 
     * @param id identifies the productItem to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public ProductService delete( Long id )
    {

        final String TAG = "ProductItemService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Product productItem = dao.fetch( id );

            dao.delete( productItem );

            service.setResponse( new StandardResponse< ProductDTO >( new ProductDTO().mapper( productItem ) ) );

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
     * retrieve all related persisted productItems
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public ProductService fetchAll()
    {

        final String TAG = "ProductItemService.fetchAll";
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
     * retrieve productItem matching the supplied product item
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public ProductService fetch( long id )
    {

        final String TAG = "ProductItemService.fetch";
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

    @SuppressWarnings( { "rawtypes", "unchecked" } )
    public ProductService pagination( Pagination pagination )
    {

        final String TAG = "ProductItemService.pagination";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );


            PaginationResult paginationResult = dao.paginations( pagination );

            List< ProductDTO > products = new ProductDTO().mapper( paginationResult.getRecords() );
            paginationResult.setRecords( products );

            service.setResponse( new StandardResponse< PaginationResult >( paginationResult ) );

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
