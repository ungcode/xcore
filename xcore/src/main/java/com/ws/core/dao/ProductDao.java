
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Image;
import com.ws.core.models.Product;
import com.ws.core.models.Properties;
import com.ws.core.pagination.Pagination;
import com.ws.core.pagination.PaginationResult;
import com.ws.core.pagination.Paginator;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Transactional
public class ProductDao< T >
    extends Dao< Product >
{


    @Inject
    private PropertiesDao< Properties > propertiesDao;
    @Inject
    private ImageDao< Image >           imageDao;


	@Override
    public Product persist( Product product )
	{

        return persistAndFlush( product );

	}

	@Override
    public Product update( Product product )
	{

        return entityManager().merge( product );
	}

	@Override
    public void delete( Product product )
	{
        entityManager().remove( product );

	}

    @Override
    public Product fetch( Long id )
	{
        Query query = entityManager().createQuery( "SELECT p FROM Product p WHERE p.id =:id",
                                                      Product.class );
        query.setParameter( "id",
                            id );
        return ( Product )query.getSingleResult();
	}


    @Override
    public List< Product > fetchAll()
	{
        List< Product > products = entityManager().createQuery( "SELECT p FROM Product p ",
                                                                   Product.class )
                                                     .getResultList();
        addProperties( products );
        return products;
	}

    @SuppressWarnings( "unchecked" )
    public List< Properties > fetchProductById( Long id )
    {
        try
        {

            Query query = entityManager().createNativeQuery( "SELECT * FROM product_properties prop WHERE prop.product_id =:id",
                                                                Properties.class );
            query.setParameter( "id",
                                id );

            List< Properties > properties = query.getResultList();

            List< Properties > set = new ArrayList< Properties >();

            properties.forEach( property -> {
                set.add( property );
            } );

            return set;
        }
        catch( Exception e )
        {
            System.out.println( e.getMessage() );
        }

        return null;

    }

    private void addProperties( List< Product > products )
    {
        List< Product > list = new ArrayList< Product >();
        products.forEach( product -> {


            product.setProperties( fetchProductById( product.getId() ) );
            list.add( product );
        } );

        products = list;

    }

    public PaginationResult< Product > paginations( Pagination pagination )
    {

        String sql = "SELECT p as product FROM Product p "
                     + " WHERE p.id >:cursorPosition "
                     + "ORDER BY p.id ASC ";

        List< Product > products = new ArrayList< Product >();
        Query query = entityManager().createQuery( sql,
                                                   Tuple.class );

        Paginator< Product > paginator = new Paginator< Product >( pagination );
        paginator.setQuery( query );
        paginator.search();
        dependents( paginator,
                    products,
                    paginator.getTuples() );

        return paginator.getPaginationResult();
    }

    private void dependents( Paginator< Product > paginator,
                             List< Product > products,
                             List< Tuple > tuples )
    {
        System.out.println( "properties: "
                            + products );
        tuples.forEach( tuple -> {

            Product product = ( Product )tuple.get( "product" );
            product.setProperties( propertiesDao.fetchByProductId( product.getId() ) );
            product.setImages( imageDao.fetchByProductId( product.getId() ) );
            products.add( product );

        } );

        if( !products.isEmpty() )
        {
            paginator.setFinalResult( paginator,
                                      products,
                                      products.get( products.size()
                                                    - 1 )
                                              .getId().toString() );
        }

    }



	
}
