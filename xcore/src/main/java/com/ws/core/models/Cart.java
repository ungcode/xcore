package com.ws.core.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="CART")
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Tuser user;
	
	@OneToMany(mappedBy = "cart")
	private Set<CartItem> cartItems = new HashSet<>();
	
	public Cart() {
		
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Tuser getUser() {
		return user;
	}


	public void setUser(Tuser user) {
		this.user = user;
	}

    public void merge( Cart from,
                       Cart to )
    {
        to.setId( from.getId() );
        to.setUser( from.getUser() );

    }
	
}
