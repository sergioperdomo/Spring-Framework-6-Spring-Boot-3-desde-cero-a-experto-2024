package com.sergio.curso.springboot.webapp.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:values.properties")
public class SpringbootWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootWebApplication.class, args);
	}

}
