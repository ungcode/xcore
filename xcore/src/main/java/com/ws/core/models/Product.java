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
@Table(name="PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    private String            name;
    @Column( name = "short_description" )
    private String            shortDescription;

    private String            description;

	private String sku;
	
	@Column(name="qt_in_stock")
	private int qtInStock;
	
    @Column( name = "regular_price" )
    private double            regularPrice;

    @Column( name = "sale_price" )
    private double            salePrice;
	

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "brand_id" )
    private Brand             brand;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "category_id" )
    private Category          category;


    @OneToMany( mappedBy = "product" )
    private Set< Properties >  properties       = new HashSet<>();

    @OneToMany( mappedBy = "product" )
    private Set< Image >      image           = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "size_id")
	private Size size;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "color_id")
	private Color color;

    @OneToMany( mappedBy = "product" )
    private Set< CartProduct > cartProduct      = new HashSet<>();
	

	public Product() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getQtInStock() {
		return qtInStock;
	}

	public void setQtInStock(int qtInStock) {
		this.qtInStock = qtInStock;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
    }

    public Set< Properties > getProperties()
    {
        return properties;
    }

    public void setProperties( Set< Properties > properties )
    {
        this.properties = properties;
    }

    public Set< Image > getImages()
    {
        return image;
    }

    public void setImages( Set< Image > image )
    {
        this.image = image;
    }

    public void setCartProduct( Set< CartProduct > cartProduct )
    {
        this.cartProduct = cartProduct;
    }

    public Set< CartProduct > getCartProduct()
    {
        return cartProduct;
	}

    public void setCartItem( Set< CartProduct > cartProduct )
    {
        this.cartProduct = cartProduct;
	}

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public void setShortDescription( String shortDescription )
    {
        this.shortDescription = shortDescription;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public double getRegularPrice()
    {
        return regularPrice;
    }

    public void setRegularPrice( double regularPrice )
    {
        this.regularPrice = regularPrice;
    }

    public double getSalePrice()
    {
        return salePrice;
    }

    public void setSalePrice( double salePrice )
    {
        this.salePrice = salePrice;
    }

    public Brand getBrand()
    {
        return brand;
    }

    public void setBrand( Brand brand )
    {
        this.brand = brand;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory( Category category )
    {
        this.category = category;
    }

    public Set< CartProduct > getCartItems()
    {
        return cartProduct;
    }

    public void setCartProducts( Set< CartProduct > cartProducts )
    {
        this.cartProduct = cartProducts;
    }

    public void merge( Product from,
                       Product to )
    {

        to.setId( from.getId() );
        to.setCartItem( from.getCartProduct() );
        to.setColor( from.getColor() );
        to.setQtInStock( from.getQtInStock() );
        to.setSize( from.getSize() );
        to.setSku( from.getSku() );
        to.setImages( from.getImages() );
    }


}
