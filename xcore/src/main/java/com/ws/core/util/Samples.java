
package com.ws.core.util;

import com.ws.core.models.Brand;
import com.ws.core.models.Category;
import com.ws.core.models.Color;
import com.ws.core.models.Image;
import com.ws.core.models.Product;
import com.ws.core.models.Properties;
import com.ws.core.models.Size;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Samples
{
    // ---------------------------------------------------------------------
    // Construction
    // ---------------------------------------------------------------------

    public List< String > readCSV( String file )
    {
        StringBuilder path = new StringBuilder( "samples" );
        path.append( File.separator ).append( file );

        List< String > data = new ArrayList< String >();

        try
        {
            InputStream resourceAsStream = this.getClass().getClassLoader()
                                               .getResourceAsStream( path.toString() );

            BufferedReader br = new BufferedReader( new InputStreamReader( resourceAsStream ) );

            String line;
            while( ( line = br.readLine() ) != null )
            {

                if( !line.isEmpty() )
                {
                    data.add( line );
                }
            }

        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

        return data;

    }

    public List< Brand > getBrands()
    {

        List< Brand > brands = new ArrayList< Brand >();

        readCSV( "brands.csv" ).forEach( brand -> {

            brands.add( new Brand( brand ) );
        } );
        return brands;

    }

    public List< Category > getCategories()
    {

        List< Category > categories = new ArrayList< Category >();


        Iterator< String > csv1 = readCSV( "categories.csv" ).iterator();
        Iterator< String > csv2 = readCSV( "sub_categories.csv" ).iterator();
        while( csv1.hasNext() )
        {
            Category category = new Category();
            category.setName( csv1.next() );
            categories.add( category.addSubCategory( csv2.next() ) );
        }

        return categories;

    }

    public List< Image > getImeges()
    {

        List< Image > images = new ArrayList< Image >();

        readCSV( "images.csv" ).forEach( image -> {

            images.add( new Image( image ) );
        } );
        return images;

    }

    public Map< String, Object > getData()
    {

        Map< String, Object > data = new HashMap< String, Object >();

        List< Product > products = new ArrayList< Product >();

        List< Properties > properties = new ArrayList< Properties >();

        List< Image > images = new ArrayList< Image >();

        for( int i = 0; i < 100; i++ )
        {
            Product product = new Product();
            product.setName( "name"
                             + i );
            product.setDescription( "description"
                                    + i );
            product.setShortDescription( "short description"
                                         + i );
            product.setCoverUrl( "url"+i );
            product.setQtInStock( i );
            product.setRegularPrice( i );
            product.setSalePrice( i );
            Color color = new Color();
            color.setColorValue( "blue"
                                 + i );
            Size size = new Size();
            size.setSizeValue( "xl"
                               + i );
            Brand brand = new Brand();
            brand.setName( "sony"
                           + i );
            Category category = new Category();
            category.setName( "category"
                              + i );
            product.setBrand( brand );
            product.setCategory( category );
            product.setColor( color );
            product.setSize( size );

            products.add( product );

            Image image = new Image();
            image.setUrl("url"+i );
            image.setProduct( product );
            images.add( image );

            Properties property = new Properties();
            property.setPropName( "name"
                                  + i );
            property.setPropValue( "value"
                                   + i );
            property.setProduct( product );

            properties.add( property );

        }

        data.put( "images",
                  images );
        data.put( "properties",
                  properties );
        data.put( "products",
                  products );

        /*
         * readCSV( "products.csv" ).forEach( name -> {
         * 
         * Product product = new Product();
         * product.setName( name );
         * products.add( product );
         * } );
         */
        return data;

    }

    public static void main( String[] args )
    {

        Samples samples = new Samples();
        samples.getBrands().forEach( brand -> {
            // System.out.println( brand );
        } );
        
        samples.getCategories().forEach( category -> {

            // System.out.println( category );
        } );

        samples.getImeges().forEach( image -> {

            // System.out.println( image );
        } );
        

    }

}

// -------------------------------------------------------------------------
// end of class Samples.java
