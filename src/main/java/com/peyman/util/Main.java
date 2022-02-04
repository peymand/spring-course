package com.peyman.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
        String encPass = encoder.encode("admin");
        System.out.println(encPass);

    }
}
