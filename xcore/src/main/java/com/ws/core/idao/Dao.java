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
    public Session getSession()
    {
        return em.unwrap( Session.class );
    }

    public EntityManager getEntityManager()
    {
        return em;
    }

    public abstract void persist( T entity );

    public abstract void update( T entity );

    public abstract void delete( T entity );

    public abstract T fetch( Long id );

    public abstract List< T > fetchAll();

}
