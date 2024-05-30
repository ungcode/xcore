package com.ws.core.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TUSER")
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
	
	@Transient
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List< UserAddress > userAddresses    = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List< UserReview >  userReviews      = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List< Cart >        carts            = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List< UserPayment > paymentMethods   = new ArrayList<>();

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

    public List< UserAddress > getUserAddresses()
	{
		return userAddresses;
	}

    public void setUserAddresses( List< UserAddress > userAddresses )
	{
		this.userAddresses = userAddresses;
	}

    public List< UserReview > getUserReview()
	{
		return userReviews;
	}

    public void setUserReview( List< UserReview > userReview )
	{
		this.userReviews = userReview;
	}

    public List< UserPayment > getPaymentMethods()
    {
		return paymentMethods;
	}

    public void setPaymentMethods( List< UserPayment > paymentMethods )
    {
		this.paymentMethods = paymentMethods;
	}

    public List< UserReview > getUserReviews()
    {
		return userReviews;
	}

    public void setUserReviews( List< UserReview > userReviews )
    {
		this.userReviews = userReviews;
	}

    public List< Cart > getCarts()
    {
		return carts;
	}

    public void setCarts( List< Cart > carts )
    {
		this.carts = carts;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


    public void merge( Tuser from,
                       Tuser to )
    {

		to.setName(from.getName());
		to.setEmail(from.getEmail());
		to.setPassword(from.getPassword());
		to.setPhone(from.getPhone());

	}


}
