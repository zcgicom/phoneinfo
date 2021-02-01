package com.itcat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itcat.dao")
public class PhoneinfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneinfoApplication.class, args);
    }

}
