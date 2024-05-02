
package com.ws.core.dto;

import com.ws.core.models.Brand;
import com.ws.core.models.Product;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class BrandDTO
{

    private Long           id;
    private String         name;
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

    public BrandDTO mapper( Brand brand )
    {

        return create( brand );

    }

    public List< BrandDTO > mapper( List< Brand > brands )
    {

        List< BrandDTO > dtos = new ArrayList< BrandDTO >();
        brands.forEach( brand -> {

            dtos.add( create( brand ) );

        } );

        return dtos;
    }


    private BrandDTO create( Brand brand )
    {
        BrandDTO dto = new BrandDTO();

        dto.setId( brand.getId() );
        dto.setName( brand.getName() );
        dto.setProducts( brand.getProducts() );
        return dto;
    }

}
