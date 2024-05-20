package com.ws.core.services;

import com.ws.core.dao.UserReviewDao;
import com.ws.core.dto.UserReviewDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.UserReview;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class UserReviewService
    extends StandardService< UserReview >
{

    @Inject
    protected UserReviewDao< UserReview > dao;
    protected UserReviewService        service = null;

    @PostConstruct
    public void init()
    {
        service = new UserReviewService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store userReview data in database
     * 
     * @param userReview to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public UserReviewService persist( UserReview userReview )
	{
        final String TAG = "UserReviewService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( userReview );
            service.setResponse( new StandardResponse< UserReviewDTO >( new UserReviewDTO().mapper( userReview ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.USER_REVIEW_SERVICE_PERSIST_CODE,
                      Error.USER_REVIEW_SERVICE_PERSIST_LEVEL,
                      Error.USER_REVIEW_SERVICE_PERSIST_TEXT,
                      new StandardResponse< UserReview >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates userReview with new supplied informations
     * 
     * @param __new object containing new userReview information
     * @return service class operation result
     * @see StandardResponse
     */

    public UserReviewService update( UserReview __new )
    {

        final String TAG = "UserReviewService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            UserReview userReview = dao.fetch( __new.getId() );

            userReview.merge( __new,
                              userReview );

            dao.update( userReview );

            service.setResponse( new StandardResponse< UserReviewDTO >( new UserReviewDTO().mapper( userReview ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.USER_REVIEW_SERVICE_UPDATE_CODE,
                      Error.USER_REVIEW_SERVICE_UPDATE_LEVEL,
                      Error.USER_REVIEW_SERVICE_UPDATE_TEXT,
                      new StandardResponse< UserReview >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete userReview according to supplied identification
     * 
     * @param id identifies the userReview to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public UserReviewService delete( Long id )
    {

        final String TAG = "UserReviewService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            UserReview userReview = dao.fetch( id );

            dao.delete( userReview );

            service.setResponse( new StandardResponse< UserReviewDTO >( new UserReviewDTO().mapper( userReview ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.USER_REVIEW_SERVICE_DELETE_CODE,
                      Error.USER_REVIEW_SERVICE_DELETE_LEVEL,
                      Error.USER_REVIEW_SERVICE_DELETE_TEXT,
                      new StandardResponse< UserReview >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted userReviewes
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public UserReviewService fetchAll()
    {

        final String TAG = "UserReviewService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< UserReviewDTO >( new UserReviewDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.USER_REVIEW_SERVICE_FETCH_ALL_CODE,
                      Error.USER_REVIEW_SERVICE_FETCH_ALL_LEVEL,
                      Error.USER_REVIEW_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< UserReview >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve userReview matching the supplied userReview
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public UserReviewService fetch( long id )
    {

        final String TAG = "UserReviewService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< UserReviewDTO >( new UserReviewDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.USER_REVIEW_SERVICE_FETCH_CODE,
                      Error.USER_REVIEW_SERVICE_FETCH_LEVEL,
                      Error.USER_REVIEW_SERVICE_FETCH_TEXT,
                      new StandardResponse< UserReview >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

}
