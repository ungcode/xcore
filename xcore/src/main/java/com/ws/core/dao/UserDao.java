package com.ws.core.dao;

import java.util.List;
import com.ws.core.idao.IDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class UserDao<Tuser> implements IDao<Tuser>
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
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Tuser entity)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Tuser fetch(Long id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tuser> fetchAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
