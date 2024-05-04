
package com.ws.core.dto;

import com.ws.core.models.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductDTO
{
    // ---------------------------------------------------------------------
    // Construction
    // ---------------------------------------------------------------------
    private Long            id;

    private String          sku;
    private int             qtInStock;
    private double          price;
    private PropertiesDTO                  propertiesDTO;
    private SizeDTO                  sizeDTO;
    private ColorDTO                 colorDTO;


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

    public PropertiesDTO getItem()
    {
        return propertiesDTO;
    }

    public void setItem( PropertiesDTO propertiesDTO )
    {
        this.propertiesDTO = propertiesDTO;
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


    public ProductDTO mapper( Product productItem )
    {

        return create( productItem );

    }

    public List< ProductDTO > mapper( List< Product > produtItems )
    {

        List< ProductDTO > dtos = new ArrayList< ProductDTO >();
        produtItems.forEach( productItem -> {

            dtos.add( create( productItem ) );

        } );

        return dtos;
    }

    private ProductDTO create( Product productItem )
    {
        ProductDTO dto = new ProductDTO();
        dto.setId( productItem.getId() );
        dto.setQtInStock( productItem.getQtInStock() );
        dto.setSku( productItem.getSku() );
        dto.setColor( new ColorDTO().mapper( productItem.getColor() ) );
        dto.setSize( new SizeDTO().mapper( productItem.getSize() ) );
        return dto;
    }

}

// -------------------------------------------------------------------------
// end of class ProductItemDTO.java
