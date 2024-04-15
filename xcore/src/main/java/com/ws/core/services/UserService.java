package com.ws.core.services;

import com.ws.core.dao.UserDao;
import com.ws.core.dto.UserDTO;
import com.ws.core.interceptors.Common;
import com.ws.core.models.Tuser;
import com.ws.core.response.StandardResponse;
import com.ws.core.security.PasswordManager;
import com.ws.core.util.Error;
import com.ws.core.util.XcoreLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.Properties;


@ApplicationScoped
@Transactional
public class UserService 
extends StandardService< Tuser >
{

	@Inject
	UserDao<Tuser> dao;
	@Inject
	PasswordManager passwordManager;
    protected UserService        service = null;

    @PostConstruct
    public void init()
    {
        service = new UserService();
        service.setResponse( getResponse() );
    }
    
    /**
     * store user data in database
     * 
     * @param user to be saved
     * @return service class operation result
     * @see StandardResponse
     */
	@Common
	public UserService persist(Tuser user) 
	{
        final String TAG = "UserService.persist";

        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );


			Properties properties = passwordManager.getProperties(user.getPassword());
			user.setHash(properties.getProperty(PasswordManager.HASHED));
			user.setSalt(properties.getProperty(PasswordManager.SALT));
			dao.persist(user);
			service.setResponse( new StandardResponse< UserDTO >( new UserDTO().mapper( user ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

		} catch (Exception e) {

            setError( Error.USER_SERVICE_PERSIST_CODE,
                      Error.USER_SERVICE_PERSIST_LEVEL,
                      Error.USER_SERVICE_PERSIST_TEXT,
					 new StandardResponse<Tuser>());

            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
		}

        return service;
	}
	/**
     * updates user with new supplied informations
     * 
     * @param __new object containing new user information
     * @return service class operation result
     * @see StandardResponse
     */

    public UserService update( Tuser __new )
    {

        final String TAG = "UserService.update";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Tuser user = dao.fetch( __new.getId());
            user.merge( __new,
                             user );

            dao.update( user );

            service.setResponse( new StandardResponse< UserDTO >( new UserDTO().mapper( user ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.USER_SERVICE_UPDATE_CODE,
                      Error.USER_SERVICE_UPDATE_LEVEL,
                      Error.USER_SERVICE_UPDATE_TEXT,
                      new StandardResponse< Tuser >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * delete address according to supplied identification
     * 
     * @param id identifies the address to be removed
     * @return service class operation result
     * @see StandardResponse
     */

    public UserService delete( Long id )
    {

        final String TAG = "UserService.delete";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            Tuser user = dao.fetch( id );

            dao.delete( user );

            service.setResponse( new StandardResponse< UserDTO >( new UserDTO().mapper( user ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {

            setError( Error.USER_SERVICE_DELETE_CODE,
                      Error.USER_SERVICE_DELETE_LEVEL,
                      Error.USER_SERVICE_DELETE_TEXT,
                      new StandardResponse< Tuser >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );
        }

        return service;

    }

    /**
     * retrieve all related persisted addresses
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public UserService fetchAll()
    {

        final String TAG = "UserService.fetchAll";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< UserDTO >( new UserDTO().mapper( dao.fetchAll() ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.USER_SERVICE_FETCH_ALL_CODE,
                      Error.USER_SERVICE_FETCH_ALL_LEVEL,
                      Error.USER_SERVICE_FETCH_ALL_TEXT,
                      new StandardResponse< Tuser >() );
            service.setResponse( getResponse() );
            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }

    /**
     * retrieve address matching the supplied address
     * 
     * @return service class operation result
     * @see StandardResponse
     */

    public UserService fetch( long id )
    {

        final String TAG = "UserService.fetch";
        try
        {
            XcoreLogger.info( TAG,
                              XcoreLogger.START );

            service.setResponse( new StandardResponse< UserDTO >( new UserDTO().mapper( dao.fetch( id ) ) ) );

            XcoreLogger.info( TAG,
                              XcoreLogger.END );

        }
        catch( Exception e )
        {
            setError( Error.USER_SERVICE_FETCH_CODE,
                      Error.USER_SERVICE_FETCH_LEVEL,
                      Error.USER_SERVICE_FETCH_TEXT,
                      new StandardResponse< Tuser >() );
            service.setResponse( getResponse() );

            XcoreLogger.error( TAG,
                              e.getMessage() );

        }
        return service;
    }
}
