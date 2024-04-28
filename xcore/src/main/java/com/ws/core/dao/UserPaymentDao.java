
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.UserPayment;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class UserPaymentDao< T >
    extends Dao< UserPayment >
{

	@Override
    public void persist( UserPayment userPayment )
	{
        getEntityManager().persist( userPayment );

	}

	@Override
    public void update( UserPayment userPayment )
	{
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

	
}
