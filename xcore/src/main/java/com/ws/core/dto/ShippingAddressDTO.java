package com.ws.core.dto;

import com.ws.core.models.ShippingAddress;
import java.util.ArrayList;
import java.util.List;


public class ShippingAddressDTO
{

	
    private Long                         id;
	
    private AddressDTO                   address;

    public ShippingAddressDTO()
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

    public AddressDTO getAddress()
    {
        return address;
    }

    public void setAddress( AddressDTO address )
    {
        this.address = address;
    }

    public ShippingAddressDTO mapper( ShippingAddress shippingAddress )
    {

        return create( shippingAddress );

    }

    public List< ShippingAddressDTO >
        mapper( List< ShippingAddress > shippingAddresses )
    {

        List< ShippingAddressDTO > dtos = new ArrayList< ShippingAddressDTO >();
        shippingAddresses.forEach( shippingAddress -> {
            dtos.add( create( shippingAddress ) );
        } );

        return dtos;

    }

    private ShippingAddressDTO create( ShippingAddress shippingAddress )
    {
        ShippingAddressDTO dto = new ShippingAddressDTO();
        dto.setId( shippingAddress.getId() );
        dto.setAddress( new AddressDTO().mapper( shippingAddress.getAddress() ) );
        return dto;
    }
	

}
