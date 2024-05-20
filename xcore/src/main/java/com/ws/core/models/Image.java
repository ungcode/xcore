package com.ws.core.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;


@Entity
@Table( name = "PRODUCT_IMAGES" )
public class Image implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String            url;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
    private Product           product;
	
	public Image() {
		
	}


    public Image( String url )
    {

        this.url = url;
    }

    public Long getId()
    {
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

    public void merge( Image from,
                       Image to )
    {
        to.setId( from.getId() );
        to.setProduct( from.getProduct() );
        to.setUrl( from.getUrl() );


    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( "Image [id=" );
        builder.append( id );
        builder.append( ", url=" );
        builder.append( url );
        builder.append( ", product=" );
        builder.append( product );
        builder.append( "]" );
        return builder.toString();
    }

}
