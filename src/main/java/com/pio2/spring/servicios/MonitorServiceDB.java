package com.pio2.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.pio2.spring.entidades.Monitor;
import com.pio2.spring.repositorios.MonitorRepository;

@Primary
@Service("monitorServiceDB")
public class MonitorServiceDB implements MonitorService {
	
	@Autowired
	MonitorRepository repository;

	@Override
	public Monitor add(Monitor e) {
		return repository.save(e);
	}

	@Override
	public List<Monitor> findAll() {
		return repository.findAll();
	}

	@Override
	public Monitor findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Monitor edit(Monitor e) {
		return repository.save(e);
	}
	
	public void delete(Monitor e) {
		repository.delete(e);
	}

}
