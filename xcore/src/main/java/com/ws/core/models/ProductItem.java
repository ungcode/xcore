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
@Table(name="PRODUCT_ITEM")
public class ProductItem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String sku;
	
	@Column(name="qt_in_stock")
	private int qtInStock;
	
	private double price;
	
    private double            discountPrice;

    private double            discount;



	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id")
	private Item item;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "size_id")
	private Size size;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "color_id")
	private Color color;

	@OneToMany(mappedBy = "productItem")
	private Set<CartItem> cartItems = new HashSet<>();
	

	public ProductItem() {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public Item getItem() {
		return item;
	}

	public void setItem(Item entry) {
		this.item = entry;
	}
	
	public Set<CartItem> getCartItem() {
		return cartItems;
	}

	public void setCartItem(Set<CartItem> cartItem) {
		this.cartItems = cartItem;
	}

    public double getDiscountPrice()
    {
        return discountPrice;
    }

    public void setDiscountPrice( double discountPrice )
    {
        this.discountPrice = discountPrice;
    }

    public double getDiscount()
    {
        return discount;
    }

    public void setDiscount( double discount )
    {
        this.discount = discount;
    }

    public void merge( ProductItem from,
                       ProductItem to )
    {

        to.setId( from.getId() );
        to.setCartItem( from.getCartItem() );
        to.setColor( from.getColor() );
        to.setItem( from.getItem() );
        to.setPrice( from.getPrice() );
        to.setQtInStock( from.getQtInStock() );
        to.setSize( from.getSize() );
        to.setSku( from.getSku() );
        to.setDiscount( from.getDiscount() );
        to.setDiscountPrice( from.getDiscountPrice() );
    }


}
