package com.pio2.spring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pio2.spring.entidades.Alergia;

public interface AlergiaRepository extends JpaRepository<Alergia, Long> {

	public Alergia findByNombre(String nombre);
}
