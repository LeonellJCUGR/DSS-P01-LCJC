package com.dss.p1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Página de inicio (logoutSuccessUrl("/") y el icono de inicio apuntan aquí)
@Controller
public class HomeController {
	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}
}
