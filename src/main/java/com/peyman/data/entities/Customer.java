package com.peyman.data.entities;

import com.peyman.validators.Phone;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
@Getter
@Setter
@Entity
public class Customer implements Serializable {

	
	private static final long serialVersionUID = 3L;
	

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long customerId;
	
	@NotEmpty
	@Size(min=5,max=30)
	private String customerName;
	
	
	@NotEmpty
	@Email
	private String customerEmailAddress;
	
	@Phone
	@NotEmpty
	private String customerPhoneNumber;
	
	@NotEmpty
	@Size(min=5,max=30)
	private String username;
	
	@NotEmpty
	//@Size(min=6,max=30)
	private String password;
	
	
	private boolean enabled;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name="shippingAddressId")
	private ShippingAddress  shippingAddress; 
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name="billingAddressId")
	private BillingAddress billingAddress  ; 
	
	@OneToOne
	@JoinColumn(name="cartId")
	private Cart cart;



	
	
	
	
}
