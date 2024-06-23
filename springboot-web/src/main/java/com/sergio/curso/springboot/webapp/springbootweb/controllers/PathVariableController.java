package com.sergio.curso.springboot.webapp.springbootweb.controllers;

import com.sergio.curso.springboot.webapp.springbootweb.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.sergio.curso.springboot.webapp.springbootweb.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    // Inyectando valores como atributos.

    @Value("${config.username}") // Es una forma de inyectar.
    private String username;

    //@Value("${config.code}")
    //private String code;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String valueString;

    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}") // Convirtiendolo a una lista separandolo por comas de forma manual
    private List<String> valueList;

    @Value("#{${configure.valuesMap}}")
    private Map<String,Object> valuesMap;

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

    // Método GET
    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.code}") String code){ //Inyectando valores como parametros.

        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("phone", code);
        json.put("message", message);
        json.put("listaDeValores", listOfValues);
        json.put("listaDeValoresManual", valueList);
        json.put("valueString",valueString);
        json.put("valuesMap", valuesMap);
        return json;
    }
}
