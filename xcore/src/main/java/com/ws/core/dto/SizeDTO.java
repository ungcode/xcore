package com.ws.core.dto;

import com.ws.core.models.Size;
import java.util.ArrayList;
import java.util.List;


public class SizeDTO
{


	private Long id;
	private String sizeValue;

    public SizeDTO()
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


    public String getSizeValue()
    {
        return sizeValue;
    }

    public void setSizeValue( String sizeValue )
    {
        this.sizeValue = sizeValue;
    }

    public SizeDTO mapper( Size size )
    {

        return create( size );

    }

    public List< SizeDTO > mapper( List< Size > sizes )
    {

        List< SizeDTO > dtos = new ArrayList< SizeDTO >();
        sizes.forEach( size -> {

            dtos.add( create( size ) );

        } );

        return dtos;
    }

    private SizeDTO create( Size size )
    {
        SizeDTO dto = new SizeDTO();
        dto.setId( size.getId() );
        dto.setSizeValue( size.getSizeValue() );
        return dto;
    }
	

}
