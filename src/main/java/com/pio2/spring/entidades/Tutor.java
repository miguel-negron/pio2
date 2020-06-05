package com.pio2.spring.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tutor {
	
	@Id
	private String dni;
	
	private String nombre;
	private String telefono;
	
	
	

}
