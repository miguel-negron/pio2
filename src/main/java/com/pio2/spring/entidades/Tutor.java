package com.pio2.spring.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tutor {
	
	@Id
	private String dni;
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String telefono;
	private String email;
	private String domicilio;
	
	@ManyToMany(mappedBy = "tutores")
	private List<Ninyo> hijos = new ArrayList<>();
	
	
	

}
