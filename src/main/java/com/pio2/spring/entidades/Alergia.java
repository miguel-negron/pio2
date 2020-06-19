package com.pio2.spring.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Alergia {
	
	@Id
	private String nombre;
	
	@ManyToMany(mappedBy = "alergias")
	private List<Ninyo> ninyosAlergicos = new ArrayList<>();

	@ManyToMany(mappedBy = "alergias")
	private List<Monitor> monitoresAlergicos = new ArrayList<>();

	public Alergia() {
		super();
	}

	public Alergia(String alergeno) {
		super();
		this.nombre = alergeno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ninyo> getNinyosAlergicos() {
		return ninyosAlergicos;
	}

	public void setNinyosAlergicos(List<Ninyo> ninyosAlergicos) {
		this.ninyosAlergicos = ninyosAlergicos;
	}
	
	public void addNinyoAlergico(Ninyo ninyo) {
        ninyosAlergicos.add(ninyo);
        ninyo.getAlergias().add(this);
    }

    public void removeNinyoAlergico(Ninyo ninyo) {
    	ninyosAlergicos.remove(ninyo);
        ninyo.getAlergias().remove(this);
    }

	public List<Monitor> getMonitoresAlergicos() {
		return monitoresAlergicos;
	}

	public void setMonitoresAlergicos(List<Monitor> monitoresAlergicos) {
		this.monitoresAlergicos = monitoresAlergicos;
	}
	
	public void addMonitorAlergico(Monitor monitor) {
        monitoresAlergicos.add(monitor);
        monitor.getAlergias().add(this);
    }

    public void removeMonitorAlergico(Monitor monitor) {
    	monitoresAlergicos.remove(monitor);
        monitor.getAlergias().remove(this);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((monitoresAlergicos == null) ? 0 : monitoresAlergicos.hashCode());
		result = prime * result + ((ninyosAlergicos == null) ? 0 : ninyosAlergicos.hashCode());
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
		Alergia other = (Alergia) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (monitoresAlergicos == null) {
			if (other.monitoresAlergicos != null)
				return false;
		} else if (!monitoresAlergicos.equals(other.monitoresAlergicos))
			return false;
		if (ninyosAlergicos == null) {
			if (other.ninyosAlergicos != null)
				return false;
		} else if (!ninyosAlergicos.equals(other.ninyosAlergicos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alergia [alergeno=" + nombre + ", ninyosAlergicos=" + ninyosAlergicos + ", monitoresAlergicos="
				+ monitoresAlergicos + "]";
	}

}
