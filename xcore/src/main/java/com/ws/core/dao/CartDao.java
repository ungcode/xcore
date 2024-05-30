
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Cart;
import com.ws.core.models.Tuser;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class CartDao< T >
    extends Dao< Cart >
{

    @Inject
    private UserDao< Tuser > userDao;
	@Override
    public Cart persist( Cart cart )
	{
        persistAndFlush( cart );
        
        return cart;

	}

	@Override
    public Cart update( Cart cart )
	{
        add( cart );
        return mergeAndFlush( cart );
	}

	@Override
    public void delete( Cart cart )
	{
        entityManager().remove( cart );

	}

    @Override
    public Cart fetch( Long id )
	{
        Query query = entityManager().createQuery( "SELECT c FROM Cart c WHERE c.id =:id",
                                                      Cart.class );
        query.setParameter( "id",
                            id );
        return ( Cart )query.getSingleResult();
	}


    @Override
    public List< Cart > fetchAll()
	{
        return entityManager().createQuery( "SELECT c FROM Cart c ",
                                               Cart.class )
                                 .getResultList();
	}

    private void add( Cart cart )
    {
        if( cart.getUser() != null
            && cart.getUser().getId() != null )
        {
            Tuser user = userDao.fetch( cart.getUser().getId() );
            cart.setUser( user );
        }
    }
	
}
