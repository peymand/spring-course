package com.peyman.data.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrder extends Audit implements Serializable {


    private static final long serialVersionUID = 9L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long customerOrderId;

    @OneToOne
    @JoinColumn(name="cartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name="cutomerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name="shippingAddressId")
    private ShippingAddress shippingAddress;


    @OneToOne
    @JoinColumn(name="billingAddressId")
    private BillingAddress billingAddress;

}
