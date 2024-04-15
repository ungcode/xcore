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
	

	/*
	private Set<UserAddress> userAddresses = new HashSet<>();

	private Set<UserReview> userReviews = new HashSet<>();
	
	private Set<Cart> carts = new HashSet<>();
	
	private Set<UserPayment> paymentMethods = new HashSet<>();
*/
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
/*
	public Set<UserAddress> getUserAddresses() {
		return userAddresses;
	}

	public void setUserAddresses(Set<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}

	public Set<UserReview> getUserReviews() {
		return userReviews;
	}

	public void setUserReviews(Set<UserReview> userReviews) {
		this.userReviews = userReviews;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Set<UserPayment> getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(Set<UserPayment> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

*/
    public UserDTO mapper( Tuser user )
    {

    	UserDTO dto = new UserDTO();
        dto.setId( user.getId() );
        dto.setName( user.getName() );
        dto.setEmail( user.getEmail() );
        dto.setPhone( user.getPhone() );
        /*
        dto.setUserAddresses( user.getUserAddresses() );
        dto.setUserReviews( user.getUserReviews() );
        dto.setCarts( user.getCarts() );
        dto.setPaymentMethods( user.getPaymentMethods() );
        */
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
            /*
            dto.setUserAddresses( user.getUserAddresses() );
            dto.setUserReviews( user.getUserReviews() );
            dto.setCarts( user.getCarts() );
            dto.setPaymentMethods( user.getPaymentMethods() );
            */
            dtos.add( dto );
        } );

        return dtos;

    }


}
