package com.peyman.data.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends Audit implements Serializable {

    private static final Long serialVersionUID = 101l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy="cart",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private List<CartItem> cartItems;

    private double grandTotal;
}
