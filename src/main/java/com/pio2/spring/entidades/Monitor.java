package com.pio2.spring.entidades;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity	
public class Monitor {

	@Id
	private String dni;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "curso_nombre",
    foreignKey = @ForeignKey(name="CURSO_NOMBRE_FK_MONITOR"))
	private Curso curso;

	public Monitor() {
		super();
	}

	public Monitor(String dni) {
		super();
		this.dni = dni;
	}
}
