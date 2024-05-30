package com.ws.core.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="SIZE")
public class Size implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="size_value")
	private String sizeValue;
	
	@OneToMany(mappedBy = "size")
    private List< Product >   productEntries   = new ArrayList<>();

	public Size() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSizeValue() {
		return sizeValue;
	}

	public void setSizeValue(String sizeValue) {
		this.sizeValue = sizeValue;
	}

    public List< Product > getProductEntry()
    {
		return productEntries;
	}

    public void setProductEntry( List< Product > productEntry )
    {
		this.productEntries = productEntry;
	}

    public void merge( Size from,
                       Size to )
    {
        to.setId( from.getId() );
        to.setSizeValue( from.getSizeValue() );
        to.setProductEntry( from.getProductEntry() );

    }
	
	

}
