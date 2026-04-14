package com.example.cicd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "CI/CD Pipeline Başarıyla Çalışıyor! Son Güncelleme: Ngrok ve GitHub Webhook Eklendi.";
    }
}
