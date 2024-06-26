
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Cart;
import com.ws.core.models.CartProduct;
import com.ws.core.models.Product;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class CartProductDao< T >
    extends Dao< CartProduct >
{

    @Inject
    private CartDao< Cart >           cartDao;
    @Inject
    private ProductDao< Product > productDao;
	@Override
    public CartProduct persist( CartProduct cartProduct )
	{
        persistAndFlush( cartProduct );
        return cartProduct;

	}

	@Override
    public CartProduct update( CartProduct cartProduct )
	{
        add( cartProduct );
        return mergeAndFlush( cartProduct );
	}

	@Override
    public void delete( CartProduct cartProduct )
	{
        entityManager().remove( cartProduct );

	}

    @Override
    public CartProduct fetch( Long id )
	{
        Query query = entityManager().createQuery( "SELECT cp FROM CartProduct cp WHERE cp.id =:id",
                                                      CartProduct.class );
        query.setParameter( "id",
                            id );
        return ( CartProduct )query.getSingleResult();
	}


    @Override
    public List< CartProduct > fetchAll()
	{
        return entityManager().createQuery( "SELECT cp FROM CartProduct cp ",
                                               CartProduct.class )
                                 .getResultList();
	}

    private void add( CartProduct cartProduct )
    {
        if( cartProduct.getCart() != null
            && cartProduct.getCart().getId() != null )
        {
            Cart cart = cartDao.fetch( cartProduct.getCart().getId() );
            cartProduct.setCart( cart );
        }
        if( cartProduct.getProduct() != null
            && cartProduct.getProduct().getId() != null )
        {
            Product product = productDao.fetch( cartProduct.getProduct()
                                                                    .getId() );
            cartProduct.setProduct( product );
            ;
        }
    }

	
}
