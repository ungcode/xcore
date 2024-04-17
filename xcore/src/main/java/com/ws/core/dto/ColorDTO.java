package com.ws.core.dto;

import com.ws.core.models.Color;
import java.util.ArrayList;
import java.util.List;


public class ColorDTO
{

	private Long id;
	
	private String colorValue;

    public ColorDTO()
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

    public String getColorValue()
    {
        return colorValue;
    }

    public void setColorValue( String colorValue )
    {
        this.colorValue = colorValue;
    }

    public ColorDTO mapper( Color color )
    {

        return create( color );

    }

    public List< ColorDTO > mapper( List< Color > colors )
    {
        List< ColorDTO > dtos = new ArrayList< ColorDTO >();
        colors.forEach( color -> {
            dtos.add( create( color ) );
        } );
        return dtos;

    }

    private ColorDTO create( Color color )
    {
        ColorDTO dto = new ColorDTO();
        dto.setId( color.getId() );
        dto.setColorValue( color.getSizeValue() );
        return dto;
    }

}
