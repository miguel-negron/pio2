package com.pio2.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.pio2.spring.entidades.Alergia;
import com.pio2.spring.repositorios.AlergiaRepository;

@Primary
@Service("AlergiaServiceDB")
public class AlergiaServiceDB implements AlergiaService {

	@Autowired
	AlergiaRepository repositorio;
	
	@Override
	public Alergia add(Alergia e) {
		return repositorio.save(e);
	}

	@Override
	public List<Alergia> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Alergia findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public Alergia edit(Alergia e) {
		return repositorio.save(e);
	}

	@Override
	public Alergia findByNombre(String nombre) {
		return repositorio.findByNombre(nombre);
	}

}
