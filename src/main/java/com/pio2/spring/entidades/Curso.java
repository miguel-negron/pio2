package com.pio2.spring.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Curso {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	
	@OneToOne
	private Monitor jefe;
	
	/*
	 * TODO
	 * 
	 * Por algun motivo los cascade types rompen la entrada de ninyos y monitores
	 * 
	 * Igual hay que hacer algo en el otro lado de la relacion 
	 * 
	 * @OneToMany(mappedBy = "curso", cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = false, fetch=FetchType.EAGER)
	 */
	
	@OneToMany(mappedBy = "curso", orphanRemoval = false, fetch=FetchType.EAGER)
    private List<Ninyo> ninyos = new ArrayList<>();
	
	@OneToMany(mappedBy = "curso", orphanRemoval = false, fetch=FetchType.EAGER)
    private List<Monitor> monitores = new ArrayList<>();

	public Curso() {
		super();
	}

	public Curso(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Monitor getJefe() {
		return jefe;
	}

	public void setJefe(Monitor jefe) {
		this.jefe = jefe;
	}

	public List<Ninyo> getNinyos() {
		return ninyos;
	}

	public void setNinyos(List<Ninyo> ninyos) {
		this.ninyos = ninyos;
	}
	
	public void addNinyo(Ninyo ninyo) {
        ninyos.add(ninyo);
        ninyo.setCurso(this);
    }

    public void removeNinyo(Ninyo ninyo) {
        ninyos.remove(ninyo);
        ninyo.setCurso(null);
    }

	public List<Monitor> getMonitores() {
		return monitores;
	}

	public void setMonitores(List<Monitor> monitores) {
		this.monitores = monitores;
	}
	
	public void addMonitor(Monitor monitor) {
        monitores.add(monitor);
        monitor.setCurso(this);
    }

    public void removeMonitor(Monitor monitor) {
    	monitores.remove(monitor);
    	monitor.setCurso(null);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jefe == null) ? 0 : jefe.hashCode());
		result = prime * result + ((monitores == null) ? 0 : monitores.hashCode());
		result = prime * result + ((ninyos == null) ? 0 : ninyos.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jefe == null) {
			if (other.jefe != null)
				return false;
		} else if (!jefe.equals(other.jefe))
			return false;
		if (monitores == null) {
			if (other.monitores != null)
				return false;
		} else if (!monitores.equals(other.monitores))
			return false;
		if (ninyos == null) {
			if (other.ninyos != null)
				return false;
		} else if (!ninyos.equals(other.ninyos))
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
		return "Curso [id=" + id + ", nombre=" + nombre + ", jefe=" + jefe + ", ninyos=" + ninyos + ", monitores="
				+ monitores + "]";
	}

	
	
}
