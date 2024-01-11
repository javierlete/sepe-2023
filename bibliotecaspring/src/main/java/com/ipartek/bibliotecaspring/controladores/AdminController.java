package com.ipartek.bibliotecaspring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.bibliotecaspring.entidades.Libro;
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
	public String formulario(Libro libro) {
		return "admin/libro";
	}

	@GetMapping("/libro/{id}")
	public String formulario(Model modelo, @PathVariable Long id) {
		modelo.addAttribute("libro", servicio.verLibroBiblioteca(id));
		return "admin/libro";
	}

	@PostMapping("/libro")
	public String guardar(Libro libro) {
		if(libro.getPrestatario().getId() == 0) {
			libro.setPrestatario(null);
		}
		
		if (libro.getId() != null) {
			servicio.modificarLibro(libro);
		} else {
			servicio.altaLibro(libro);
		}

		return "redirect:/admin/index";
	}

	@GetMapping("/libro/borrar/{id}")
	public String borrar(@PathVariable Long id) {
		servicio.bajaLibro(id);

		return "redirect:/admin/index";
	}

	@GetMapping("/libro/devolver/{id}")
	@ResponseBody
	public String devolver(@PathVariable Long id) {
		return "DEVOLVER ID: " + id;
	}
}
