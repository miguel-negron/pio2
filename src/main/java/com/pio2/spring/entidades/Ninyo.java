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
	private String fechaDeNacimiento;
	
	//TODO enterarse bien de los cascadetypes
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Tutor> tutores = new ArrayList<>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Alergia> alergias = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "curso_nombre",
    foreignKey = @ForeignKey(name="CURSO_NOMBRE_FK_NINYO"))
	private Curso curso;

	public Ninyo() {
		super();
	}

	public Ninyo(String dni) {
		super();
		this.dni = dni;
	}

	public Ninyo(String dni, String nombre, String apellido1, String apellido2, String fechaDeNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaDeNacimiento = fechaDeNacimiento;
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

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public List<Tutor> getTutores() {
		return tutores;
	}

	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}

	public void addTutor(Tutor tutor) {
		tutores.add(tutor);
		tutor.getHijos().add(this);
    }

    public void removeTutor(Tutor tutor) {
    	tutores.remove(tutor);
    	tutor.getHijos().remove(this);
    }

	public List<Alergia> getAlergias() {
		return alergias;
	}

	public void setAlergias(List<Alergia> alergias) {
		this.alergias = alergias;
	}
	
	public void addAlergia(Alergia alergia) {
		alergias.add(alergia);
		alergia.getNinyosAlergicos().add(this);
    }

    public void removeAlergia(Alergia alergia) {
    	alergias.remove(alergia);
    	alergia.getNinyosAlergicos().remove(this);
    }

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
		curso.getNinyos().add(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido1 == null) ? 0 : apellido1.hashCode());
		result = prime * result + ((apellido2 == null) ? 0 : apellido2.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((fechaDeNacimiento == null) ? 0 : fechaDeNacimiento.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tutores == null) ? 0 : tutores.hashCode());
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
		if (apellido1 == null) {
			if (other.apellido1 != null)
				return false;
		} else if (!apellido1.equals(other.apellido1))
			return false;
		if (apellido2 == null) {
			if (other.apellido2 != null)
				return false;
		} else if (!apellido2.equals(other.apellido2))
			return false;
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
		if (fechaDeNacimiento == null) {
			if (other.fechaDeNacimiento != null)
				return false;
		} else if (!fechaDeNacimiento.equals(other.fechaDeNacimiento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tutores == null) {
			if (other.tutores != null)
				return false;
		} else if (!tutores.equals(other.tutores))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ninyo [dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", fechaDeNacimiento=" + fechaDeNacimiento + ", tutores=" + tutores + ", curso=" + curso.getNombre() + "]";
	}

	
}
