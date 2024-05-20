
package com.ws.core.dto;

import com.ws.core.models.Brand;
import java.util.ArrayList;
import java.util.List;


public class BrandDTO
{

    private Long           id;
    private String         name;

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
        return dto;
    }

}
