package com.ipartek.bibliotecaspring.servicios;

import com.ipartek.bibliotecaspring.entidades.Libro;

public interface AdminServicio extends UsuarioServicio {
	Libro altaLibro(Libro libro);
	Libro modificarLibro(Libro libro);
	void bajaLibro(Long id);
	void devolverLibro(Long id);
}
