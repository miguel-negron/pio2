package com.pio2.spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pio2.spring.entidades.Monitor;
import com.pio2.spring.entidades.Ninyo;
import com.pio2.spring.repositorios.CursoRepository;
import com.pio2.spring.repositorios.MonitorRepository;
import com.pio2.spring.servicios.CursoServiceDB;
import com.pio2.spring.servicios.NinyoService;
import com.pio2.spring.servicios.NinyoServiceDB;

@Controller
public class ControllerNinyo {
	
	@Autowired
	NinyoServiceDB servicioNinyo;
	
	@Autowired
	CursoRepository serviceCurso;

	@GetMapping("/ninyos")
	public String controller1(Model model) {
		model.addAttribute("listaNinyos", servicioNinyo.findAll());
		return "indexNinyos";
	}
	
	@GetMapping("/ninyo/new")
	public String controllerAnyadirMonitor(Model model) {
		model.addAttribute("newNinyo", new Ninyo());
		model.addAttribute("cursos", serviceCurso.findAll());
		return "formNinyo";
	}
	
	@PostMapping("/ninyo/new/submit")
	public String nuevoEmpleadoSubmit(/*@Valid*/ @ModelAttribute("newNinyo") Ninyo ninyo,
										BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "formNinyo";
		} else {
			servicioNinyo.add(ninyo);
			return "redirect:/";
		}

	}
}