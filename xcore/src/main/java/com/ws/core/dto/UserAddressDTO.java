
package com.ws.core.dto;

import com.ws.core.models.UserAddress;
import java.util.ArrayList;
import java.util.List;


public class UserAddressDTO
{

    private Long                     id;

    private boolean                  isDefault;

    private TuserDTO                 user;

    private AddressDTO               address;

    public UserAddressDTO()
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

    public boolean isDefault()
    {
        return isDefault;
    }

    public void setDefault( boolean isDefault )
    {
        this.isDefault = isDefault;
    }

    public TuserDTO getUser()
    {
        return user;
    }

    public void setUser( TuserDTO user )
    {
        this.user = user;
    }

    public AddressDTO getAddress()
    {
        return address;
    }

    public void setAddress( AddressDTO address )
    {
        this.address = address;
    }

    public UserAddressDTO mapper( UserAddress userAddress )
    {

        return create( userAddress );
    }

    public List< UserAddressDTO > mapper( List< UserAddress > userAddresses )
    {

        List< UserAddressDTO > dtos = new ArrayList< UserAddressDTO >();
        userAddresses.forEach( userAddress -> {
            dtos.add( create( userAddress ) );
        } );

        return dtos;

    }

    private UserAddressDTO create( UserAddress userAddress )
    {
        UserAddressDTO dto = new UserAddressDTO();
        dto.setId( userAddress.getId() );
        dto.setDefault( userAddress.isDefault() );
        dto.setAddress( new AddressDTO().mapper( userAddress.getAddress() ) );
        dto.setUser( new TuserDTO().mapper( userAddress.getUser() ) );
        return dto;
    }

}
