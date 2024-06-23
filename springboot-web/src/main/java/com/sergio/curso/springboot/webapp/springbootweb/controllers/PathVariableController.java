package com.sergio.curso.springboot.webapp.springbootweb.controllers;

import com.sergio.curso.springboot.webapp.springbootweb.models.User;
import com.sun.jdi.IntegerValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import com.sergio.curso.springboot.webapp.springbootweb.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    // Inyectando valores como atributos.

    @Value("${config.username}") // Es una forma de inyectar configuraciones.
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

    @Value("#{${configure.valuesMap}}") // Aquí estamos inyectando_todo el objeto.
    private Map<String,Object> valuesMap;

    @Value("#{${configure.valuesMap}.product}")
    private String product;

    @Value("#{${configure.valuesMap}.price}")
    private Long price;


    @Autowired // Es una forma de inyectar o hacer uso de un componente que ya existe en spring. Como es el caso de Enviroment.
    private Environment environment; // Enviroment - Componente Spring

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

        // Obteniendo el code, cabe mencionar que se hizo uso de @Autowired.
        json.put("phoneDos", Long.valueOf(environment.getProperty("config.code"))); //Convirtiendo un dato String a Integer

        json.put("message", message);

        // Obteniendo el mensaje, cabe mencionar que se hizo uso de @Autowired.
        json.put("messageDos", environment.getProperty("config.message"));

        json.put("listaDeValores", listOfValues);
        json.put("listaDeValoresManual", valueList);
        json.put("valueString",valueString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);
        return json;
    }
}
