package com.ws.core.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name="ITEM")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_value")
	private String itemValue;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;
	
	@OneToMany(mappedBy = "item")
	private Set<ProductItem> productItems = new HashSet<>();
	

	public Item() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getMaterialKey() {
		return itemName;
	}

	public void setMaterialKey(String materialKey) {
		this.itemName = materialKey;
	}

	public String getMaterialValue() {
		return itemValue;
	}

	public void setMaterialValue(String materialValue) {
		this.itemValue = materialValue;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String entry) {
		this.itemName = entry;
	}

	public String getItemValue() {
		return itemValue;
	}

	public void setItemValue(String eValue) {
		this.itemValue = eValue;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Set<ProductItem> getProductItem() {
		return productItems;
	}

	public void setProductItem(Set<ProductItem> productItem) {
		this.productItems = productItem;
	}

    public void merge( Item from,
                       Item to )
    {
        to.setId( from.getId() );
        to.setItemName( from.getItemName() );
        to.setItemValue( from.getItemValue() );
        to.setMaterialKey( from.getMaterialKey() );
        to.setMaterialValue( from.getMaterialValue() );
        to.setProduct( from.getProduct() );
        to.setProductItem( from.getProductItem() );

    }

}
