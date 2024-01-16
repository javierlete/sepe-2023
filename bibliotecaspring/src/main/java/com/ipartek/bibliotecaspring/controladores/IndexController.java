package com.ipartek.bibliotecaspring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.bibliotecaspring.servicios.UsuarioServicio;

@Controller
public class IndexController {
	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping({"/", "/index"})
	public String index(Model modelo) {
		modelo.addAttribute("libros", servicio.listarLibrosBiblioteca());
		
		return "index";
	}
	
	@GetMapping("/prestados")
	public String prestados(Model modelo, Authentication auth) {
		modelo.addAttribute("prestados", servicio.listarPrestamos(auth.getName()));
		return index(modelo);
	}
	
	@GetMapping("/detalle")
	public String detalle(Model modelo, Long id) {
		modelo.addAttribute("libro", servicio.verLibroBiblioteca(id));
		
		return "detalle";
	}
	
	@GetMapping("/reserva")
	public String reserva(Long id, Authentication auth) {
		String email = auth.getName();
		servicio.agregarPrestamo(email, id);
		return "redirect:/prestados";
	}
}
