
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Address;
import com.ws.core.models.Tuser;
import com.ws.core.models.UserAddress;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class UserAddressDao< T >
    extends Dao< UserAddress >
{

    @Inject
    private UserDao< Tuser > userDao;
    @Inject
    private AddressDao< Address > addressDao;
	@Override
    public void persist( UserAddress userAddress )
	{

        getEntityManager().persist( userAddress );

	}

	@Override
    public void update( UserAddress userAddress )
	{
        add( userAddress );
        getEntityManager().merge( userAddress );
	}

	@Override
    public void delete( UserAddress userAddress )
	{
        getEntityManager().remove( userAddress );

	}

    @Override
    public UserAddress fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT ua FROM UserAddress ua WHERE ua.id =:id",
                                                      UserAddress.class );
        query.setParameter( "id",
                            id );
        return ( UserAddress )query.getSingleResult();
	}


    @Override
    public List< UserAddress > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT ua FROM UserAddress ua ",
                                               UserAddress.class )
                                 .getResultList();
	}

    private void add( UserAddress userAddress )
    {
        if( userAddress.getUser() != null
            && userAddress.getUser().getId() != null )
        {
            Tuser user = userDao.fetch( userAddress.getUser().getId() );
            userAddress.setUser( user );
        }
        if( userAddress.getAddress() != null
            && userAddress.getAddress().getId() != null )
        {
            Address address = addressDao.fetch( userAddress.getAddress()
                                                           .getId() );
            userAddress.setAddress( address );
        }
    }

}
