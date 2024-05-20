package com.sergio.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sergio.curso.springboot.webapp.springbootweb.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        // Haciendo uso de nuestra clase User.java
        User user = new User("Sergio Andres", "Perdomo Ortiz");
        user.setEmail("perdomoortizsegio@gmail.com");
        // Pasandole datos a la vista
        model.addAttribute("title", "Hola Mundo SpringBoot");
        model.addAttribute("user", user);
        return "details";
    }

}
