package com.pio2.spring.servicios;

import java.util.List;

import com.pio2.spring.entidades.Monitor;

public interface MonitorService {
	
	public Monitor add(Monitor e);
	public List<Monitor> findAll();
	public Monitor findById(long id);
	public Monitor edit(Monitor e);
	public Monitor findByDni(String dni);
	
}
