package com.biblioteca.servicios;

import java.util.Set;

import com.biblioteca.entidades.Libro;

public interface UsuarioServicio {
	Set<Libro> listarLibrosBiblioteca();
	Libro verLibroBiblioteca(Long id);
}
