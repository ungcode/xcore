package com.ws.core.dao;

import com.ws.core.idao.Dao;
import com.ws.core.models.Color;
import jakarta.persistence.Query;
import java.util.List;


public class ColorDao< T >
    extends Dao< Color >
{


	@Override
    public void persist( Color color )
	{
        getEntityManager().persist( color );

	}

	@Override
    public void update( Color color )
	{
        getEntityManager().merge( color );
	}

	@Override
    public void delete( Color color )
	{
        getEntityManager().remove( color );

	}

	@Override
    public Color fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT c FROM Color c WHERE c.id =:id" );
        query.setParameter( "id",
                            id );
        return ( Color )query.getSingleResult();
	}

	@Override
    public List< Color > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT c FROM Color c",
                                               Color.class )
                                 .getResultList();
	}

}
