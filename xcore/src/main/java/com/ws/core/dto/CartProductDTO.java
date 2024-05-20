package com.ws.core.dto;

import com.ws.core.models.CartProduct;
import java.util.ArrayList;
import java.util.List;


public class CartProductDTO
{


	private Long id;

	private int qt;

    private CartDTO          cart;

    private ProductDTO productDTO;

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


    public ProductDTO getProductItemDTO()
    {
        return productDTO;
    }

    public void setProductItemDTO( ProductDTO productDTO )
    {
        this.productDTO = productDTO;
    }

    public CartProductDTO mapper( CartProduct cartProduct )
    {


        return create( cartProduct );

    }

    private CartProductDTO create( CartProduct cartProduct )
    {
        CartProductDTO dto = new CartProductDTO();
        dto.setId( cartProduct.getId() );
        dto.setQt( cartProduct.getQt() );
        dto.setCart( new CartDTO().mapper( cartProduct.getCart() ) );
        dto.setProductItemDTO( new ProductDTO().mapper( cartProduct.getProduct() ) );
        return dto;
    }

    public List< CartProductDTO > mapper( List< CartProduct > cartProducts )
    {

        List< CartProductDTO > dtos = new ArrayList< CartProductDTO >();
        cartProducts.forEach( cartProduct -> {

            dtos.add( create( cartProduct ) );
        } );

        return dtos;

    }



}
