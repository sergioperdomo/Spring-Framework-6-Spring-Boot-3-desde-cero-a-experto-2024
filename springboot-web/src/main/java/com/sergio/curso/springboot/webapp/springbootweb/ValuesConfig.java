package com.sergio.curso.springboot.webapp.springbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        //@PropertySource("classpath:values.properties"), // @PropertySources podemos configurar más de un archivo, @PropertySource solo sirve para uno en especifico.
        @PropertySource("classpath:values.properties")
})
public class ValuesConfig {
}
