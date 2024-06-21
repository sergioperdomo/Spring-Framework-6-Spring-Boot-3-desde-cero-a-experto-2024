package com.sergio.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergio.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import org.springframework.web.bind.annotation.RequestParam;

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
    

}
