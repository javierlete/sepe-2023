package com.biblioteca.rest;

import static com.biblioteca.mockups.Mockups.*;

import java.util.HashSet;
import java.util.Set;

import com.biblioteca.entidades.Libro;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/usuario")
public class UsuarioRest {
	@GET
	@Path("/libros")
	public Set<Libro> obtenerLibros() {
		return new HashSet<>(libros.values());
	}
	
	@GET
	@Path("/libros/{id}")
	public Libro buscarLibro(@PathParam("id") Long id) {
		return libros.get(id);
	}
}
