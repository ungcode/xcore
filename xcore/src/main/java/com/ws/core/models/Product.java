package com.ws.core.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="PRODUCT")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String description;
	
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "brand_id" )
    private Brand             brand;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private Set<Item> items = new HashSet<>();
	
	public Product() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Item> getEntry() {
		return items;
	}
	public void setEntry(Set<Item> entry) {
		this.items = entry;
	}


    public Brand getBrand()
    {
        return brand;
    }

    public void setBrand( Brand brand )
    {
        this.brand = brand;
    }

    public Set< Item > getItems()
    {
        return items;
    }

    public void setItems( Set< Item > items )
    {
        this.items = items;
    }
    public void merge( Product from,
                       Product to )
    {

        to.setId( from.getId() );
        to.setName( from.getName() );
        to.setCategory( from.getCategory() );
        to.setDescription( from.getDescription() );
        to.setEntry( from.getEntry() );
        to.setBrand( from.getBrand() );
        to.setItems( from.getItems() );

    }

}
