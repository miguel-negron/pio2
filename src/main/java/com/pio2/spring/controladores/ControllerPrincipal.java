package com.pio2.spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pio2.spring.servicios.AlergiaServiceDB;
import com.pio2.spring.servicios.CursoServiceDB;
import com.pio2.spring.servicios.MonitorServiceDB;
import com.pio2.spring.servicios.NinyoServiceDB;

@Controller
public class ControllerPrincipal {

	@Autowired
	NinyoServiceDB servicioNinyo;

	@Autowired
	MonitorServiceDB servicioMonitor;

	@Autowired
	CursoServiceDB servicioCurso;
	
	@Autowired
	AlergiaServiceDB servicioAlergia;
	

	@GetMapping("/")
	public String controller1(Model model) {
		model.addAttribute("listaNinyos", servicioNinyo.findAll());
		model.addAttribute("listaMonitores", servicioMonitor.findAll());
		model.addAttribute("listaCursos", servicioCurso.findAll());

		return "index";
	}

	@GetMapping("/login")
	public String log(Model model) {
		model.addAttribute("listaNinyos", servicioNinyo.findAll());
		return "login";
	}

	@GetMapping("/alergias")
	public String goToAlergias(Model model) {
		model.addAttribute("listaAlergias", servicioAlergia.findAll());
		return "indexAlergias";
	}

	/* 
	@GetMapping("/ninyo/new")
	public String crearNinyo(Model model) {
		return "form";
	}
	*/
}
