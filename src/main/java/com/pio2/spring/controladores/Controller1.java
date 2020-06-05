package com.pio2.spring.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import antlr.collections.List;

@Controller
public class Controller1 {
	
	List variable = null;
	
	@GetMapping("/")
	public String controller1(Model model) {
		model.addAttribute("listaNinyos", variable);
		return "index";
	}
}
