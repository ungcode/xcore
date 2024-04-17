
package com.ws.core.dto;

import com.ws.core.models.Country;
import java.util.ArrayList;
import java.util.List;


public class CountryDTO
{
    // ---------------------------------------------------------------------
    // Construction
    // ---------------------------------------------------------------------
    private Long   id;
    private String countryName;

    public CountryDTO()
    {

    }

    public CountryDTO( Long id,
                       String countryName )
    {
        super();
        this.id = id;
        this.countryName = countryName;
    }

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getCountryName()
    {
        return countryName;
    }

    public void setCountryName( String countryName )
    {
        this.countryName = countryName;
    }

    private CountryDTO create( Country country )
    {
        CountryDTO dto = new CountryDTO();
        dto.setId( country.getId() );
        dto.setCountryName( country.getCountryName() );
        return dto;
    }

    public List< CountryDTO > mapper( List< Country > countries )
    {
        List< CountryDTO > dtos = new ArrayList< CountryDTO >();
        countries.forEach( country -> {
            dtos.add( create( country ) );
        } );
        return dtos;

    }

}

// -------------------------------------------------------------------------
// end of class CountryDTO.java
