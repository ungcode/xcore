package com.ws.core.services;

import com.ws.core.dao.BrandDao;
import com.ws.core.dto.BrandDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.Brand;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.ParseJSON;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class BrandService
    extends StandardService< Brand >
{

    @Inject
    protected BrandDao< Brand > dao;
    protected BrandService        service = null;

    @PostConstruct
    public void init()
    {
        service = new BrandService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store brand data in database
     * 
     * @param data to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public BrandService persist( JsonObject data )
	{
        final String TAG = "BrandService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );
            ParseJSON obj = new ParseJSON( data );
            Brand brand = obj.GetObj( Brand.class );
            dao.persist( brand );
            service.setResponse( new StandardResponse< BrandDTO >( new BrandDTO().mapper( brand ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.BRAND_SERVICE_PERSIST_CODE,
                      Error.BRAND_SERVICE_PERSIST_LEVEL,
                      Error.BRAND_SERVICE_PERSIST_TEXT,
                      new StandardResponse< Brand >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates brand with new supplied informations
     * 
     * @param __new object containing new brand information
     * @return service class operation result
     * @see StandardResponse
     */

    public BrandService update( JsonObject data )
    {

        final String TAG = "BrandService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            ParseJSON obj = new ParseJSON( data );
            Brand __new = obj.GetObj( Brand.class );
            Brand brand = dao.fetch( __new.getId() );

            brand.merge( __new,
                         brand );

            dao.update( brand );

            service.setResponse( new StandardResponse< BrandDTO >( new BrandDTO().mapper( brand ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.BRAND_SERVICE_UPDATE_CODE,
                      Error.BRAND_SERVICE_UPDATE_LEVEL,
                      Error.BRAND_SERVICE_UPDATE_TEXT,
                      new StandardResponse< Brand >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete brand according to supplied identification
     * 
     * @param id identifies the brand to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public BrandService delete( Long id )
    {

        final String TAG = "BrandService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Brand brand = dao.fetch( id );

            dao.delete( brand );

            service.setResponse( new StandardResponse< BrandDTO >( new BrandDTO().mapper( brand ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.BRAND_SERVICE_DELETE_CODE,
                      Error.BRAND_SERVICE_DELETE_LEVEL,
                      Error.BRAND_SERVICE_DELETE_TEXT,
                      new StandardResponse< Brand >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted brands
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public BrandService fetchAll()
    {

        final String TAG = "BrandService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< BrandDTO >( new BrandDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.BRAND_SERVICE_FETCH_ALL_CODE,
                      Error.BRAND_SERVICE_FETCH_ALL_LEVEL,
                      Error.BRAND_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< Brand >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve brand matching the supplied address
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public BrandService fetch( long id )
    {

        final String TAG = "BrandService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< BrandDTO >( new BrandDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.BRAND_SERVICE_FETCH_CODE,
                      Error.BRAND_SERVICE_FETCH_LEVEL,
                      Error.BRAND_SERVICE_FETCH_TEXT,
                      new StandardResponse< Brand >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );


        }
        return service;
    }

}
