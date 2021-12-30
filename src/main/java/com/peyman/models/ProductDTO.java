package com.peyman.models;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {
    private int id;
    private String name;
    private int price;
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
