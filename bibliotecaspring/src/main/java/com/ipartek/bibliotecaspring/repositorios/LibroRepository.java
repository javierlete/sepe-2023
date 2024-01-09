package com.ipartek.bibliotecaspring.repositorios;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.bibliotecaspring.entidades.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long> {
	@Query("from Libro l where l.titulo like '%' || :texto || '%'")
	Set<Libro> buscarPorTitulo(String texto);

	Set<Libro> findByTituloContains(String texto);
	
	
}
