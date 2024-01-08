package com.biblioteca.servicios;

import java.util.Set;

import com.biblioteca.entidades.Libro;
import com.biblioteca.entidades.Persona;
import com.biblioteca.fabrica.Fabrica;
import com.biblioteca.repositorios.LibroRepositorio;

import lombok.extern.java.Log;

@Log
public class UsuarioServicioImpl implements UsuarioServicio {
	private LibroRepositorio repo = Fabrica.fabrica.obtenerObjeto(LibroRepositorio.class);
	
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

	@Override
	public void agregarPrestamo(Persona persona, Libro libro) {
		libro.setPrestatario(persona);
		persona.getLibros().add(libro);
		
		// TODO Persistencia
	}

	@Override
	public Set<Libro> listarPrestamos(Persona persona) {
		// TODO Persistencia
		
		return persona.getLibros();
	}

}
