package com.ws.core.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
	private Set<UserPayment> userPayments = new HashSet<>();
	
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
	public Set<UserPayment> getPaymentMethod() {
		return userPayments;
	}
	public void setPaymentMethod(Set<UserPayment> paymentMethod) {
		this.userPayments = paymentMethod;
	}
	
}
