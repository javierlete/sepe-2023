package com.biblioteca.servicios;

import java.util.HashSet;
import java.util.Set;

import com.biblioteca.entidades.Libro;
import com.biblioteca.mockups.Mockups;

import lombok.extern.java.Log;

@Log
public class UsuarioServicioImpl implements UsuarioServicio {
	@Override
	public Set<Libro> listarLibrosBiblioteca() {
		log.info("Se han pedido todos los libros");

		var libros = new HashSet<>(Mockups.libros.values());

		log.finest(libros.toString());

		return libros;
	}

	@Override
	public Libro verLibroBiblioteca(Long id) {
		log.info("Se ha pedido el libro cuyo id es: " + id);

		Libro libro = Mockups.libros.get(id);

		log.fine(libro != null ? libro.toString() : "No encontrado");

		return libro;
	}
}
