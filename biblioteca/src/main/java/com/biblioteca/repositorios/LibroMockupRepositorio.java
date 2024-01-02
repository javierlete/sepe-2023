package com.biblioteca.repositorios;

import java.util.HashSet;
import java.util.Set;

import com.biblioteca.entidades.Libro;
import com.biblioteca.mockups.Mockups;

public class LibroMockupRepositorio implements LibroRepositorio {

	@Override
	public Set<Libro> obtenerTodos() {
		return new HashSet<>(Mockups.libros.values());
	}

	@Override
	public Libro obtenerPorId(Long id) {
		return Mockups.libros.get(id);
	}
}
