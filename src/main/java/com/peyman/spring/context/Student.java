package com.peyman.spring.context;

import lombok.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Component
@PropertySource("classpath:foo.properties")
@Lazy
public class Student {

    @Autowired
    private Logger logger;

    private int age;
    @Value("${candid}")
    private String name;
    private String family;

    @Autowired
    @Qualifier("sportBook")
    private Book book;

    @Autowired
    private Environment environment;

    public Student(){
        System.out.println("In constructor");
    }

    public void init(){
        System.out.println("in init method");
    }

    public int sum(int i , int j){
        return i+j + 2;
    }
}
