package com.ws.core.dto;

import com.ws.core.models.Properties;
import java.util.ArrayList;
import java.util.List;


public class PropertiesDTO
{

    private Long    id;

    private String  propName;

    private String  propValue;

    private ProductDTO product;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getPropName()
    {
        return propName;
    }

    public void setPropName( String propName )
    {
        this.propName = propName;
    }

    public String getPropValue()
    {
        return propValue;
    }

    public void setPropValue( String propValue )
    {
        this.propValue = propValue;
    }

    public ProductDTO getProduct()
    {
        return product;
    }

    public void setProduct( ProductDTO product )
    {
        this.product = product;
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
        dto.setPropName( propName );
        dto.setPropValue( properties.getPropValue() );
        dto.setProduct( new ProductDTO().mapper( properties.getProduct() ) );
        return dto;
    }

}
