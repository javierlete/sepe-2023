package com.biblioteca.rest;

import java.util.Set;

import com.biblioteca.entidades.Libro;
import com.biblioteca.servicios.UsuarioServicio;
import com.biblioteca.servicios.UsuarioServicioImpl;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/usuario")
public class UsuarioRest {
	
	private static final UsuarioServicio servicio = new UsuarioServicioImpl();
	
	@GET
	@Path("/libros")
	public Set<Libro> obtenerLibros() {
		return servicio.listarLibrosBiblioteca();
	}
	
	@GET
	@Path("/libros/{id}")
	public Libro buscarLibro(@PathParam("id") Long id) {
		Libro libro = servicio.verLibroBiblioteca(id);
		
		if(libro == null) {
			throw new NotFoundException("No se ha encontrado el libro " + id);
		}
		
		return libro;
	}
}
