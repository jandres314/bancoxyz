package com.poligran.bancoxyz.infraestructura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.poligran.bancoxyz")
public class BancoxyzApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoxyzApplication.class, args);
	}

}
