
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.ShippingAddress;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class ShippingAddressDao< T >
    extends Dao< ShippingAddress >
{

	@Override
    public void persist( ShippingAddress shoppingAddress )
	{
        getEntityManager().persist( shoppingAddress );

	}

	@Override
    public void update( ShippingAddress shoppingAddress )
	{
        getEntityManager().merge( shoppingAddress );
	}

	@Override
    public void delete( ShippingAddress shoppingAddress )
	{
        getEntityManager().remove( shoppingAddress );

	}

    @Override
    public ShippingAddress fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT sh FROM ShippingAddress sh WHERE sh.id =:id",
                                                      ShippingAddress.class );
        query.setParameter( "id",
                            id );
        return ( ShippingAddress )query.getSingleResult();
	}


    @Override
    public List< ShippingAddress > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT sh FROM ShippingAddress sh ",
                                               ShippingAddress.class )
                                 .getResultList();
	}

	
}
