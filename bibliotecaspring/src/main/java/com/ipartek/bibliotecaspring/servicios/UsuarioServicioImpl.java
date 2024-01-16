package com.ipartek.bibliotecaspring.servicios;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.bibliotecaspring.entidades.Libro;
import com.ipartek.bibliotecaspring.entidades.Persona;
import com.ipartek.bibliotecaspring.repositorios.LibroRepository;
import com.ipartek.bibliotecaspring.repositorios.PersonaRepository;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	private LibroRepository repoLibro;
	
	@Autowired
	private PersonaRepository repoPersona;
	
	@Override
	public Set<Libro> listarLibrosBiblioteca() {
		var libros = new HashSet<Libro>();
		repoLibro.findAll().forEach(l -> libros.add(l));
		
		return libros;
	}

	@Override
	public Libro verLibroBiblioteca(Long id) {
		return repoLibro.findById(id).orElse(null);
	}

	@Override
	public void agregarPrestamo(Long idPersona, Long idLibro) {
		Libro libro = repoLibro.findById(idLibro).orElse(null);
		Persona persona = repoPersona.findById(idPersona).orElse(null);
				
		libro.setPrestatario(persona);
		
		repoLibro.save(libro);
	}

	@Override
	public void agregarPrestamo(String email, Long idLibro) {
		Libro libro = repoLibro.findById(idLibro).orElse(null);
		Persona persona = repoPersona.findByEmail(email);
				
		libro.setPrestatario(persona);
		
		repoLibro.save(libro);
	}

	@Override
	public Set<Libro> listarPrestamos(Long idPersona) {
		return repoLibro.buscarPorPrestatario(idPersona);
	}
	
	@Override
	public Set<Libro> listarPrestamos(String email) {
		return repoLibro.buscarPorPrestatario(email);
	}
}
