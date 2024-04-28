
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Cart;
import com.ws.core.models.CartItem;
import com.ws.core.models.Product;
import com.ws.core.models.ProductItem;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class CartItemDao< T >
    extends Dao< CartItem >
{

    @Inject
    private CartDao< Cart >           cartDao;
    @Inject
    private ProductItemDao< Product > productItemDao;
	@Override
    public void persist( CartItem cartItem )
	{
        getEntityManager().persist( cartItem );

	}

	@Override
    public void update( CartItem cartItem )
	{
        add( cartItem );
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

    private void add( CartItem cartItem )
    {
        if( cartItem.getCart() != null
            && cartItem.getCart().getId() != null )
        {
            Cart cart = cartDao.fetch( cartItem.getCart().getId() );
            cartItem.setCart( cart );
        }
        if( cartItem.getProductItem() != null
            && cartItem.getProductItem().getId() != null )
        {
            ProductItem productItem = productItemDao.fetch( cartItem.getProductItem()
                                                                    .getId() );
            cartItem.setProductItem( productItem );
            ;
        }
    }

	
}
