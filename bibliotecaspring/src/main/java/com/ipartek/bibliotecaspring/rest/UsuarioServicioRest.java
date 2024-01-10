package com.ipartek.bibliotecaspring.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.bibliotecaspring.entidades.Libro;
import com.ipartek.bibliotecaspring.servicios.UsuarioServicio;

@RestController
@RequestMapping("/api/v1/negocio/usuario")
public class UsuarioServicioRest {
	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping("/listar-libros-biblioteca")
	public Set<Libro> listarLibrosBiblioteca() {
		return servicio.listarLibrosBiblioteca();
	}
	
	@GetMapping("/ver-libro-biblioteca")
	public Libro verLibroBiblioteca(Long id) {
		Libro libro = servicio.verLibroBiblioteca(id);
		
		if(libro == null) {
			throw new ResourceNotFoundException("No se ha encontrado el libro");
		}
		
		return libro;
	}
	
	@GetMapping("/agregar-prestamo")
	public void agregarPrestamo(Long idPersona, Long idLibro) {
		servicio.agregarPrestamo(idPersona, idLibro);
	}

	@GetMapping("/listar-prestamos")
	public Set<Libro> listarPrestamos(Long idPersona) {
		return servicio.listarPrestamos(idPersona);
	}
}
