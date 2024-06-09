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
    public Category persist( Category category )
	{
        return mergeAndFlush( category );
	}

	@Override
    public Category update( Category category )
	{
        return mergeAndFlush( category );
	}

	@Override
    public void delete( Category category )
	{
        entityManager().remove( category );

	}

	@Override
    public Category fetch( Long id )
	{
        Query query = entityManager().createQuery( "SELECT ca FROM Category ca WHERE ca.id =:id" );
        query.setParameter( "id",
                            id );
        return ( Category )query.getSingleResult();
	}

	@Override
    public List< Category > fetchAll()
	{

        TypedQuery< Category > query = entityManager().createQuery( "SELECT c "
                                                                   + "FROM Category c "
                                                                   + "JOIN c.parentCategory p ",
                                                                   Category.class );

        return query.getResultList();

	}

}
