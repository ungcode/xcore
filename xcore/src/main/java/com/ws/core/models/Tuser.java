package com.ws.core.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tuser implements Serializable
{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@Column(unique = true)
	private String email;
	private String phone;
	private String salt;
	private String hash;

	@OneToMany(mappedBy = "user")
	private Set<UserAddress> userAddresses = new HashSet<UserAddress>();

	@OneToMany(mappedBy = "user")
	private Set<UserReview> userReview = new HashSet<>();

	public Tuser()
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getSalt()
	{
		return salt;
	}

	public void setSalt(String salt)
	{
		this.salt = salt;
	}

	public String getHash()
	{
		return hash;
	}

	public void setHash(String hash)
	{
		this.hash = hash;
	}

	public Set<UserAddress> getUserAddresses()
	{
		return userAddresses;
	}

	public void setUserAddresses(Set<UserAddress> userAddresses)
	{
		this.userAddresses = userAddresses;
	}

	public Set<UserReview> getUserReview()
	{
		return userReview;
	}

	public void setUserReview(Set<UserReview> userReview)
	{
		this.userReview = userReview;
	}

}
