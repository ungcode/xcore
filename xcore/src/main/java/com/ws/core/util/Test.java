
package com.ws.core.util;

import com.ws.core.models.Address;
import com.ws.core.models.Brand;
import com.ws.core.models.Category;
import com.ws.core.models.Country;
import com.ws.core.models.Tuser;
import com.ws.core.models.UserAddress;
import com.ws.core.models.UserReview;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test
{
    // ---------------------------------------------------------------------
    // Construction
    // ---------------------------------------------------------------------

    public static Category createCategory()
    {

        Category category = new Category();
        category.setName( "Iphone14" );
        Category parent = new Category();
        parent.setName( "Mobile Phones" );
        Category parentOfParent = new Category();
        parentOfParent.setName( "Apple phone" );
        parent.setParentCategory( parentOfParent );
        category.setParentCategory( parent );

        return category;
    }

    public static JsonObject testJSON()
    {

        Tuser user = new Tuser();
        user.setName( "Muller" );
        user.setId( 11L );
        user.setEmail( "ant@gmail.com" );
        user.setHash( "hshshshs" );
        user.setPassword( "xxxxxxxxx" );
        user.setPhone( "12233333" );
        user.setSalt( "hhshshshddd" );

        UserReview userReview = new UserReview();
        userReview.setId( 321L );
        userReview.setComment( "The best product ever..." );
        userReview.setRating( 4 );
        userReview.setUser( user );

        /*
         * Set< UserReview > userReviewSet = new HashSet< UserReview >();
         * userReviewSet.add( userReview );
         * 
         * user.setUserReview( userReviewSet );
         */

        Address address = new Address();
        address.setId( 14L );
        address.setAddressLine1( "Helwigstr" );
        address.setCity( "Gross-Gerau" );
        address.setPostalCode( "64521" );
        address.setRegion( "Darmstadt" );
        address.setStreetNumber( "42" );
        Country country = new Country();
        country.setId( 2456L );
        country.setCountryName( "Germany" );
        address.setCountry( country );

        UserAddress userAddress = new UserAddress();
        userAddress.setId( 132L );
        userAddress.setDefault( true );
        userAddress.setUser( user );
        userAddress.setAddress( address );

        JsonObject model = null;
        JsonObjectBuilder builder = Json.createObjectBuilder();
        List< JsonObjectBuilder > suBuilders = new ArrayList< JsonObjectBuilder >();
        suBuilders.add( Json.createObjectBuilder() );
        suBuilders.add( Json.createObjectBuilder() );
        int i = 0;
        /*
         * coreUtil.parser( userAddress,
         * builder,
         * suBuilders,
         * i );
         * model = builder.build();
         */

        List< UserAddress > objects = new ArrayList<>();
        objects.add( userAddress );
        JsonObject json = null;

        // JsonObject json = CoreUtil.toJSON( userAddress );

        return json;

    }

    public Set< String > readCSV( String file )
    {
        StringBuilder path = new StringBuilder( "samples" );
        path.append( File.separator ).append( file );

        Set< String > data = new TreeSet< String >();

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return data;

    }

    public List< Brand > getBrands()
    {

        List< Brand > brands = new ArrayList< Brand >();

        Set< String > csv = readCSV( "brands.csv" );
        csv.forEach( brand -> {

            brands.add( new Brand( brand ) );
        } );
        return brands;

    }

    public static void validate()
    {

        String[] patterns = { "MM/dd/yy hh:mm" };
        String date = "04/25/24 11:50";
        boolean check = Arrays.asList( patterns ).stream()
                              .anyMatch( pattern -> {
                                  try
                                  {
                                      LocalDateTime.parse( date,
                                                           DateTimeFormatter.ofPattern( pattern ) );
                                      System.out.println( "Correct" );
                                      return true;
                                  }
                                  catch( Exception e )
                                  {
                                      System.out.println( "Not Correct" );
                                      return false;
                                  }
                              } );
    }
    public static void main( String[] args )
    {

        Test test = new Test();
        List< Brand > brands = test.getBrands();

        brands.forEach( brand -> {
            // System.out.println( brand );
        } );

        validate();

    }


}

// -------------------------------------------------------------------------
// end of class Test.java
