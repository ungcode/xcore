package com.ws.core.dao;

import com.ws.core.idao.Dao;
import com.ws.core.models.Country;
import jakarta.persistence.Query;
import java.util.List;


public class CountryDao< T >
    extends Dao< Country >
{


	@Override
    public void persist( Country country )
	{
        getEntityManager().persist( country );

	}

	@Override
    public void update( Country country )
	{
        getEntityManager().merge( country );
	}

	@Override
    public void delete( Country country )
	{
        getEntityManager().remove( country );

	}

	@Override
    public Country fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT c FROM Country c WHERE c.id =:id" );
        query.setParameter( "id",
                            id );
        return ( Country )query.getSingleResult();
	}

	@Override
    public List< Country > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT c FROM Country c",
                                               Country.class )
                                 .getResultList();
	}

}
