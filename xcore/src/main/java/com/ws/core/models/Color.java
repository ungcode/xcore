package com.ws.core.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="COLOR")
public class Color implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String colorValue;
	
	@OneToMany(mappedBy = "color")
	private Set<ProductItem> productEntries = new HashSet<>();

	public Color() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

    public Set< ProductItem > getProductEntries()
    {
        return productEntries;
    }

	public void setProductEntry(Set<ProductItem> productEntry) {
		this.productEntries = productEntry;
	}

    public void merge( Color from,
                       Color to )
    {
        to.setId( from.getId() );
        to.setColorValue( from.getColorValue() );
        to.setProductEntry( from.getProductEntries() );

    }
	
	

}
