package com.ws.core.dto;

import com.ws.core.models.Tuser;
import java.util.ArrayList;
import java.util.List;

public class UserDTO
{

	private Long id;
	
	private String name;
	
	private String email;
	
	private String phone;

    protected List< UserDTO > dtos;

	public UserDTO() {
        dtos = new ArrayList< UserDTO >();
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

    public UserDTO mapper( Tuser user )
    {

    	UserDTO dto = new UserDTO();
        dto.setId( user.getId() );
        dto.setName( user.getName() );
        dto.setEmail( user.getEmail() );
        dto.setPhone( user.getPhone() );
        return dto;
    }

    public List< UserDTO > mapper( List< Tuser > users)
    {

    	users.forEach( user -> {

        	UserDTO dto = new UserDTO();
            dto.setId( user.getId() );
            dto.setName( user.getName() );
            dto.setEmail( user.getEmail() );
            dto.setPhone( user.getPhone() );
            dtos.add( dto );
        } );

        return dtos;

    }


}
