package com.sergio.curso.springboot.webapp.springbootweb.controllers;

import com.sergio.curso.springboot.webapp.springbootweb.models.User;
import org.springframework.web.bind.annotation.*;

import com.sergio.curso.springboot.webapp.springbootweb.models.dto.ParamDto;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @GetMapping("/baz/{message}") // Ruta path variable
    public ParamDto baz(@PathVariable() String message){

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    // Obteniendo los datos por medio del método get a través de dos paramétros.
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create (@RequestBody User user) {
        // Hacer algo con el usuario save en la BD
        user.setName(user.getName().toUpperCase());
        return user;
    }
}
