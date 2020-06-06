package com.pio2.spring.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Ninyo {

	@Id
	private String dni;

	private String nombre;
	private String apellido1;
	private String apellido2;
	private String FechaDeNacimiento;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Tutor> tutores = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "curso_nombre",
    foreignKey = @ForeignKey(name="CURSO_NOMBRE_FK_NINYO"))
	private Curso curso;

	public Ninyo() {
		super();
	}

	public Ninyo(String dni, String nombre, String email) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	public Ninyo(String dni, String nombre, String email, Curso curso) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.curso = curso;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ninyo other = (Ninyo) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ninyo [dni=" + dni + ", nombre=" + nombre + ", email="  + ", curso=" + curso + "]";
	}

}
