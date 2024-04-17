package com.ws.core.dto;

import com.ws.core.models.CartItem;
import java.util.ArrayList;
import java.util.List;


public class CartItemDTO
{


	private Long id;

	private int qt;

    private CartDTO          cart;

    private ProductItemDTO        productItemDTO;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public int getQt()
    {
        return qt;
    }

    public void setQt( int qt )
    {
        this.qt = qt;
    }

    public CartDTO getCart()
    {
        return cart;
    }

    public void setCart( CartDTO cart )
    {
        this.cart = cart;
    }


    public ProductItemDTO getProductItemDTO()
    {
        return productItemDTO;
    }

    public void setProductItemDTO( ProductItemDTO productItemDTO )
    {
        this.productItemDTO = productItemDTO;
    }

    public CartItemDTO mapper( CartItem cartItem )
    {


        return create( cartItem );

    }

    private CartItemDTO create( CartItem cartItem )
    {
        CartItemDTO dto = new CartItemDTO();
        dto.setId( cartItem.getId() );
        dto.setQt( cartItem.getQt() );
        dto.setCart( new CartDTO().mapper( cartItem.getCart() ) );
        dto.setProductItemDTO( new ProductItemDTO().mapper( cartItem.getProductItem() ) );
        return dto;
    }

    public List< CartItemDTO > mapper( List< CartItem > cartItems )
    {

        List< CartItemDTO > dtos = new ArrayList< CartItemDTO >();
        cartItems.forEach( cartItem -> {

            dtos.add( create( cartItem ) );
        } );

        return dtos;

    }



}
