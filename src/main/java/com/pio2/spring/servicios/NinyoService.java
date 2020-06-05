package com.pio2.spring.servicios;

import java.util.List;

import com.pio2.spring.entidades.Ninyo;

public interface NinyoService {

	public Ninyo add(Ninyo e);
	public List<Ninyo> findAll();
	public Ninyo findById(long id);
	public Ninyo edit(Ninyo e);
}
