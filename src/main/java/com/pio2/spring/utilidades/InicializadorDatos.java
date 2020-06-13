package com.pio2.spring.utilidades;

import java.util.Arrays;
import java.util.List;

public class InicializadorDatos {
	
	public static List<String> nombres = Arrays.asList("Lucas", "Hugo", "Martín", "Daniel", "Pablo", "Alejandro", "Mateo",
			"Adrián", "Álvaro", "Manuel", "Leo", "David", "Mario", "Diego", "Javier", "Luis", "Marcos", "Juan",
			"José", "Gonzalo", "Lucía", "Sofía", "María", "Martina", "Paula", "Julia", "Daniela", "Valeria",
			"Alba", "Emma", "Carla", "Sara", "Noa", "Carmen", "Claudia", "Valentina", "Alma", "Ana", "Luisa",
			"Marta");

	public static List<String> apellidos = Arrays.asList("García", "González", "López", "Rodríguez", "Martínez", "Sánchez",
			"Pérez", "Gómez", "Martín", "Saez", "Velasco", "Moya", "Soler", "Parra", "Bravo", "Rojas", "Romero",
			"Sosa", "Torres", "Álvarez", "Flores", "Molina", "Ortiz", "Silva", "Torres");


	
	public static String creaNombre() {
		int i = (int)(Math.random() * nombres.size());
		
		return nombres.get(i);
	}
	
	public static String creaApellido() {
		int i = (int)(Math.random() * apellidos.size());
		
		return apellidos.get(i);
	}
	
	public static String creaDni() {
		return Integer.toString((int)(Math.random() * 100000000)) + "X";
	}

}
