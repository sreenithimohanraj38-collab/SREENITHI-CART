package com.sreenithimart.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SreenithiMartApplication {
    public static void main(String[] args) {
        SpringApplication.run(SreenithiMartApplication.class, args);
        System.out.println("========================================");
        System.out.println("  Sreenithi Mart Backend Started!");
        System.out.println("  http://localhost:8080/api/products");
        System.out.println("========================================");
    }
}
