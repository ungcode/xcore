
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Brand;
import com.ws.core.models.Product;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class BrandDao< T >
    extends Dao< Brand >
{

    @Override
    public void persist( Brand brand )
	{

        getEntityManager().persist( brand );

	}

	@Override
    public void update( Brand brand )
	{
        getEntityManager().merge( brand );
	}

	@Override
    public void delete( Brand brand )
	{
        getEntityManager().remove( brand );

	}

    @Override
    public Brand fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT b FROM Brand b WHERE b.id =:id",
                                                      Product.class );
        query.setParameter( "id",
                            id );
        return ( Brand )query.getSingleResult();
	}


    @Override
    public List< Brand > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT b FROM Brand b ",
                                               Brand.class )
                                 .getResultList();
	}

}
