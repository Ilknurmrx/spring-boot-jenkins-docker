package com.example.cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CicdApplication {
    public static void main(String[] args) {
        //Spring Boot uygulamasını başlatır. Tomcat web sunucusunu ayağa kaldırır.
        SpringApplication.run(CicdApplication.class, args);
        System.out.println("Uygulama basariyla basladi!");

    }
}
