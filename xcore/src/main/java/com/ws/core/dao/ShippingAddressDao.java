
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Address;
import com.ws.core.models.ShippingAddress;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class ShippingAddressDao< T >
    extends Dao< ShippingAddress >
{

    @Inject
    private AddressDao< Address > addressDao;
	@Override
    public ShippingAddress persist( ShippingAddress shippingAddress )
	{
        persistAndFlush( shippingAddress );
        return shippingAddress;

	}

	@Override
    public ShippingAddress update( ShippingAddress shoppingAddress )
	{
        add( shoppingAddress );
        return mergeAndFlush( shoppingAddress );
	}

	@Override
    public void delete( ShippingAddress shoppingAddress )
	{
        entityManager().remove( shoppingAddress );

	}

    @Override
    public ShippingAddress fetch( Long id )
	{
        Query query = entityManager().createQuery( "SELECT sh FROM ShippingAddress sh WHERE sh.id =:id",
                                                      ShippingAddress.class );
        query.setParameter( "id",
                            id );
        return ( ShippingAddress )query.getSingleResult();
	}


    @Override
    public List< ShippingAddress > fetchAll()
	{
        return entityManager().createQuery( "SELECT sh FROM ShippingAddress sh ",
                                               ShippingAddress.class )
                                 .getResultList();
	}

    private void add( ShippingAddress shippingAddress )
    {
        if( shippingAddress.getAddress() != null
            && shippingAddress.getAddress().getId() != null )
        {
            Address address = addressDao.fetch( shippingAddress.getAddress()
                                                               .getId() );
            shippingAddress.setAddress( address );
        }
    }

	
}
