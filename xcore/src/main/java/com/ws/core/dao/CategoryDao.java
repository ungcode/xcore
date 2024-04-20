package com.ws.core.dao;

import com.ws.core.idao.Dao;
import com.ws.core.models.Category;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;


public class CategoryDao< T >
    extends Dao< Category >
{

	@Override
    public void persist( Category category )
	{
        getEntityManager().persist( category );

	}

	@Override
    public void update( Category category )
	{
        getEntityManager().merge( category );
	}

	@Override
    public void delete( Category category )
	{
        getEntityManager().remove( category );

	}

	@Override
    public Category fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT ca FROM Category ca WHERE ca.id =:id" );
        query.setParameter( "id",
                            id );
        return ( Category )query.getSingleResult();
	}

	@Override
    public List< Category > fetchAll()
	{

        TypedQuery< Category > query = getEntityManager().createQuery( "SELECT c "
                                                                   + "FROM Category c "
                                                                   + "JOIN c.parentCategory p ",
                                                                   Category.class );

        return query.getResultList();

	}

}
