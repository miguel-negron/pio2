package com.pio2.spring.servicios;

import java.util.List;

import com.pio2.spring.entidades.Alergia;

public interface AlergiaService {
	public Alergia add(Alergia e);

	public List<Alergia> findAll();

	public Alergia findById(Long id);

	public Alergia edit(Alergia e);

	public Alergia findByNombre(String nombre);
}
