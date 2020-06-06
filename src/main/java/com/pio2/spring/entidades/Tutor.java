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

	public Tutor() {
		super();
	}

	public Tutor(String dni) {
		super();
		this.dni = dni;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public List<Ninyo> getHijos() {
		return hijos;
	}

	public void setHijos(List<Ninyo> hijos) {
		this.hijos = hijos;
	}
	
	public void addNinyo(Ninyo ninyo) {
        hijos.add(ninyo);
        ninyo.getTutores().add(this);
    }

    public void removeNinyo(Ninyo ninyo) {
        hijos.remove(ninyo);
        ninyo.getTutores().remove(this);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido1 == null) ? 0 : apellido1.hashCode());
		result = prime * result + ((apellido2 == null) ? 0 : apellido2.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((domicilio == null) ? 0 : domicilio.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((hijos == null) ? 0 : hijos.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Tutor other = (Tutor) obj;
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
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (domicilio == null) {
			if (other.domicilio != null)
				return false;
		} else if (!domicilio.equals(other.domicilio))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (hijos == null) {
			if (other.hijos != null)
				return false;
		} else if (!hijos.equals(other.hijos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tutor [dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", telefono=" + telefono + ", email=" + email + ", domicilio=" + domicilio + ", hijos=" + hijos + "]";
	}
	

}
