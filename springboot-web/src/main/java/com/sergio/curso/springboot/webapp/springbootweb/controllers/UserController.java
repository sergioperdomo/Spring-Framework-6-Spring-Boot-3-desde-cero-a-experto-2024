package com.sergio.curso.springboot.webapp.springbootweb.controllers;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.sergio.curso.springboot.webapp.springbootweb.models.User;
// import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        // Haciendo uso de nuestra clase User.java
        User user = new User("Sergio Andres", "Perdomo Ortiz", "perdomoortiz@gmail.com");
        user.setEmail("perdomoortizsegio@gmail.com");
        // Pasandole datos a la vista
        model.addAttribute("title", "Hola Mundo SpringBoot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        List<User> users = Arrays.asList(
            new User("Sergio", "Perdomo", "sergioperdomo00@gmail.com"),
            new User("Andres", "Ortiz", "andresortiz@gmail.com"),
            new User("Fede", "Charry", "Fede_charry@gmail.com"),
            new User("Andrew", "Ordoñez", "andre-ordoñez@gmail.com"));

        model.addAttribute("users",users);
        model.addAttribute("title", "Listado de usuarios!");
        return "list";
    }
    
    

}
