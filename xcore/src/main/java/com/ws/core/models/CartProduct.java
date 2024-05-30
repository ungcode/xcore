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
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "CART_PRODUCT" )
public class CartProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int qt;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "product_id" )
    private Product           product;

    @OneToMany( mappedBy = "cartProduct" )
    private List< ShopOrder > shopOrders       = new ArrayList<>();

	public CartProduct() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return qt;
	}

	public void setQuantity(int quantity) {
		this.qt = quantity;
	}

    public int getQt()
    {
		return qt;
	}

    public void setQt( int qt )
    {
		this.qt = qt;
	}

    public Cart getCart()
    {
		return cart;
	}

    public void setCart( Cart cart )
    {
		this.cart = cart;
	}

    public Product getProduct()
    {
        return product;
	}

    public void setProduct( Product product )
    {
        this.product = product;
	}

    public List< ShopOrder > getShopOrders()
    {
		return shopOrders;
	}

    public void setShopOrders( List< ShopOrder > shopOrders )
    {
		this.shopOrders = shopOrders;
	}

    public void merge( CartProduct from,
                       CartProduct to )
    {
        to.setId( from.getId() );
        to.setQt( from.getQt() );
        to.setQuantity( from.getQuantity() );
        to.setCart( from.getCart() );
        to.setProduct( from.getProduct() );
        to.setShopOrders( from.getShopOrders() );

    }

}
