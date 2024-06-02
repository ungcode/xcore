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
import java.util.ArrayList;
import java.util.List;
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
	
    @Column( name = "cover_url" )
    private String             coverUrl;

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
    private List< Properties > properties       = new ArrayList<>();

    @OneToMany( mappedBy = "product" )
    private List< Image >      images            = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "size_id")
	private Size size;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "color_id")
	private Color color;

    @OneToMany( mappedBy = "product" )
    private List< CartProduct > cartProduct      = new ArrayList<>();
	

	public Product() {
	}

    public Product( String name,
                    String shortDescription,
                    String description,
                    double regularPrice,
                    double salePrice )
    {
        super();
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = description;
        this.regularPrice = regularPrice;
        this.salePrice = salePrice;
    }

    public Long getId()
    {
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

    public String getCoverUrl()
    {
        return coverUrl;
    }

    public void setCoverUrl( String coverUrl )
    {
        this.coverUrl = coverUrl;
    }


    public int getQtInStock()
    {
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

    public List< Properties > getProperties()
    {
        return properties;
    }

    public void setProperties( List< Properties > properties )
    {
        this.properties = properties;
    }

    public List< Image > getImages()
    {
        return images;
    }

    public void setImages( List< Image > image )
    {
        this.images = image;
    }

    public List< CartProduct > getCartProduct()
    {
        return cartProduct;
	}

    public void setCartProduct( List< CartProduct > cartProduct )
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

    public void setCartProducts( List< CartProduct > cartProducts )
    {
        this.cartProduct = cartProducts;
    }

    public void createPropertySet( Properties properties )
    {
        this.properties.add( properties );
    }

    public void merge( Product from,
                       Product to )
    {

        to.setId( from.getId() );
        to.setQtInStock( from.getQtInStock() );
        to.setSku( from.getSku() );
        to.setCoverUrl( from.getCoverUrl() );
        to.setRegularPrice( from.getRegularPrice() );
        to.setSalePrice( from.getSalePrice() );
        to.setShortDescription( from.getShortDescription() );
        to.setDescription( from.getDescription() );
        to.setProperties( from.getProperties() );
        to.setSize( from.getSize() );
        to.setColor( from.getColor() );
        to.setImages( from.getImages() );
        to.setBrand( from.getBrand() );
        to.setCartProduct( from.getCartProduct() );
        to.setCategory( from.getCategory() );

    }

    public List<Properties>asPropertiesList(Set<Properties> properties){
        List< Properties > list = new ArrayList< Properties >();

        properties.forEach( prop -> {
            list.add( prop );
        } );
        return list;
    }

    public List< Image > asImagesList( Set< Image > images )
    {
        List< Image > list = new ArrayList< Image >();

        images.forEach( image -> {
            list.add( image );
        } );
        return list;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( "Product [id=" );
        builder.append( id );
        builder.append( ", name=" );
        builder.append( name );
        builder.append( ", shortDescription=" );
        builder.append( shortDescription );
        builder.append( ", description=" );
        builder.append( description );
        builder.append( ", sku=" );
        builder.append( sku );
        builder.append( ", coverUrl=" );
        builder.append( coverUrl );
        builder.append( ", qtInStock=" );
        builder.append( qtInStock );
        builder.append( ", regularPrice=" );
        builder.append( regularPrice );
        builder.append( ", salePrice=" );
        builder.append( salePrice );
        builder.append( ", brand=" );
        builder.append( brand );
        builder.append( ", category=" );
        builder.append( category );
        builder.append( ", size=" );
        builder.append( size );
        builder.append( ", color=" );
        builder.append( color );
        builder.append( "]" );
        return builder.toString();
    }


}
