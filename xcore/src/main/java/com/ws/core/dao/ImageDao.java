
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Image;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class ImageDao< T >
    extends Dao< Image >
{

	@Override
    public Image persist( Image image )
	{
        return mergeAndFlush( image );

	}
	@Override
    public Image update( Image image )
	{

        return mergeAndFlush( image );
	}

	@Override
    public void delete( Image image )
	{
        entityManager().remove( image );

	}

    @Override
    public Image fetch( Long id )
	{
        Query query = entityManager().createQuery( "SELECT i FROM image i WHERE i.id =:id",
                                                      Image.class );
        query.setParameter( "id",
                            id );
        return ( Image )query.getSingleResult();
	}


    @Override
    public List< Image > fetchAll()
	{
        return entityManager().createQuery( "SELECT i FROM image i",
                                               Image.class )
                                 .getResultList();
	}

    @SuppressWarnings( "unchecked" )
    public List< Image > fetchByProductId( Long id )
    {
        Query query = entityManager().createQuery( "SELECT i FROM Image i"
                                                      + " WHERE i.product.id =:productId",
                                                      Image.class );
        query.setParameter( "productId",
                            id );

        List< Image > properties = query.getResultList();

        return properties;
    }
	
}
