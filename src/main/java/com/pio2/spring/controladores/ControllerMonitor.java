package com.pio2.spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pio2.spring.entidades.Monitor;
import com.pio2.spring.repositorios.CursoRepository;
import com.pio2.spring.repositorios.MonitorRepository;
import com.pio2.spring.servicios.CursoServiceDB;
import com.pio2.spring.servicios.MonitorServiceDB;

@Controller
public class ControllerMonitor {

	@Autowired
	MonitorServiceDB serviceMonitorDB;
	
	@Autowired
	CursoServiceDB serviceCursoDB;

	@GetMapping("/monitores")
	public String controllerListaMonitores(Model model) {
		model.addAttribute("listaMonitores", serviceMonitorDB.findAll());
		return "indexMonitores";
	}
	
	@GetMapping("/monitor/new")
	public String controllerAnyadirMonitor(Model model) {
		
		model.addAttribute("monitorForm", new Monitor());
		model.addAttribute("cursos", serviceCursoDB.findAll());
		
		return "formMonitor";
	}
	
	@PostMapping("/monitor/new/submit")
	public String nuevoEmpleadoSubmit(@Validated @ModelAttribute("empleadoForm") Monitor nuevoMonitor,
										BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "formMonitor";
		} else {
			serviceMonitorDB.add(nuevoMonitor);
			return "redirect:/monitores";
		}

	}

	
}
