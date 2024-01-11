package com.ipartek.bibliotecaspring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.bibliotecaspring.servicios.AdminServicio;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminServicio servicio;
	
	@GetMapping("/index")
	public String index(Model modelo) {
		modelo.addAttribute("libros", servicio.listarLibrosBiblioteca());
		
		return "admin/index";
	}

	@GetMapping("/libro")
	public String formulario() {
		return "libro";
	}
	
	@GetMapping("/libro/{id}")
	@ResponseBody
	public String formulario(@PathVariable Long id) {
		return "ID: " + id;
	}

	@GetMapping("/libro/borrar/{id}")
	@ResponseBody
	public String borrar(@PathVariable Long id) {
		return "BORRAR ID: " + id;
	}
	
	@GetMapping("/libro/devolver/{id}")
	@ResponseBody
	public String devolver(@PathVariable Long id) {
		return "DEVOLVER ID: " + id;
	}
}
