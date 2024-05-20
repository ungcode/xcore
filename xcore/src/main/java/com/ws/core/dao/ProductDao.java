
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Brand;
import com.ws.core.models.Category;
import com.ws.core.models.Color;
import com.ws.core.models.Product;
import com.ws.core.models.Properties;
import com.ws.core.models.Size;
import com.ws.core.pagination.Pagination;
import com.ws.core.pagination.PaginationResult;
import com.ws.core.pagination.Paginator;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


@Transactional
public class ProductDao< T >
    extends Dao< Product >
{

    @Inject
    protected BrandDao< Brand >       brandDao;
    @Inject
    protected CategoryDao< Category > categoryDao;
    @Inject
    private ColorDao< Color >         colorDao;
    @Inject
    private SizeDao< Size >           sizeDao;


	@Override
    public void persist( Product product )
	{

        getEntityManager().persist( product );

	}

	@Override
    public void update( Product product )
	{
        add( product );
        getEntityManager().merge( product );
	}

	@Override
    public void delete( Product product )
	{
        getEntityManager().remove( product );

	}

    @Override
    public Product fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT p FROM Product p WHERE p.id =:id",
                                                      Product.class );
        query.setParameter( "id",
                            id );
        return ( Product )query.getSingleResult();
	}


    @Override
    public List< Product > fetchAll()
	{
        List< Product > products = getEntityManager().createQuery( "SELECT p FROM Product p ",
                                                                   Product.class )
                                                     .getResultList();
        addProperties( products );
        return products;
	}

    private void add( Product product )
    {

        if( product.getCategory() != null
            && product.getCategory().getId() != null )
        {
            Category category = categoryDao.fetch( product.getCategory()
                                                          .getId() );
            product.setCategory( category );
        }

        if( product.getBrand() != null
            && product.getBrand().getId() != null )
        {
            Brand brand = brandDao.fetch( product.getBrand().getId() );
            product.setBrand( brand );
        }

        if( product.getSize() != null
            && product.getSize().getId() != null )
        {
            Size size = sizeDao.fetch( product.getSize().getId() );
            product.setSize( size );
        }

        if( product.getColor() != null
            && product.getColor().getId() != null )
        {
            Color color = colorDao.fetch( product.getColor().getId() );
            product.setColor( color );
        }

    }

    @SuppressWarnings( "unchecked" )
    public Set< Properties > fetchProductById( Long id )
    {
        try
        {

            Query query = getEntityManager().createNativeQuery( "SELECT * FROM product_properties prop WHERE prop.product_id =:id",
                                                                Properties.class );
            query.setParameter( "id",
                                id );

            List< Properties > properties = query.getResultList();

            System.out.println( "properties: "
                                + properties );


            Set< Properties > set = new TreeSet< Properties >();

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

    public PaginationResult paginations( Pagination pagination )
    {
        Query query = getEntityManager().createQuery( "SELECT p FROM Product p ",
                                                      Product.class );

        Paginator< Product > paginator = new Paginator< Product >( query,
                                                                   pagination );


        return paginator.getPaginationResult();
    }

	
}
