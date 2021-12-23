package com.peyman.spring.context;

import org.springframework.stereotype.Component;

@Component
public interface Book {

    int getPrice();
    String getTitle();

}
