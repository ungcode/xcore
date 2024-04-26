package com.ws.core.services;

import com.ws.core.dao.ItemDao;
import com.ws.core.dto.ItemDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.Item;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ItemService
    extends StandardService< Item >
{

    @Inject
    protected ItemDao< Item > dao;
    protected ItemService        service = null;

    @PostConstruct
    public void init()
    {
        service = new ItemService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store item data in database
     * 
     * @param item to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public ItemService persist( Item item )
	{
        final String TAG = "ItemService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( item );
            service.setResponse( new StandardResponse< ItemDTO >( new ItemDTO().mapper( item ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.ITEM_SERVICE_PERSIST_CODE,
                      Error.ITEM_SERVICE_PERSIST_LEVEL,
                      Error.ITEM_SERVICE_PERSIST_TEXT,
                      new StandardResponse< Item >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates item with new supplied informations
     * 
     * @param __new object containing new address information
     * @return service class operation result
     * @see StandardResponse
     */

    public ItemService update( Item __new )
    {

        final String TAG = "ItemService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Item item = dao.fetch( __new.getId() );

            item.merge( __new,
                        item );

            dao.update( item );

            service.setResponse( new StandardResponse< ItemDTO >( new ItemDTO().mapper( item ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.ITEM_SERVICE_UPDATE_CODE,
                      Error.ITEM_SERVICE_UPDATE_LEVEL,
                      Error.ITEM_SERVICE_UPDATE_TEXT,
                      new StandardResponse< Item >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete item according to supplied identification
     * 
     * @param id identifies the item to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public ItemService delete( Long id )
    {

        final String TAG = "ItemService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Item item = dao.fetch( id );

            dao.delete( item );

            service.setResponse( new StandardResponse< ItemDTO >( new ItemDTO().mapper( item ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.ITEM_SERVICE_DELETE_CODE,
                      Error.ITEM_SERVICE_DELETE_LEVEL,
                      Error.ITEM_SERVICE_DELETE_TEXT,
                      new StandardResponse< Item >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted items
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public ItemService fetchAll()
    {

        final String TAG = "ItemsService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< ItemDTO >( new ItemDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.ITEM_SERVICE_FETCH_ALL_CODE,
                      Error.ITEM_SERVICE_FETCH_ALL_LEVEL,
                      Error.ITEM_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< Item >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve item matching the supplied item
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public ItemService fetch( long id )
    {

        final String TAG = "ItemService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< ItemDTO >( new ItemDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.ITEM_SERVICE_FETCH_CODE,
                      Error.ITEM_SERVICE_FETCH_LEVEL,
                      Error.ITEM_SERVICE_FETCH_TEXT,
                      new StandardResponse< Item >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );


        }
        return service;
    }

}
