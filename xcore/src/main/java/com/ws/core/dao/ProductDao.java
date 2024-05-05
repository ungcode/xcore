
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Brand;
import com.ws.core.models.Category;
import com.ws.core.models.Color;
import com.ws.core.models.Product;
import com.ws.core.models.Size;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


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
        return getEntityManager().createQuery( "SELECT p FROM Product p ",
                                               Product.class )
                                 .getResultList();
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

	
}
