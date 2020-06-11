package com.pio2.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.pio2.spring.entidades.Curso;
import com.pio2.spring.repositorios.CursoRepository;

@Primary
@Service("cursoServiceDB")
public class CursoServiceDB implements CursoService {

	@Autowired
	CursoRepository repositorio;
	
	@Override
	public Curso add(Curso e) {
		return repositorio.save(e);
	}

	@Override
	public List<Curso> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Curso findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public Curso edit(Curso e) {
		return repositorio.save(e);
	}

	@Override
	public Curso findByNombre(String nombre) {
		return repositorio.findByNombre(nombre);
	}

}
