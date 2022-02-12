package com.peyman.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
        String encPass = encoder.encode("admin");
        if(encoder.matches("admin", "$2a$10$/FzDi6O2SLjYrW58SBBVlOXfTMU4EnkXoPJ246fTkZEajbmzGWWry")){
            System.out.println(true);
        }
        System.out.println(encPass);

    }
}
