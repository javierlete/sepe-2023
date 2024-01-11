package com.ipartek.bibliotecaspring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.bibliotecaspring.servicios.UsuarioServicio;

@Controller
public class IndexController {
	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("libros", servicio.listarLibrosBiblioteca());
		
		return "index";
	}
}
