package com.sergio.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Para dar más de dos rutas: {"", "/", "/home"}
    @GetMapping({"", "/", "/home"})
    public String home(){

        //return "forward:/details"; // No muestra la ruta a la cual nos va a redirigir.
        return "redirect:/details"; // Muestra la ruta a la cual nos va a redirigir. pasamos list por que ya es una ruta que se encuentra previamente en la clase UserContrller. Básicamente nos redirecciona a otra página.
    }

}
