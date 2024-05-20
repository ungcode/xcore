package com.ws.core.services;

import com.ws.core.dao.ShopOrderDao;
import com.ws.core.dto.ShopOrderDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.ShopOrder;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ShopOrderService
    extends StandardService< ShopOrder >
{

    @Inject
    protected ShopOrderDao< ShopOrder > dao;
    protected ShopOrderService        service = null;

    @PostConstruct
    public void init()
    {
        service = new ShopOrderService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store shopOrder data in database
     * 
     * @param shopOrder to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public ShopOrderService persist( ShopOrder shopOrder )
	{
        final String TAG = "ShopOrderService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( shopOrder );
            service.setResponse( new StandardResponse< ShopOrderDTO >( new ShopOrderDTO().mapper( shopOrder ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.SHOP_ORDER_SERVICE_PERSIST_CODE,
                      Error.SHOP_ORDER_SERVICE_PERSIST_LEVEL,
                      Error.SHOP_ORDER_SERVICE_PERSIST_TEXT,
                      new StandardResponse< ShopOrder >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates shopOrder with new supplied informations
     * 
     * @param __new object containing new shopOrder information
     * @return service class operation result
     * @see StandardResponse
     */

    public ShopOrderService update( ShopOrder __new )
    {

        final String TAG = "ShopOrderService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            ShopOrder shopOrder = dao.fetch( __new.getId() );

            shopOrder.merge( __new,
                             shopOrder );

            dao.update( shopOrder );

            service.setResponse( new StandardResponse< ShopOrderDTO >( new ShopOrderDTO().mapper( shopOrder ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.SHOP_ORDER_SERVICE_UPDATE_CODE,
                      Error.SHOP_ORDER_SERVICE_UPDATE_LEVEL,
                      Error.SHOP_ORDER_SERVICE_UPDATE_TEXT,
                      new StandardResponse< ShopOrder >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete shopOrder according to supplied identification
     * 
     * @param id identifies the shopOrder to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public ShopOrderService delete( Long id )
    {

        final String TAG = "ShopOrderService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            ShopOrder shopOrder = dao.fetch( id );

            dao.delete( shopOrder );

            service.setResponse( new StandardResponse< ShopOrderDTO >( new ShopOrderDTO().mapper( shopOrder ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.SHOP_ORDER_SERVICE_DELETE_CODE,
                      Error.SHOP_ORDER_SERVICE_DELETE_LEVEL,
                      Error.SHOP_ORDER_SERVICE_DELETE_TEXT,
                      new StandardResponse< ShopOrder >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted shopOrderes
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public ShopOrderService fetchAll()
    {

        final String TAG = "ShopOrderService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< ShopOrderDTO >( new ShopOrderDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.SHOP_ORDER_SERVICE_FETCH_ALL_CODE,
                      Error.SHOP_ORDER_SERVICE_FETCH_ALL_LEVEL,
                      Error.SHOP_ORDER_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< ShopOrder >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve shopOrder matching the supplied shopOrder
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public ShopOrderService fetch( long id )
    {

        final String TAG = "ShopOrderService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< ShopOrderDTO >( new ShopOrderDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.SHOP_ORDER_SERVICE_FETCH_CODE,
                      Error.SHOP_ORDER_SERVICE_FETCH_LEVEL,
                      Error.SHOP_ORDER_SERVICE_FETCH_TEXT,
                      new StandardResponse< ShopOrder >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );


        }
        return service;
    }

}
