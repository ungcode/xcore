
package com.ws.core.dto;

import com.ws.core.models.Cart;
import java.util.ArrayList;
import java.util.List;


public class CartDTO
{

	private Long id;

    private TuserDTO           userDTO;
	
	
	public CartDTO() {
		

	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


    public TuserDTO getUserDTO()
    {
        return userDTO;
    }

    public void setUserDTO( TuserDTO userDTO )
    {
        this.userDTO = userDTO;
    }

    public List< CartDTO > mapper( List< Cart > carts )
    {

        List< CartDTO > dtos = new ArrayList< CartDTO >();
        carts.forEach( cart -> {

            CartDTO dto = new CartDTO();
            dto.setId( cart.getId() );
            dto.setUserDTO( new TuserDTO().mapper( cart.getUser() ) );
            dtos.add( dto );
        } );

        return dtos;

    }

    public CartDTO mapper( Cart cart )
    {

        CartDTO dto = new CartDTO();
        dto.setId( cart.getId() );
        dto.setUserDTO( new TuserDTO().mapper( cart.getUser() ) );
        return dto;

    }

	
}
