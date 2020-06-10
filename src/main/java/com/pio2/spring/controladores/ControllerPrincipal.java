package com.pio2.spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pio2.spring.entidades.Monitor;
import com.pio2.spring.repositorios.MonitorRepository;
import com.pio2.spring.servicios.NinyoServiceDB;

@Controller
public class ControllerPrincipal {
	
	@Autowired
	NinyoServiceDB servicio;
	
	@GetMapping("/")
	public String controller1(Model model) {
		model.addAttribute("listaNinyos", servicio.findAll());
		return "index";
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
