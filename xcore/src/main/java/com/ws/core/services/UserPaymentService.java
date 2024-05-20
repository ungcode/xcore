package com.ws.core.services;

import com.ws.core.dao.UserPaymentDao;
import com.ws.core.dto.UserPaymentDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.UserPayment;
import com.ws.core.response.StandardResponse;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class UserPaymentService
    extends StandardService< UserPayment >
{

    @Inject
    protected UserPaymentDao< UserPayment > dao;
    protected UserPaymentService        service = null;

    @PostConstruct
    public void init()
    {
        service = new UserPaymentService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store userPayment data in database
     * 
     * @param userPayment to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
    public UserPaymentService persist( UserPayment userPayment )
	{
        final String TAG = "UserPaymentService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            dao.persist( userPayment );
            service.setResponse( new StandardResponse< UserPaymentDTO >( new UserPaymentDTO().mapper( userPayment ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.USER_PAYMENT_SERVICE_PERSIST_CODE,
                      Error.USER_PAYMENT_SERVICE_PERSIST_LEVEL,
                      Error.USER_PAYMENT_SERVICE_PERSIST_TEXT,
                      new StandardResponse< UserPayment >() );

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}

    /**
     * updates userPayment with new supplied informations
     * 
     * @param __new object containing new userPayment information
     * @return service class operation result
     * @see StandardResponse
     */

    public UserPaymentService update( UserPayment __new )
    {

        final String TAG = "UserPaymentService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            UserPayment userPayment = dao.fetch( __new.getId() );

            userPayment.merge( __new,
                               userPayment );

            dao.update( userPayment );

            service.setResponse( new StandardResponse< UserPaymentDTO >( new UserPaymentDTO().mapper( userPayment ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.USER_PAYMENT_SERVICE_UPDATE_CODE,
                      Error.USER_PAYMENT_SERVICE_UPDATE_LEVEL,
                      Error.USER_PAYMENT_SERVICE_UPDATE_TEXT,
                      new StandardResponse< UserPayment >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete userPayment according to supplied identification
     * 
     * @param id identifies the userPayment to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public UserPaymentService delete( Long id )
    {

        final String TAG = "UserPaymentService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            UserPayment userPayment = dao.fetch( id );

            dao.delete( userPayment );

            service.setResponse( new StandardResponse< UserPaymentDTO >( new UserPaymentDTO().mapper( userPayment ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.USER_PAYMENT_SERVICE_DELETE_CODE,
                      Error.USER_PAYMENT_SERVICE_DELETE_LEVEL,
                      Error.USER_PAYMENT_SERVICE_DELETE_TEXT,
                      new StandardResponse< UserPayment >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted userPaymentes
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public UserPaymentService fetchAll()
    {

        final String TAG = "UserPaymentService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< UserPaymentDTO >( new UserPaymentDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.USER_PAYMENT_SERVICE_FETCH_ALL_CODE,
                      Error.USER_PAYMENT_SERVICE_FETCH_ALL_LEVEL,
                      Error.USER_PAYMENT_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< UserPayment >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve userPayment matching the supplied userPayment
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public UserPaymentService fetch( long id )
    {

        final String TAG = "UserPaymentService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< UserPaymentDTO >( new UserPaymentDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.USER_PAYMENT_SERVICE_FETCH_CODE,
                      Error.USER_PAYMENT_SERVICE_FETCH_LEVEL,
                      Error.USER_PAYMENT_SERVICE_FETCH_TEXT,
                      new StandardResponse< UserPayment >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
            System.out.println( e.getLocalizedMessage() );

        }
        return service;
    }

}
