package com.peyman.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {

    public static void main(String[] args) {
        String username = "admin";
        String password = "123";
        BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
        String encPass = encoder.encode("123");
        System.out.println(encPass);

        String one = "$2a$10$bwx52LrPpCwqns1lyVtc5uzTJdp1LNS6QzC4XoVD6VM3YW7qyI2fC";
        String two = "$2a$10$2i.G642Go0oMDDMPmGx99e7XJgfOKCt2wc3YgjlSjd0vNAJQo59I.";
        if(encoder.matches(one,two)){
            System.out.println(true);
        }
    }
}
