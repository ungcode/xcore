package com.ws.core.dao;

import com.ws.core.idao.Dao;
import com.ws.core.models.Tuser;
import jakarta.persistence.Query;
import java.util.List;


public class UserDao< T >
    extends Dao< Tuser >
{

	@Override
    public Tuser persist( Tuser tuser )
	{
        persistAndFlush( tuser );
        return tuser;

	}

	@Override
    public Tuser update( Tuser entity )
	{
        return mergeAndFlush( entity );
	}

	@Override
	public void delete(Tuser entity)
	{
        entityManager().remove( entity );

	}

	@Override
	public Tuser fetch(Long id)
	{
        Query query = entityManager().createQuery( "SELECT tu FROM Tuser tu WHERE tu.id =:id" );
        query.setParameter( "id",
                            id );
        return ( Tuser )query.getSingleResult();
	}

	@Override
	public List<Tuser> fetchAll()
	{
        return entityManager().createQuery( "SELECT tu FROM Tuser tu",
        		Tuser.class ).getResultList();
	}

}
