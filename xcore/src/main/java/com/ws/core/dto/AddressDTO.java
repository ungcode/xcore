
package com.ws.core.dto;

import com.ws.core.models.Address;
import java.util.ArrayList;
import java.util.List;


public class AddressDTO
{
    // ---------------------------------------------------------------------
    // Construction
    // ---------------------------------------------------------------------

    private Long    id;
    private String  unitNumber;
    private String  StreetNumber;
    private String  addressLine1;
    private String  addressLine2;
    private String  city;
    private String  region;
    private String  postalCode;
    private CountryDTO country;

    protected List< AddressDTO > dtos;


    public AddressDTO()
    {
        dtos = new ArrayList< AddressDTO >();
    }

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getUnitNumber()
    {
        return unitNumber;
    }

    public void setUnitNumber( String unitNumber )
    {
        this.unitNumber = unitNumber;
    }

    public String getStreetNumber()
    {
        return StreetNumber;
    }

    public void setStreetNumber( String streetNumber )
    {
        StreetNumber = streetNumber;
    }

    public String getAddressLine1()
    {
        return addressLine1;
    }

    public void setAddressLine1( String addressLine1 )
    {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2()
    {
        return addressLine2;
    }

    public void setAddressLine2( String addressLine2 )
    {
        this.addressLine2 = addressLine2;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity( String city )
    {
        this.city = city;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion( String region )
    {
        this.region = region;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode( String postalCode )
    {
        this.postalCode = postalCode;
    }

    public CountryDTO getCountry()
    {
        return country;
    }

    public void setCountry( CountryDTO country )
    {
        this.country = country;
    }

    public AddressDTO mapper( Address address )
    {

        AddressDTO dto = new AddressDTO();
        dto.setId( address.getId() );
        dto.setAddressLine1( address.getAddressLine1() );
        dto.setAddressLine2( address.getAddressLine2() );
        dto.setCity( address.getCity() );
        dto.setPostalCode( address.getPostalCode() );
        dto.setRegion( address.getRegion() );
        dto.setStreetNumber( address.getStreetNumber() );
        dto.setUnitNumber( address.getUnitNumber() );
        dto.setCountry( new CountryDTO( address.getCountry().getId(),
                                        address.getCountry()
                                               .getCountryName() ) );
        return dto;
    }

    public List< AddressDTO > mapper( List< Address > addresses )
    {

        addresses.forEach( address -> {
            AddressDTO dto = new AddressDTO();
            dto.setId( address.getId() );
            dto.setAddressLine1( address.getAddressLine1() );
            dto.setAddressLine2( address.getAddressLine2() );
            dto.setCity( address.getCity() );
            dto.setPostalCode( address.getPostalCode() );
            dto.setRegion( address.getRegion() );
            dto.setStreetNumber( address.getStreetNumber() );
            dto.setUnitNumber( address.getUnitNumber() );
            dto.setCountry( new CountryDTO( address.getCountry().getId(),
                                            address.getCountry()
                                                   .getCountryName() ) );
            dtos.add( dto );
        } );

        return dtos;

    }

}

// -------------------------------------------------------------------------
// end of class AddressDTO.java
