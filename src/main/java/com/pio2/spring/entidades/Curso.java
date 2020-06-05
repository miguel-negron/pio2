package com.pio2.spring.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Curso {

	@Id
	private String nombre;
	
	@OneToOne
	private Monitor jefe;
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Ninyo> ninyos = new ArrayList<>();
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Monitor> monitores = new ArrayList<>();

	public Curso() {
		super();
	}

	public Curso(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Curso other = (Curso) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + "]";
	}
	
	
}
