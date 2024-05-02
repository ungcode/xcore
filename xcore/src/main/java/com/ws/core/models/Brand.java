
package com.ws.core.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


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
    private Set< Product > products = new HashSet<>();

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

    public Set< Product > getProducts()
    {
        return products;
    }

    public void setProducts( Set< Product > products )
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
    

}

// -------------------------------------------------------------------------
// end of class Brand.java
