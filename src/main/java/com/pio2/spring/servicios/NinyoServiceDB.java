package com.pio2.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.pio2.spring.entidades.Ninyo;
import com.pio2.spring.repositorios.NinyoRepository;

@Primary
@Service("ninyoServiceDB")
public class NinyoServiceDB implements NinyoService{

	@Autowired
	NinyoRepository repositorio;
	
	@Override
	public Ninyo add(Ninyo e) {
		return repositorio.save(e);
	}

	@Override
	public List<Ninyo> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Ninyo findById(long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public Ninyo findByDni(String dni) {
		return repositorio.findByDni(dni);
	}

	@Override
	public Ninyo edit(Ninyo e) {
		return repositorio.save(e);
	}
	
	public void delete(Ninyo e) {
		repositorio.delete(e);
	}

}
