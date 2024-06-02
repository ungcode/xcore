
package com.ws.core.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table( name = "BRAND" )
public class Brand implements Serializable
{
    /**
     * Comment for <code>serialVersionUID</code>.
     */
    private static final long serialVersionUID = 6241829495437421117L;
    // ---------------------------------------------------------------------
    // Construction
    // ---------------------------------------------------------------------
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long   id;
    private String name;


    @OneToMany( mappedBy = "brand" )
    private List< Product >   products         = new ArrayList<>();


    public Brand()
    {

    }

    public Brand( Long id,
                  String name )
    {

        this.id = id;
        this.name = name;
    }

    public Brand( String name )
    {

        this.name = name;
    }

    public Long getId()
    {
        return id;
    }


    public void setId( Long id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public List< Product > getProducts()
    {
        return products;
    }

    public void setProducts( List< Product > products )
    {
        this.products = products;
    }
    
    public void merge( Brand from,
                       Brand to )
    {

        to.setId( from.getId() );
        to.setName( from.getName() );
        to.setProducts( from.getProducts() );

    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( "Brand [id=" );
        builder.append( id );
        builder.append( ", name=" );
        builder.append( name );
        builder.append( "]" );
        return builder.toString();
    }
    

}

// -------------------------------------------------------------------------
// end of class Brand.java
