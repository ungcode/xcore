package com.ws.core.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="COUNTRY")
public class Country implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @Column( name = "country_name", unique = true )
	private String countryName;
	
    @OneToMany( mappedBy = "country" )
    private List< Address >   addresses        = new ArrayList< Address >();

	public Country()
	{
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getCountryName()
	{
		return countryName;
	}

	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}


    public List< Address > getAddresses()
    {
        return addresses;
    }

    public void setAddresses( List< Address > addresses )
    {
        this.addresses = addresses;
    }

    public void merge( Country from,
                       Country to )
    {
        to.setId( from.getId() );
        to.setCountryName( from.getCountryName() );
        to.setAddresses( from.getAddresses() );
    }

}
