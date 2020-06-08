package com.pio2.spring.servicios;

import java.util.List;

import com.pio2.spring.entidades.Curso;


public interface CursoService {

	public Curso add(Curso e);
	public List<Curso> findAll();
	public Curso findById(Long id);
	public Curso edit(Curso e);
	public Curso findByNombre(String nombre);
	
}
