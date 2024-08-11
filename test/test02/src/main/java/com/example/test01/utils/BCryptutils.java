package com.example.test01.utils;

import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@NoArgsConstructor
public class BCryptutils {

    public static String BCryjm(String BCry) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        BCry = bCryptPasswordEncoder.encode(BCry);
        return BCry;
    }
}
