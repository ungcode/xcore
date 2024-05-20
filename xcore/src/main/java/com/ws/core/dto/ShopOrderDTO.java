package com.ws.core.dto;

import com.ws.core.models.ShopOrder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ShopOrderDTO
{

	private Long id;

	private Date orderDate;

	private String orderStatus;
	
    private double                 total;

    private UserPaymentDTO     userPayment;
	
    private ShippingAddressDTO shippingAddress;
	
    private CartProductDTO        cartItem;
	
    public ShopOrderDTO()
    {

	}

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public Date getOrderDate()
    {
        return orderDate;
    }

    public void setOrderDate( Date orderDate )
    {
        this.orderDate = orderDate;
    }

    public String getOrderStatus()
    {
        return orderStatus;
    }

    public void setOrderStatus( String orderStatus )
    {
        this.orderStatus = orderStatus;
    }

    public double getTotal()
    {
        return total;
    }

    public void setTotal( double total )
    {
        this.total = total;
    }

    public UserPaymentDTO getUserPayment()
    {
        return userPayment;
    }

    public void setUserPayment( UserPaymentDTO userPayment )
    {
        this.userPayment = userPayment;
    }

    public ShippingAddressDTO getShippingAddress()
    {
        return shippingAddress;
    }

    public void setShippingAddress( ShippingAddressDTO shippingAddress )
    {
        this.shippingAddress = shippingAddress;
    }

    public CartProductDTO getCartItem()
    {
        return cartItem;
    }

    public void setCartItem( CartProductDTO cartItem )
    {
        this.cartItem = cartItem;
    }

    public ShopOrderDTO mapper( ShopOrder shopOrder )
    {

        return create( shopOrder );

    }

    public List< ShopOrderDTO > mapper( List< ShopOrder > shopOrders )
    {

        List< ShopOrderDTO > dtos = new ArrayList< ShopOrderDTO >();
        shopOrders.forEach( shopOrder -> {
            dtos.add( create( shopOrder ) );
        } );

        return dtos;

    }

    private ShopOrderDTO create( ShopOrder shopOrder )
    {
        ShopOrderDTO dto = new ShopOrderDTO();
        dto.setId( shopOrder.getId() );
        dto.setOrderDate( shopOrder.getOrderDate() );
        dto.setTotal( shopOrder.getTotal() );
        dto.setOrderStatus( shopOrder.getOrderStatus() );
        dto.setCartItem( new CartProductDTO().mapper( shopOrder.getCartItem() ) );
        dto.setShippingAddress( new ShippingAddressDTO().mapper( shopOrder.getShippingAddress() ) );
        dto.setUserPayment( new UserPaymentDTO().mapper( shopOrder.getUserPayment() ) );
        return dto;
    }

	


	
}
