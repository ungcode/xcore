
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Tuser;
import com.ws.core.models.UserPayment;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class UserPaymentDao< T >
    extends Dao< UserPayment >
{

    @Inject
    private UserDao< Tuser > userDao;
	@Override
    public UserPayment persist( UserPayment userPayment )
	{

        persistAndFlush( userPayment );
        return userPayment;

	}

	@Override
    public UserPayment update( UserPayment userPayment )
	{
        add( userPayment );
        return mergeAndFlush( userPayment );
	}

	@Override
    public void delete( UserPayment userPayment )
	{
        entityManager().remove( userPayment );

	}

    @Override
    public UserPayment fetch( Long id )
	{
        Query query = entityManager().createQuery( "SELECT up FROM UserPayment up WHERE up.id =:id",
                                                      UserPayment.class );
        query.setParameter( "id",
                            id );
        return ( UserPayment )query.getSingleResult();
	}


    @Override
    public List< UserPayment > fetchAll()
	{
        return entityManager().createQuery( "SELECT up FROM UserPayment up ",
                                               UserPayment.class )
                                 .getResultList();
	}

    private void add( UserPayment userPayment )
    {
        if( userPayment.getUser() != null
            && userPayment.getUser().getId() != null )
        {
            Tuser user = userDao.fetch( userPayment.getUser().getId() );
            userPayment.setUser( user );
        }
    }

	
}
