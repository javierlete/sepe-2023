package com.ipartek.bibliotecaspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ipartek.bibliotecaspring.entidades.Libro;
import com.ipartek.bibliotecaspring.repositorios.LibroRepository;

@Primary
@Service
public class AdminServicioImpl extends UsuarioServicioImpl implements AdminServicio {

	@Autowired
	private LibroRepository repoLibro;
	
	@Override
	public Libro altaLibro(Libro libro) {
		libro.setId(null);
		return repoLibro.save(libro);
	}

	@Override
	public Libro modificarLibro(Libro libro) {
		return repoLibro.save(libro);
	}

	@Override
	public void bajaLibro(Long id) {
		repoLibro.deleteById(id);
	}

	@Override
	public void devolverLibro(Long id) {
		Libro libro = repoLibro.findById(id).orElse(null);
		
		libro.setPrestatario(null);
		
		repoLibro.save(libro);
	}

	@Override
	public Iterable<Libro> listadoLibrosCompleto() {
		return repoLibro.findAll();
	}
	
}
