package com.sergio.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details (Model model) {
        // Pasandole datos a la vista
        model.addAttribute("title", "Hola Mundo SpringBoot");
        model.addAttribute("name", "Sergio Andres");
        model.addAttribute("lastName", "Perdomo Ortiz");
        return "details";
    }

}
