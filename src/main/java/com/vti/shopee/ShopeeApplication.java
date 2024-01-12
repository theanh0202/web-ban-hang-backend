package com.vti.shopee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ShopeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopeeApplication.class, args);
    }

}
