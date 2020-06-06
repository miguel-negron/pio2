package com.pio2.spring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pio2.spring.entidades.Monitor;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {

}
