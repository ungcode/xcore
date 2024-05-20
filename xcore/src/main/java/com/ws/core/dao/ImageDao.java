
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Image;
import com.ws.core.models.Product;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class ImageDao< T >
    extends Dao< Image >
{
    @Inject
    protected ProductDao< Product > productDao;
	@Override
    public void persist( Image image )
	{

        getEntityManager().persist( image );

	}

	@Override
    public void update( Image image )
	{
        add( image );
        getEntityManager().merge( image );
	}

	@Override
    public void delete( Image image )
	{
        getEntityManager().remove( image );

	}

    @Override
    public Image fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT i FROM image i WHERE i.id =:id",
                                                      Image.class );
        query.setParameter( "id",
                            id );
        return ( Image )query.getSingleResult();
	}


    @Override
    public List< Image > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT i FROM image i",
                                               Image.class )
                                 .getResultList();
	}

    private void add( Image image )
    {
        if( image.getProduct() != null
            && image.getProduct().getId() != null )
        {
            Product product = productDao.fetch( image.getProduct().getId() );
            image.setProduct( product );
        }
    }

	
}
