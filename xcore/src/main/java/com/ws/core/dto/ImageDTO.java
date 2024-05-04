package com.ws.core.dto;

import com.ws.core.models.Image;
import com.ws.core.models.Product;
import java.util.ArrayList;
import java.util.List;


public class ImageDTO
{

	private Long id;
    private String            url;
	
    private Product           product;
	
	public ImageDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


    public Product getProduct()
    {
		return product;
	}

    public void setProduct( Product product )
    {
		this.product = product;
	}

    public String getUrl()
    {
        return url;
    }

    public void setUrl( String url )
    {
        this.url = url;
    }

    public ImageDTO mapper( Image image )
    {

        return create( image );

    }

    public List< ImageDTO > mapper( List< Image > images )
    {
        List< ImageDTO > dtos = new ArrayList< ImageDTO >();
        images.forEach( image -> {
            dtos.add( create( image ) );

        } );

        return dtos;
    }

    private ImageDTO create( Image image )
    {
        ImageDTO dto = new ImageDTO();
        dto.setId( image.getId() );
        dto.setProduct( image.getProduct() );
        dto.setUrl( image.getUrl() );
        return dto;
    }

}
