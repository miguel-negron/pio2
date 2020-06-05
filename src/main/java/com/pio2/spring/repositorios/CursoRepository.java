package com.pio2.spring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pio2.spring.entidades.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
