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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="SHOP_ORDER")
public class ShopOrder implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_date")
	private Date orderDate;

	@Column(name="order_status")
	private String orderStatus;
	
    private double            total;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_payment_id")
	private UserPayment userPayment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipping_address_id")
	private ShippingAddress shippingAddress;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "cart_product_id" )
    private CartProduct       cartProduct;
	
	@OneToMany(mappedBy = "shopOrder")
    private List< UserReview > userReviews      = new ArrayList<>();

	public ShopOrder() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public UserPayment getUserPayment() {
		return userPayment;
	}

	public void setUserPayment(UserPayment userPayment) {
		this.userPayment = userPayment;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public CartProduct getCartItem() {
        return cartProduct;
	}

	public void setCartItem(CartProduct cartItem) {
        this.cartProduct = cartItem;
	}

    public double getTotal()
    {
        return total;
    }

    public void setTotal( double total )
    {
        this.total = total;
    }

    public List< UserReview > getUserReviews()
    {
		return userReviews;
	}

    public void setUserReviews( List< UserReview > userReviews )
    {
		this.userReviews = userReviews;
	}

    public void merge( ShopOrder from,
                       ShopOrder to )
    {
        to.setId( from.getId() );
        to.setTotal( from.getTotal() );
        to.setOrderDate( from.getOrderDate() );
        to.setOrderStatus( from.getOrderStatus() );
        to.setUserPayment( from.getUserPayment() );
        to.setCartItem( from.getCartItem() );
        to.setShippingAddress( from.getShippingAddress() );
        to.setUserReviews( from.getUserReviews() );

    }
	
	


	
}
