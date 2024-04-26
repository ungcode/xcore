
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Item;
import com.ws.core.models.ProductItem;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class ProductItemDao< T >
    extends Dao< ProductItem >
{
    @Inject
    protected ItemDao< Item > itemDao;
	@Override
    public void persist( ProductItem productItem )
	{
        handleItem( productItem );
        getEntityManager().persist( productItem );

	}

    private void handleItem( ProductItem productItem )
    {
        if( productItem.getEntry() != null
            && productItem.getEntry().getId() != null )
        {
            Item item = itemDao.fetch( productItem.getEntry().getProduct()
                                                  .getId() );
            productItem.setEntry( item );
        }
    }

	@Override
    public void update( ProductItem productItem )
	{
        getEntityManager().merge( productItem );
	}

	@Override
    public void delete( ProductItem productItem )
	{
        getEntityManager().remove( productItem );

	}

    @Override
    public ProductItem fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT pitem FROM ProductItem pitem WHERE pitem.id =:id",
                                                      ProductItem.class );
        query.setParameter( "id",
                            id );
        return ( ProductItem )query.getSingleResult();
	}


    @Override
    public List< ProductItem > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT pitem FROM ProductItem pitem ",
                                               ProductItem.class )
                                 .getResultList();
	}

	
}
