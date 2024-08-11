package com.example.bhxd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.bhxd.mapper")
public class BhxdApplication {

    public static void main(String[] args) {
        SpringApplication.run(BhxdApplication.class, args);
    }

}
