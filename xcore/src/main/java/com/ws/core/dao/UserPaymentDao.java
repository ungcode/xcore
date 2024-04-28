
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
    public void persist( UserPayment userPayment )
	{

        getEntityManager().persist( userPayment );

	}

	@Override
    public void update( UserPayment userPayment )
	{
        addDependent( userPayment );
        getEntityManager().merge( userPayment );
	}

	@Override
    public void delete( UserPayment userPayment )
	{
        getEntityManager().remove( userPayment );

	}

    @Override
    public UserPayment fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT up FROM UserPayment up WHERE up.id =:id",
                                                      UserPayment.class );
        query.setParameter( "id",
                            id );
        return ( UserPayment )query.getSingleResult();
	}


    @Override
    public List< UserPayment > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT up FROM UserPayment up ",
                                               UserPayment.class )
                                 .getResultList();
	}

    private void addDependent( UserPayment userPayment )
    {
        if( userPayment.getUser() != null
            && userPayment.getUser().getId() != null )
        {
            Tuser user = userDao.fetch( userPayment.getUser().getId() );
            userPayment.setUser( user );
        }
    }

	
}
