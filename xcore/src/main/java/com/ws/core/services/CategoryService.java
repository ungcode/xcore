package com.ws.core.services;

import com.ws.core.dao.CategoryDao;
import com.ws.core.dto.CategoryDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.Category;
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
public class CategoryService
    extends StandardService< Category >
{

    @Inject
    protected CategoryDao< Category > dao;
    protected CategoryService        service = null;

    @PostConstruct
    public void init()
    {
        service = new CategoryService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store category data in database
     * 
     * @param category to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public CategoryService persist( Category category )
	{
        final String TAG = "CategoryServce.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( category );
            service.setResponse( new StandardResponse< CategoryDTO >( new CategoryDTO().mapper( category ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.CATEGORY_SERVICE_PERSIST_CODE,
                      Error.CATEGORY_SERVICE_PERSIST_LEVEL,
                      Error.CATEGORY_SERVICE_PERSIST_TEXT,
                      new StandardResponse< Category >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates category with new supplied informations
     * 
     * @param __new object containing new category information
     * @return service class operation result
     * @see StandardResponse
     */

    public CategoryService update( Category __new )
    {

        final String TAG = "CategoryService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Category category = dao.fetch( __new.getId() );

            category.merge( __new,
                            category );

            dao.update( category );

            service.setResponse( new StandardResponse< CategoryDTO >( new CategoryDTO().mapper( category ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.CATEGORY_SERVICE_UPDATE_CODE,
                      Error.CATEGORY_SERVICE_UPDATE_LEVEL,
                      Error.CATEGORY_SERVICE_UPDATE_TEXT,
                      new StandardResponse< Category >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete category according to supplied identification
     * 
     * @param id identifies the category to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public CategoryService delete( Long id )
    {

        final String TAG = "CategoryService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Category category = dao.fetch( id );

            dao.delete( category );

            service.setResponse( new StandardResponse< CategoryDTO >( new CategoryDTO().mapper( category ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.CATEGORY_SERVICE_DELETE_CODE,
                      Error.CATEGORY_SERVICE_DELETE_LEVEL,
                      Error.CATEGORY_SERVICE_DELETE_TEXT,
                      new StandardResponse< Category >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted categories
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public CategoryService fetchAll()
    {

        final String TAG = "CategoryService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            List< Category > categories = dao.fetchAll();
            service.setResponse( new StandardResponse< CategoryDTO >( new CategoryDTO().mapper( categories ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.CATEGORY_SERVICE_FETCH_ALL_CODE,
                      Error.CATEGORY_SERVICE_FETCH_ALL_LEVEL,
                      Error.CATEGORY_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< Category >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve category matching the supplied category
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public CategoryService fetch( long id )
    {

        final String TAG = "CategoryService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< CategoryDTO >( new CategoryDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.CATEGORY_SERVICE_FETCH_CODE,
                      Error.CATEGORY_SERVICE_FETCH_LEVEL,
                      Error.CATEGORY_SERVICE_FETCH_TEXT,
                      new StandardResponse< Category >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );



        }
        return service;
    }

}
