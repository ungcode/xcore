package com.ws.core.dao;

import com.ws.core.idao.Dao;
import com.ws.core.models.Color;
import jakarta.persistence.Query;
import java.util.List;


public class ColorDao< T >
    extends Dao< Color >
{


	@Override
    public Color persist( Color entity )
	{

        persistAndFlush( entity );
        return entity;

	}

	@Override
    public Color update( Color color )
	{
        return mergeAndFlush( color );
	}

	@Override
    public void delete( Color color )
	{
        entityManager().remove( color );

	}

	@Override
    public Color fetch( Long id )
	{
        Query query = entityManager().createQuery( "SELECT c FROM Color c WHERE c.id =:id" );
        query.setParameter( "id",
                            id );
        return ( Color )query.getSingleResult();
	}

	@Override
    public List< Color > fetchAll()
	{
        return entityManager().createQuery( "SELECT c FROM Color c",
                                               Color.class )
                                 .getResultList();
	}

}
