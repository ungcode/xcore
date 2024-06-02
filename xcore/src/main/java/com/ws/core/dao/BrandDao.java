
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Brand;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class BrandDao< T >
    extends Dao< Brand >
{

    @Override
    public Brand persist( Brand brand )
	{
        persistAndFlush( brand );
        return brand;

	}

	@Override
    public Brand update( Brand brand )
	{
        return mergeAndFlush( brand );
	}

	@Override
    public void delete( Brand brand )
	{
        entityManager().remove( brand );

	}

    @Override
    public Brand fetch( Long id )
	{
        Query query = entityManager().createQuery( "SELECT b FROM Brand b WHERE b.id =:id",
                                                      Brand.class );
        query.setParameter( "id",
                            id );
        return ( Brand )query.getSingleResult();
	}


    @Override
    public List< Brand > fetchAll()
	{
        return entityManager().createQuery( "SELECT b FROM Brand b ",
                                               Brand.class )
                                 .getResultList();
	}

}
