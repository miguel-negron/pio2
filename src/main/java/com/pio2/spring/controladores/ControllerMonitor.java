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

@Controller
public class ControllerMonitor {

	//TODO cambiar a servicio
	@Autowired
	MonitorRepository repositorioMonitores;

	@GetMapping("/monitores")
	public String controllerListaMonitores(Model model) {
		model.addAttribute("listaMonitores", repositorioMonitores.findAll());
		return "indexMonitores";
	}
	
	@GetMapping("/monitor/new")
	public String controllerAnyadirMonitor(Model model) {
		model.addAttribute("monitorForm", new Monitor());
		return "formMonitor";
	}
	
	@PostMapping("/monitor/new/submit")
	public String nuevoEmpleadoSubmit(/*@Valid*/ @ModelAttribute("empleadoForm") Monitor nuevoMonitor,
										BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "formMonitor";
		} else {
			repositorioMonitores.save(nuevoMonitor);
			return "redirect:/monitores";
		}

	}

	
}
