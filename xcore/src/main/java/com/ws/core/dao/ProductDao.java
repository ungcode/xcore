
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Product;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class ProductDao< T >
    extends Dao< Product >
{

	@Override
    public void persist( Product product )
	{
        getEntityManager().persist( product );

	}

	@Override
    public void update( Product product )
	{
        getEntityManager().merge( product );
	}

	@Override
    public void delete( Product product )
	{
        getEntityManager().remove( product );

	}

    @Override
    public Product fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT p FROM Product p WHERE p.id =:id",
                                                      Product.class );
        query.setParameter( "id",
                            id );
        return ( Product )query.getSingleResult();
	}


    @Override
    public List< Product > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT p FROM Product p ",
                                               Product.class )
                                 .getResultList();
	}

	
}
