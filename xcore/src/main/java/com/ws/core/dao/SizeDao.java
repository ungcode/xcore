package com.ws.core.dao;

import com.ws.core.idao.Dao;
import com.ws.core.models.Size;
import jakarta.persistence.Query;
import java.util.List;


public class SizeDao< T >
    extends Dao< Size >
{


	@Override
    public Size persist( Size size )
	{
        persistAndFlush( size );
        return size;

	}

	@Override
    public Size update( Size size )
	{
        return mergeAndFlush( size );
	}

	@Override
    public void delete( Size size )
	{
        entityManager().remove( size );

	}

	@Override
    public Size fetch( Long id )
	{
        Query query = entityManager().createQuery( "SELECT s FROM Size s WHERE s.id =:id" );
        query.setParameter( "id",
                            id );
        return ( Size )query.getSingleResult();
	}

	@Override
    public List< Size > fetchAll()
	{
        return entityManager().createQuery( "SELECT s FROM Size s",
                                               Size.class )
                                 .getResultList();
	}

}
