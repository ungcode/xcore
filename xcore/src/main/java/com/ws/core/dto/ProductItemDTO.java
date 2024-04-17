
package com.ws.core.dto;

import com.ws.core.models.ProductItem;
import java.util.ArrayList;
import java.util.List;

public class ProductItemDTO
{
    // ---------------------------------------------------------------------
    // Construction
    // ---------------------------------------------------------------------
    private Long            id;

    private String          sku;
    private int             qtInStock;
    private double          price;
    private ItemDTO                  itemDTO;
    private SizeDTO                  sizeDTO;
    private ColorDTO                 colorDTO;


    public ProductItemDTO()
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

    public String getSku()
    {
        return sku;
    }

    public void setSku( String sku )
    {
        this.sku = sku;
    }

    public int getQtInStock()
    {
        return qtInStock;
    }

    public void setQtInStock( int qtInStock )
    {
        this.qtInStock = qtInStock;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice( double price )
    {
        this.price = price;
    }

    public ItemDTO getItem()
    {
        return itemDTO;
    }

    public void setItem( ItemDTO itemDTO )
    {
        this.itemDTO = itemDTO;
    }

    public SizeDTO getSize()
    {
        return sizeDTO;
    }

    public void setSize( SizeDTO sizeDTO )
    {
        this.sizeDTO = sizeDTO;
    }

    public ColorDTO getColor()
    {
        return colorDTO;
    }

    public void setColor( ColorDTO colorDTO )
    {
        this.colorDTO = colorDTO;
    }


    public ProductItemDTO mapper( ProductItem productItem )
    {

        return create( productItem );

    }

    public List< ProductItemDTO > mapper( List< ProductItem > produtItems )
    {

        List< ProductItemDTO > dtos = new ArrayList< ProductItemDTO >();
        produtItems.forEach( productItem -> {

            dtos.add( create( productItem ) );

        } );

        return dtos;
    }

    private ProductItemDTO create( ProductItem productItem )
    {
        ProductItemDTO dto = new ProductItemDTO();
        dto.setId( productItem.getId() );
        dto.setPrice( productItem.getPrice() );
        dto.setQtInStock( productItem.getQtInStock() );
        dto.setSku( productItem.getSku() );
        dto.setItem( new ItemDTO().mapper( productItem.getEntry() ) );
        dto.setColor( new ColorDTO().mapper( productItem.getColor() ) );
        dto.setSize( new SizeDTO().mapper( productItem.getSize() ) );
        return dto;
    }

}

// -------------------------------------------------------------------------
// end of class ProductItemDTO.java
