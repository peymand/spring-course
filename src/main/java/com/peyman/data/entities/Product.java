package com.peyman.data.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
public class Product extends Audit implements Serializable {

    private static final Long serialVersionUID = 100l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotEmpty
    private String productName;

    @NotEmpty
    private String productBrand;

    @NotEmpty
    private String productModel;

    @NotEmpty
    private String productDescription;

    @NotNull
    @Range(min = 0)
    private Double productPrice;

    @NotNull
    @Range(min = 0)
    private Double unitInStock;

    @Transient
    private MultipartFile productImage;

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems;

    @Transient
    private Map<String, String> categoryList;


    public Product(){
        categoryList = new HashMap<>();
        categoryList.put("Laptop","Laptop");
        categoryList.put("TV","TV");
        categoryList.put("Mobile","Mobile");
    }
}
