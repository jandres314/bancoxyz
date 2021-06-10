package com.poligran.bancoxyz.infraestructura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * en esta es el punto de entrada al framework de spring boot. en este punto se
 * inicializa la aplicacion junto con tdos sus modulos y dependencias
 * 
 * @author josorio
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.poligran.bancoxyz")
public class BancoxyzApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoxyzApplication.class, args);
	}

}
