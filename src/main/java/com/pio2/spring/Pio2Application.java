package com.pio2.spring;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pio2.spring.entidades.Ninyo;
import com.pio2.spring.repositorios.NinyoRepository;

@SpringBootApplication
public class Pio2Application {

	public static void main(String[] args) {
		SpringApplication.run(Pio2Application.class, args);
	}
	
	
	@Bean
	CommandLineRunner initData(NinyoRepository repositorio) {
		return (args) -> {

//			Empleado empleado = new Empleado("Luis Miguel López", "luismi.lopez@openwebinars.net", "954000000");
//			Empleado empleado2 = new Empleado("José García", "jose.garcia@openwebinars.net", "954000000");
//			
//			repositorio.save(empleado);
//			repositorio.save(empleado2);
//			
//			repositorio.findAll().forEach(System.out::println);

			repositorio.saveAll( 
					Arrays.asList(new Ninyo("1","Adrian","correo@prueba.com"), new Ninyo("2","Miguel","correo@prueba.com"), new Ninyo("3","Roberto","correo@prueba.com"))
					);

		};
	}
	
}
