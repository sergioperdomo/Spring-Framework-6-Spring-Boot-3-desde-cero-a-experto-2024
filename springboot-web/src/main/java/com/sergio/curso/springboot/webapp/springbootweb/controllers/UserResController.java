package com.sergio.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergio.curso.springboot.webapp.springbootweb.models.User;


// A continuación vas a ver una API REST
@RestController
@RequestMapping("/api")
public class UserResController {

    // Haciendo uso de nuestra clase User.java
    User user = new User("Sergio Andres", "Perdomo Ortiz");

    @GetMapping("/detailsTwo")
    public Map<String, Object> details () {
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Hola Mundo SpringBoot");
        body.put("user", user);
        body.put("user", user);
        return body;
    }

}
