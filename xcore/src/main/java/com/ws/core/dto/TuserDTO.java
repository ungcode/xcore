package com.ws.core.dto;

import com.ws.core.models.Tuser;
import java.util.ArrayList;
import java.util.List;

public class TuserDTO
{

	private Long id;
	
	private String name;
	
	private String email;
	
	private String phone;

	public TuserDTO() {

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

    public TuserDTO mapper( Tuser user )
    {

        return create( user );
    }
    public List< TuserDTO > mapper( List< Tuser > users)
    {

        List< TuserDTO > dtos = new ArrayList< TuserDTO >();
    	users.forEach( user -> {

            dtos.add( create( user ) );
        } );

        return dtos;

    }

    private TuserDTO create( Tuser user )
    {
        TuserDTO dto = new TuserDTO();
        dto.setId( user.getId() );
        dto.setName( user.getName() );
        dto.setEmail( user.getEmail() );
        dto.setPhone( user.getPhone() );
        return dto;
    }


}
