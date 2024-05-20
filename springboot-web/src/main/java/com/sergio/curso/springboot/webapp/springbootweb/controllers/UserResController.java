package com.sergio.curso.springboot.webapp.springbootweb.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergio.curso.springboot.webapp.springbootweb.models.User;
import com.sergio.curso.springboot.webapp.springbootweb.models.dto.UserDto;

// A continuación vas a ver una API REST
@RestController
@RequestMapping("/api")
public class UserResController {

    @GetMapping("/details")
    public UserDto details() {
        // Haciendo uso de nuestra clase User.java
        User user = new User("Sergio Andres", "Perdomo Ortiz");
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTittle("Hello World");

        return userDto;

    }

    // Método de lista
    @GetMapping("/list")
    public List <User> list() {
        User user = new User("Ana", "Francheska");
        User user1 = new User("Tum", "Reng");
        User user2 = new User("Renata", "Nuñez");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);

        return users;
    }



    @GetMapping("/details-map")
    public Map<String, Object> detailsMap() {
        User user = new User("Sergio", "Fede");
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Hola Mundo SpringBoot");
        body.put("user", user);
        return body;
    }

}
