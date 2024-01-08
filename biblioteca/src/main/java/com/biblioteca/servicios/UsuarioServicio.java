package com.biblioteca.servicios;

import java.util.Set;

import com.biblioteca.entidades.Libro;
import com.biblioteca.entidades.Persona;

public interface UsuarioServicio {
	Set<Libro> listarLibrosBiblioteca();
	Libro verLibroBiblioteca(Long id);
	
	void agregarPrestamo(Persona persona, Libro libro);
	Set<Libro> listarPrestamos(Persona persona);
}
