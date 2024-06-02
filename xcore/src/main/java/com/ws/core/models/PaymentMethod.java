package com.ws.core.models;

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
@Table(name="PAYMENT_METHOD")
public class PaymentMethod  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String cash;
	
	private String card;
	
	@OneToMany(mappedBy = "paymentMethod")
    private List< UserPayment > userPayments     = new ArrayList<>();
	
	public PaymentMethod() {
	
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCash() {
		return cash;
	}
	public void setCash(String cash) {
		this.cash = cash;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}

    public List< UserPayment > getPaymentMethod()
    {
		return userPayments;
	}

    public void setPaymentMethod( List< UserPayment > paymentMethod )
    {
		this.userPayments = paymentMethod;
	}
	
}
