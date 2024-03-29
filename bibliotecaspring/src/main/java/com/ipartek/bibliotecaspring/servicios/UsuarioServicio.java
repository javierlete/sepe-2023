package com.ipartek.bibliotecaspring.servicios;

import java.util.Set;

import com.ipartek.bibliotecaspring.entidades.Libro;

public interface UsuarioServicio {
	Set<Libro> listarLibrosBiblioteca();
	Libro verLibroBiblioteca(Long id);
	
	void agregarPrestamo(String email, Long idLibro);
	void agregarPrestamo(Long idPersona, Long idLibro);
	Set<Libro> listarPrestamos(Long idPersona);
	Set<Libro> listarPrestamos(String email);
}
