package com.ws.core.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_PAYMENT")
public class UserPayment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private boolean isDefault;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Tuser user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_method_id")
	private PaymentMethod paymentMethod;

	@OneToMany(mappedBy = "userPayment")
	private Set<ShopOrder> shoppingOrders = new HashSet<>();

	public UserPayment() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public PaymentMethod getType() {
		return paymentMethod;
	}

	public void setType(PaymentMethod type) {
		this.paymentMethod = type;
	}

	public Tuser getUser() {
		return user;
	}

	public void setUser(Tuser user) {
		this.user = user;
	}

	public PaymentMethod getPaymentType() {
		return paymentMethod;
	}

	public void setPaymentType(PaymentMethod paymentType) {
		this.paymentMethod = paymentType;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	/*
	 * public Set<Order> getOrders() { return Orders; } public void
	 * setOrders(Set<Order> orders) { Orders = orders; }
	 */

}
