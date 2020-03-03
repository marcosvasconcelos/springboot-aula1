package com.mvs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Inicializador {

	public static void main(String[] args) {
		SpringApplication.run(Inicializador.class, args);

	}

}
