package com.ws.core.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
	private Set<ProductItem> productEntries = new HashSet<>();

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

	public Set<ProductItem> getProductEntry() {
		return productEntries;
	}

	public void setProductEntry(Set<ProductItem> productEntry) {
		this.productEntries = productEntry;
	}
	
	

}
