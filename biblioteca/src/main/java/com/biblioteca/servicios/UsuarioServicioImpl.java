package com.biblioteca.servicios;

import java.util.Set;

import com.biblioteca.entidades.Libro;
import com.biblioteca.repositorios.LibroMockupRepositorio;
import com.biblioteca.repositorios.LibroRepositorio;

import lombok.extern.java.Log;

@Log
public class UsuarioServicioImpl implements UsuarioServicio {
	private LibroRepositorio repo = new LibroMockupRepositorio();
	
	@Override
	public Set<Libro> listarLibrosBiblioteca() {
		log.info("Se han pedido todos los libros");

		var libros = repo.obtenerTodos();

		log.finest(libros.toString());

		return libros;
	}

	@Override
	public Libro verLibroBiblioteca(Long id) {
		log.info("Se ha pedido el libro cuyo id es: " + id);

		Libro libro = repo.obtenerPorId(id);

		log.fine(libro != null ? libro.toString() : "No encontrado");

		return libro;
	}
}
