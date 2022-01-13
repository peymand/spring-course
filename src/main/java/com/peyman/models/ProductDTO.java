package com.peyman.models;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Component
public class ProductDTO {
    private int id;
    @Size(min = 3, message = "{error.name}")
    private String name;
    @Min(value = 1000 , message = "{error.price}")
    private int price;

    private String color;

    private List<Integer> sizes;

    private String type;

    private Map<String, String> validTypes;




    public ProductDTO(){
        validTypes = new HashMap<>();
        validTypes.put("1", "home");
        validTypes.put("2", "school");
        validTypes.put("3", "work");
    }

    public ProductDTO(int id, String name, int price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
