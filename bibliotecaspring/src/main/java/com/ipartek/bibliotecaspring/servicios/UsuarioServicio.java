package com.ipartek.bibliotecaspring.servicios;

import java.util.Set;

import com.ipartek.bibliotecaspring.entidades.Libro;

public interface UsuarioServicio {
	Set<Libro> listarLibrosBiblioteca();
	Libro verLibroBiblioteca(Long id);
	
	void agregarPrestamo(Long idPersona, Long idLibro);
	Set<Libro> listarPrestamos(Long idPersona);
}
