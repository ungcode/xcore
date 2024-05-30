package com.ws.core.idao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.hibernate.Session;

@Transactional
public abstract class Dao< T >
{

    @PersistenceContext
    private EntityManager em;
    public Session getHibernateSession()
    {
        return em.unwrap( Session.class );
    }

    public EntityManager entityManager()
    {
        return em;
    }

    public T persistAndFlush( T entity )
    {
        em.persist( entity );
        em.flush();
        
        return entity;
    }

    public T mergeAndFlush( T entity )
    {
        em.merge( entity );
        em.flush();

        return entity;
    }

    public abstract T persist( T entity );

    public abstract T update( T entity );

    public abstract void delete( T entity );

    public abstract T fetch( Long id );

    public abstract List< T > fetchAll();

}
