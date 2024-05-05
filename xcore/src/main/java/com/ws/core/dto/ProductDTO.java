
package com.ws.core.dto;

import com.ws.core.models.Brand;
import com.ws.core.models.Category;
import com.ws.core.models.Color;
import com.ws.core.models.Product;
import com.ws.core.models.Size;
import java.util.ArrayList;
import java.util.List;

public class ProductDTO
{
    // ---------------------------------------------------------------------
    // Construction
    // ---------------------------------------------------------------------
    private Long     id;
    private String   name;
    private String   shortDescription;
    private String   description;
    private String   sku;
    private String   coverUrl;
    private int      qtInStock;
    private double   regularPrice;
    private double   salePrice;
    private Brand    brand;
    private Category category;
    private Size     size;
    private Color    color;

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

    public String getShortDescription()
    {
        return shortDescription;
    }

    public void setShortDescription( String shortDescription )
    {
        this.shortDescription = shortDescription;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public String getSku()
    {
        return sku;
    }

    public void setSku( String sku )
    {
        this.sku = sku;
    }

    public String getCoverUrl()
    {
        return coverUrl;
    }

    public void setCoverUrl( String coverUrl )
    {
        this.coverUrl = coverUrl;
    }

    public int getQtInStock()
    {
        return qtInStock;
    }

    public void setQtInStock( int qtInStock )
    {
        this.qtInStock = qtInStock;
    }

    public double getRegularPrice()
    {
        return regularPrice;
    }

    public void setRegularPrice( double regularPrice )
    {
        this.regularPrice = regularPrice;
    }

    public double getSalePrice()
    {
        return salePrice;
    }

    public void setSalePrice( double salePrice )
    {
        this.salePrice = salePrice;
    }

    public Brand getBrand()
    {
        return brand;
    }

    public void setBrand( Brand brand )
    {
        this.brand = brand;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory( Category category )
    {
        this.category = category;
    }

    public Size getSize()
    {
        return size;
    }

    public void setSize( Size size )
    {
        this.size = size;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor( Color color )
    {
        this.color = color;
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

    private ProductDTO create( Product product )
    {
        ProductDTO dto = new ProductDTO();

        dto.setId( product.getId() );
        dto.setQtInStock( product.getQtInStock() );
        dto.setSku( product.getSku() );
        dto.setCoverUrl( product.getCoverUrl() );
        dto.setRegularPrice( product.getRegularPrice() );
        dto.setSalePrice( product.getSalePrice() );
        dto.setShortDescription( product.getShortDescription() );
        dto.setDescription( product.getDescription() );

        dto.setSize( product.getSize() );
        dto.setColor( product.getColor() );
        dto.setBrand( product.getBrand() );
        dto.setCategory( product.getCategory() );
        return dto;
    }

}

// -------------------------------------------------------------------------
// end of class ProductItemDTO.java
