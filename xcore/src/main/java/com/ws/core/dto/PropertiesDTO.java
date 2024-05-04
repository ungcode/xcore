package com.ws.core.dto;

import com.ws.core.models.Properties;
import java.util.ArrayList;
import java.util.List;


public class PropertiesDTO
{

	private Long id;
	
	private String itemName;
	
	private String itemValue;
	
    private ProductDTO productDTO;

    public PropertiesDTO()
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

    public String getItemName()
    {
        return itemName;
    }

    public void setItemName( String itemName )
    {
        this.itemName = itemName;
    }

    public String getItemValue()
    {
        return itemValue;
    }

    public void setItemValue( String itemValue )
    {
        this.itemValue = itemValue;
    }

    public ProductDTO getProductDTO()
    {
        return productDTO;
    }

    public void setProductDTO( ProductDTO productDTO )
    {
        this.productDTO = productDTO;
    }

    public PropertiesDTO mapper( Properties properties )
    {

        return create( properties );

    }

    public List< PropertiesDTO > mapper( List< Properties > properties )
    {
        List< PropertiesDTO > dtos = new ArrayList< PropertiesDTO >();
        properties.forEach( item -> {
            dtos.add( create( item ) );

        } );

        return dtos;
    }

    private PropertiesDTO create( Properties properties )
    {
        PropertiesDTO dto = new PropertiesDTO();
        dto.setId( properties.getId() );
        dto.setItemName( properties.getItemName() );
        dto.setItemValue( properties.getItemValue() );
        dto.setProductDTO( new ProductDTO().mapper( properties.getProduct() ) );
        return dto;
    }

	
	


}
