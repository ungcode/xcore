
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Cart;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class CartDao< T >
    extends Dao< Cart >
{

	@Override
    public void persist( Cart cart )
	{
        getEntityManager().persist( cart );

	}

	@Override
    public void update( Cart cart )
	{
        getEntityManager().merge( cart );
	}

	@Override
    public void delete( Cart cart )
	{
        getEntityManager().remove( cart );

	}

    @Override
    public Cart fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT c FROM Cart c WHERE c.id =:id",
                                                      Cart.class );
        query.setParameter( "id",
                            id );
        return ( Cart )query.getSingleResult();
	}


    @Override
    public List< Cart > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT c FROM Cart c ",
                                               Cart.class )
                                 .getResultList();
	}

	
}
