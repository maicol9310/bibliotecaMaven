package com.example.bibliotecaMaven.presentation.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("/")
    public String home() {
        return "Bienvenido a la API";
    }

    @GetMapping("/saludo")
    public String saludar() {
        return "¡Hola desde tu API!";
    }
}
