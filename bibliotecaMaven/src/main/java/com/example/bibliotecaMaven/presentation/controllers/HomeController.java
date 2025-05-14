package com.example.bibliotecaMaven.presentation.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class HomeController {

    private final DataSource dataSource;

    public HomeController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/")
    public String home() {
        return "Bienvenido a la API";
    }

    @GetMapping("/saludo")
    public String saludar() {
        return "¡Hola desde tu API!";
    }

    @GetMapping("/test-connection")
    public String testConnection() {
        try (Connection connection = dataSource.getConnection()) {
            return "✅ Conexión exitosa a: " + connection.getMetaData().getURL();
        } catch (Exception e) {
            return "❌ Error de conexión: " + e.getMessage();
        }
    }
}
