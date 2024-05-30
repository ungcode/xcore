
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Properties;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class PropertiesDao< T >
    extends Dao< Properties >
{

	@Override
    public Properties persist( Properties properties )
	{

        return mergeAndFlush( properties );

	}

	@Override
    public Properties update( Properties properties )
	{

        return mergeAndFlush( properties );
	}

	@Override
    public void delete( Properties properties )
	{
        entityManager().remove( properties );

	}

    @Override
    public Properties fetch( Long id )
	{
        Query query = entityManager().createQuery( "SELECT prop FROM Properties prop WHERE prop.id =:id",
                                                      Properties.class );
        query.setParameter( "id",
                            id );
        return ( Properties )query.getSingleResult();
	}


    @Override
    public List< Properties > fetchAll()
	{
        return entityManager().createQuery( "SELECT prop FROM properties prop",
                                               Properties.class )
                                 .getResultList();
	}


    @SuppressWarnings( "unchecked" )
    public List< Properties > fetchByProductId( Long id )
    {

        Query query = entityManager().createQuery( "SELECT prop FROM Properties prop"
                                                      + " WHERE prop.product.id =:productId",
                                                      Properties.class );
        query.setParameter( "productId",
                            id );

        List< Properties > properties = query.getResultList();

        return properties;
    }

	
}
