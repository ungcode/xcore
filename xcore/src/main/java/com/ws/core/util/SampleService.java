
package com.ws.core.util;

import com.ws.core.dao.ImageDao;
import com.ws.core.dao.ProductDao;
import com.ws.core.dao.PropertiesDao;
import com.ws.core.models.Image;
import com.ws.core.models.Product;
import com.ws.core.models.Properties;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SampleService
{
    // ---------------------------------------------------------------------
    // Construction
    // ---------------------------------------------------------------------
    @Inject
    protected ProductDao< Product >       productDao;
    @Inject
    protected PropertiesDao< Properties > propertiesDao;
    @Inject
    protected ImageDao< Product >         imageDao;

    @SuppressWarnings( "unchecked" )
    public void loadSamples()
    {

        Samples samples = new Samples();
        Map< String, Object > data = samples.getData();

        List< Product > products = ( List< Product > )data.get( "products" );
        List< Properties > properties = ( List< Properties > )data.get( "properties" );
        List< Image > images = ( List< Image > )data.get( "images" );

        List< Properties > props = new ArrayList< Properties >();
        List< Image > imgs = new ArrayList< Image >();

        try
        {

            for( int i = 0; i < products.size(); i++ )
            {

                Product product = products.get( i );
                Properties property = properties.get( i );
                Image image = images.get( i );
                product = productDao.persist( product );
                // add persisted product into properties and images

                property.setProduct( product );
                image.setProduct( product );
                props.add( property );
                imgs.add( image );


            }
            props.forEach( property -> {

                propertiesDao.persist( property );

            } );

            imgs.forEach( image -> {
                imageDao.persist( image );

            } );

        }
        catch( Exception e )
        {

            e.printStackTrace();
        }





    }

}

// -------------------------------------------------------------------------
// end of class SampleService.java
