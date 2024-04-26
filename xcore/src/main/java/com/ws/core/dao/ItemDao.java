
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Item;
import com.ws.core.models.Product;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class ItemDao< T >
    extends Dao< Item >
{
    @Inject
    protected ProductDao< Product > productDao;
	@Override
    public void persist( Item item )
	{
        handleProduct( item );
        getEntityManager().persist( item );

	}

    private void handleProduct( Item item )
    {
        if( item.getProduct() != null
            && item.getProduct().getId() != null )
        {
            Product product = productDao.fetch( item.getProduct().getId() );
            item.setProduct( product );
        }
    }

	@Override
    public void update( Item item )
	{
        getEntityManager().merge( item );
	}

	@Override
    public void delete( Item item )
	{
        getEntityManager().remove( item );

	}

    @Override
    public Item fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT i FROM Item i WHERE i.id =:id",
                                                      Item.class );
        query.setParameter( "id",
                            id );
        return ( Item )query.getSingleResult();
	}


    @Override
    public List< Item > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT i FROM Item i ",
                                               Item.class )
                                 .getResultList();
	}

	
}
