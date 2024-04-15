package com.ws.core.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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

	public String getSizeValue() {
		return colorValue;
	}

	public void setSizeValue(String sizeValue) {
		this.colorValue = sizeValue;
	}

	public Set<ProductItem> getProductEntry() {
		return productEntries;
	}

	public void setProductEntry(Set<ProductItem> productEntry) {
		this.productEntries = productEntry;
	}
	
	

}
