package com.ws.core.dto;

import com.ws.core.models.Item;
import java.util.ArrayList;
import java.util.List;


public class ItemDTO
{

	private Long id;
	
	private String itemName;
	
	private String itemValue;
	
    private ProductDTO productDTO;

    public ItemDTO()
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

    public ItemDTO mapper( Item item )
    {

        return create( item );

    }

    public List< ItemDTO > mapper( List< Item > items )
    {
        List< ItemDTO > dtos = new ArrayList< ItemDTO >();
        items.forEach( item -> {
            dtos.add( create( item ) );

        } );

        return dtos;
    }

    private ItemDTO create( Item item )
    {
        ItemDTO dto = new ItemDTO();
        dto.setId( item.getId() );
        dto.setItemName( item.getItemName() );
        dto.setItemValue( item.getItemValue() );
        dto.setProductDTO( new ProductDTO().mapper( item.getProduct() ) );
        return dto;
    }

	
	


}
