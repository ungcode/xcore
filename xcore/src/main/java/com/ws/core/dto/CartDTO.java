
package com.ws.core.dto;

import com.ws.core.models.Cart;
import java.util.ArrayList;
import java.util.List;


public class CartDTO
{

	private Long id;

    private UserDTO           userDTO;
	
	
    protected List< CartDTO > dtos;
	
	public CartDTO() {
		
        dtos = new ArrayList< CartDTO >();
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


    public UserDTO getUserDTO()
    {
        return userDTO;
    }

    public void setUserDTO( UserDTO userDTO )
    {
        this.userDTO = userDTO;
    }

    public List< CartDTO > getDtos()
    {
        return dtos;
    }

    public void setDtos( List< CartDTO > dtos )
    {
        this.dtos = dtos;
    }


    public CartDTO mapper( Cart cart )
    {

        CartDTO dto = new CartDTO();
        dto.setId( cart.getId() );
        dto.setUserDTO( new UserDTO().mapper( cart.getUser() ) );
        return dto;

    }

    public List< CartDTO > mapper( List< Cart > carts )
    {

        carts.forEach( cart -> {

            CartDTO dto = new CartDTO();
            dto.setId( cart.getId() );
            dto.setUserDTO( new UserDTO().mapper( cart.getUser() ) );
            dtos.add( dto );
        } );

        return dtos;

    }

	
}
