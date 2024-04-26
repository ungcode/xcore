package com.ws.core.dao;

import com.ws.core.idao.Dao;
import com.ws.core.models.Size;
import jakarta.persistence.Query;
import java.util.List;


public class SizeDao< T >
    extends Dao< Size >
{


	@Override
    public void persist( Size size )
	{
        getEntityManager().persist( size );

	}

	@Override
    public void update( Size size )
	{
        getEntityManager().merge( size );
	}

	@Override
    public void delete( Size size )
	{
        getEntityManager().remove( size );

	}

	@Override
    public Size fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT s FROM Size s WHERE s.id =:id" );
        query.setParameter( "id",
                            id );
        return ( Size )query.getSingleResult();
	}

	@Override
    public List< Size > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT s FROM Size s",
                                               Size.class )
                                 .getResultList();
	}

}
