
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

        getEntityManager().persist( productItem );

	}

	@Override
    public void update( ProductItem productItem )
	{
        add( productItem );
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

    private void add( ProductItem productItem )
    {
        if( productItem.getItem() != null
            && productItem.getItem().getId() != null )
        {
            Item item = itemDao.fetch( productItem.getItem().getProduct()
                                                  .getId() );
            productItem.setItem( item );
        }
    }

	
}
