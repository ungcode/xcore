
package com.ws.core.dto;

import com.ws.core.models.Product;
import java.util.ArrayList;
import java.util.List;


public class ProductDTO
{

    private Long                 id;

    private String               name;

    private String               description;

    private CategoryDTO          categoryDTO;


    public ProductDTO()
    {

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

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public CategoryDTO getCategoryDTO()
    {
        return categoryDTO;
    }

    public void setCategoryDTO( CategoryDTO categoryDTO )
    {
        this.categoryDTO = categoryDTO;
    }

    public ProductDTO mapper( Product product )
    {

        return create( product );

    }
    public List< ProductDTO > mapper( List< Product > Products )
    {

        List< ProductDTO > dtos = new ArrayList< ProductDTO >();
        Products.forEach( product -> {
            dtos.add( create( product ) );

        } );

        return dtos;

    }
    private ProductDTO create( Product product )
    {
        ProductDTO dto = new ProductDTO();
        dto.setId( product.getId() );
        dto.setName( product.getName() );
        dto.setDescription( product.getDescription() );
        dto.setCategoryDTO( new CategoryDTO().mapper( product.getCategory() ) );
        return dto;
    }

}
