package com.ws.core.dao;

import java.util.List;
import com.ws.core.idao.IDao;
import com.ws.core.models.Tuser;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class UserDao<T> implements IDao<Tuser>
{

	@PersistenceContext
	private EntityManager em;


	@Override
	public void persist(Tuser tuser)
	{
		em.persist(tuser);

	}

	@Override
	public void update(Tuser entity)
	{
		em.merge(entity);
	}

	@Override
	public void delete(Tuser entity)
	{
		em.remove(entity);

	}

	@Override
	public Tuser fetch(Long id)
	{
        Query query = em.createQuery("SELECT tu FROM Tuser tu WHERE tu.id =:id");
        query.setParameter( "id",
                            id );
        return ( Tuser )query.getSingleResult();
	}

	@Override
	public List<Tuser> fetchAll()
	{
        return em.createQuery( "SELECT tu FROM Tuser tu",
        		Tuser.class ).getResultList();
	}

}
