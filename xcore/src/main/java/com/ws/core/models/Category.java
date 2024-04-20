package com.ws.core.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Category parentCategory;

	@OneToMany(mappedBy = "parentCategory")
	private Set<Category> subCategories = new HashSet<>();
	
	@OneToMany(mappedBy = "category")
	private Set<Product> products = new HashSet<>();

	public Category() {

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

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Set<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<Category> subCategories) {
		this.subCategories = subCategories;
	}
	
	public Set<Product> getProduct() {
		return products;
	}

	public void setProduct(Set<Product> product) {
		this.products = product;
	}

	public Category addSubCategory(String categoryName) {
		Category sub = new Category();
		sub.setName(categoryName);
		this.subCategories.add(sub);
		sub.setParentCategory(this);
		return sub;
	}

	public void moveCategory(Category newParent) {
		this.getParentCategory().getSubCategories().remove(this);
		this.setParentCategory(newParent);
		newParent.getSubCategories().add(this);
	}

    public void merge( Category from,
                       Category to )
    {

        to.setName( from.getName() );
        to.setParentCategory( from.getParentCategory() );

    }
	
}