
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Product;
import com.ws.core.models.Properties;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class PropertiesDao< T >
    extends Dao< Properties >
{
    @Inject
    protected ProductDao< Product > productDao;
	@Override
    public void persist( Properties properties )
	{

        getEntityManager().persist( properties );

	}

	@Override
    public void update( Properties properties )
	{
        add( properties );
        getEntityManager().merge( properties );
	}

	@Override
    public void delete( Properties properties )
	{
        getEntityManager().remove( properties );

	}

    @Override
    public Properties fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT prop FROM Properties prop WHERE prop.id =:id",
                                                      Properties.class );
        query.setParameter( "id",
                            id );
        return ( Properties )query.getSingleResult();
	}


    @Override
    public List< Properties > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT prop FROM properties prop",
                                               Properties.class )
                                 .getResultList();
	}

    private void add( Properties properties )
    {
        if( properties.getProduct() != null
            && properties.getProduct().getId() != null )
        {
            Product product = productDao.fetch( properties.getProduct().getId() );
            properties.setProduct( product );
        }
    }

	
}
