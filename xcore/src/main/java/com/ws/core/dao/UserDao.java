package com.ws.core.dao;

import com.ws.core.idao.Dao;
import com.ws.core.models.Tuser;
import jakarta.persistence.Query;
import java.util.List;


public class UserDao< T >
    extends Dao< Tuser >
{

	@Override
	public void persist(Tuser tuser)
	{
        getEntityManager().persist( tuser );

	}

	@Override
	public void update(Tuser entity)
	{
        getEntityManager().merge( entity );
	}

	@Override
	public void delete(Tuser entity)
	{
        getEntityManager().remove( entity );

	}

	@Override
	public Tuser fetch(Long id)
	{
        Query query = getEntityManager().createQuery( "SELECT tu FROM Tuser tu WHERE tu.id =:id" );
        query.setParameter( "id",
                            id );
        return ( Tuser )query.getSingleResult();
	}

	@Override
	public List<Tuser> fetchAll()
	{
        return getEntityManager().createQuery( "SELECT tu FROM Tuser tu",
        		Tuser.class ).getResultList();
	}

}
