
package com.ws.core.dto;

import com.ws.core.models.Product;
import com.ws.core.models.Properties;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private BrandDTO    brand;
    private CategoryDTO category;
    private SizeDTO     size;
    private ColorDTO    color;
    private Set< Properties > properties = new HashSet<>();

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

    public BrandDTO getBrand()
    {
        return brand;
    }

    public void setBrand( BrandDTO brand )
    {
        this.brand = brand;
    }

    public CategoryDTO getCategory()
    {
        return category;
    }

    public void setCategory( CategoryDTO category )
    {
        this.category = category;
    }

    public SizeDTO getSize()
    {
        return size;
    }

    public void setSize( SizeDTO size )
    {
        this.size = size;
    }

    public ColorDTO getColor()
    {
        return color;
    }

    public void setColor( ColorDTO color )
    {
        this.color = color;
    }

    public Set< Properties > getProperties()
    {
        return properties;
    }

    public void setProperties( Set< Properties > properties )
    {
        this.properties = properties;
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

        dto.setSize( new SizeDTO().mapper( product.getSize() ) );
        dto.setColor( new ColorDTO().mapper( product.getColor() ) );

        dto.setBrand( new BrandDTO().mapper( product.getBrand() ) );
        dto.setCategory( new CategoryDTO().mapper( product.getCategory() ) );
        // dto.setProperties( product.getProperties() );

        return dto;
    }

}

// -------------------------------------------------------------------------
// end of class ProductItemDTO.java
