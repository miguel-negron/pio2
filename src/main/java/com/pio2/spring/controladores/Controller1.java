package com.pio2.spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pio2.spring.repositorios.NinyoRepository;
import com.pio2.spring.servicios.NinyoServiceDB;

import antlr.collections.List;

@Controller
public class Controller1 {
	
	@Autowired
	NinyoServiceDB servicio;
	
	
	@GetMapping("/")
	public String controller1(Model model) {
		model.addAttribute("listaNinyos", servicio.findAll());
		return "index";
	}
	
	//@GetMapping("/ninyo/new")
	public String crearNinyo(Model model) {
		return "form";
	}
}
