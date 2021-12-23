package com.peyman.spring.context;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Primary
public class HistoryBook implements Book {

    private int price;
    private String title;

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public String getTitle() {
        return null;
    }
}
