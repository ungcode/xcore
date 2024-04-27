
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.CartItem;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class CartItemDao< T >
    extends Dao< CartItem >
{

	@Override
    public void persist( CartItem cartItem )
	{
        getEntityManager().persist( cartItem );

	}

	@Override
    public void update( CartItem cartItem )
	{
        getEntityManager().merge( cartItem );
	}

	@Override
    public void delete( CartItem cartItem )
	{
        getEntityManager().remove( cartItem );

	}

    @Override
    public CartItem fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT ci FROM CartItem ci WHERE ci.id =:id",
                                                      CartItem.class );
        query.setParameter( "id",
                            id );
        return ( CartItem )query.getSingleResult();
	}


    @Override
    public List< CartItem > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT ci FROM CartItem ci ",
                                               CartItem.class )
                                 .getResultList();
	}

	
}
