package com.pio2.spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pio2.spring.repositorios.CursoRepository;
import com.pio2.spring.repositorios.MonitorRepository;
import com.pio2.spring.repositorios.NinyoRepository;
import com.pio2.spring.servicios.NinyoServiceDB;

import antlr.collections.List;

@Controller
public class ControllerPrincipal {
	
	@Autowired
	NinyoServiceDB servicio;
	
	@Autowired
	MonitorRepository repositorioMonitores;

	
	@GetMapping("/")
	public String controller1(Model model) {
		model.addAttribute("listaNinyos", servicio.findAll());
		return "index";
	}
	
	@GetMapping("/monitores")
	public String controllerListaMonitores(Model model) {
		model.addAttribute("listaMonitores", repositorioMonitores.findAll());
		return "indexMonitores";
	}
	
	@GetMapping("/login")
	public String log(Model model) {
		model.addAttribute("listaNinyos", servicio.findAll());
		return "login";
	}
	
	//@GetMapping("/ninyo/new")
	public String crearNinyo(Model model) {
		return "form";
	}
}
