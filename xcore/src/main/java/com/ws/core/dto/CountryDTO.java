
package com.ws.core.dto;

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

}

// -------------------------------------------------------------------------
// end of class CountryDTO.java
