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
 * images ULRs . Images for example should be stored inform of
 * pro_key : _img_x where "x" is a number and _cover_img for image
 * representing the product cover
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
	private String name;
	
    @Column( name = "prop_value" )
	private String value;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
    private Product           product;
	
	public Properties() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getMaterialKey() {
		return name;
	}

	public void setMaterialKey(String materialKey) {
		this.name = materialKey;
	}

	public String getMaterialValue() {
		return value;
	}

	public void setMaterialValue(String materialValue) {
		this.value = materialValue;
	}

	public String getItemName() {
		return name;
	}

	public void setItemName(String entry) {
		this.name = entry;
	}

	public String getItemValue() {
		return value;
	}

	public void setItemValue(String eValue) {
		this.value = eValue;
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
        to.setItemName( from.getItemName() );
        to.setItemValue( from.getItemValue() );
        to.setMaterialKey( from.getMaterialKey() );
        to.setMaterialValue( from.getMaterialValue() );
        to.setProduct( from.getProduct() );

    }

}
