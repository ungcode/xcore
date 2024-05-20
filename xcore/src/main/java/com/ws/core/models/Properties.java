package com.ws.core.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;


/**
 * Properties should hold other related product entries such as
 * tax class, tax id etc . tax for example should be stored inform of
 * pro_key : _tax_x where "x" is any attribute to this element.
 *
 * 
 * @version 1.0
 */
@Entity
@Table( name = "PRODUCT_PROPERTIES" )
public class Properties implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @Column( name = "prop_name" )
	private String propName;
	
    @Column( name = "prop_value" )
	private String propValue;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
    private Product           product;
	
	public Properties() {
		
	}

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

    public Product getProduct()
    {
        return product;
    }

    public void setProduct( Product product )
    {
        this.product = product;
    }

    public void merge( Properties from,
                       Properties to )
    {
        to.setId( from.getId() );
        to.setPropName( from.getPropName() );
        to.setPropValue( to.getPropValue() );
        to.setProduct( from.getProduct() );

    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( "Properties [id=" );
        builder.append( id );
        builder.append( ", propName=" );
        builder.append( propName );
        builder.append( ", propValue=" );
        builder.append( propValue );
        builder.append( "]" );
        return builder.toString();
    }

}
