package com.peyman.data.entities;

import com.peyman.validators.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Audit implements Serializable {


    private static final Long serialVersionUID = 101l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotEmpty
    @Size(min = 3 , max = 30)
    private String customerName;

    @NotEmpty
    @Email
    private String customerEmailAddress;

    @NotEmpty
    @Phone
    private String custometPhoneNumber;

    @NotEmpty
    @Size(min = 3 , max = 30)
    private String username;
    @NotEmpty
    private String password;

    private boolean enabled;

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    @Valid
    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;


    @Valid
    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

}
