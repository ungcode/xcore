package com.ws.core.dao;

import com.ws.core.idao.Dao;
import com.ws.core.models.Country;
import jakarta.persistence.Query;
import java.util.List;


public class CountryDao< T >
    extends Dao< Country >
{


	@Override
    public Country persist( Country country )
	{
        persistAndFlush( country );
        return country;

	}

	@Override
    public Country update( Country country )
	{
        return mergeAndFlush( country );
	}

	@Override
    public void delete( Country country )
	{
        entityManager().remove( country );

	}

	@Override
    public Country fetch( Long id )
	{
        Query query = entityManager().createQuery( "SELECT c FROM Country c WHERE c.id =:id" );
        query.setParameter( "id",
                            id );
        return ( Country )query.getSingleResult();
	}

	@Override
    public List< Country > fetchAll()
	{
        return entityManager().createQuery( "SELECT c FROM Country c",
                                               Country.class )
                                 .getResultList();
	}

}
