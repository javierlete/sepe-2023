package com.ipartek.bibliotecaspring.repositorios;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.bibliotecaspring.entidades.Libro;

@RepositoryRestResource(collectionResourceRel = "libros", path = "libros")
public interface LibroRepository extends CrudRepository<Libro, Long>, PagingAndSortingRepository<Libro, Long> {
	@Query("from Libro l where l.titulo like '%' || :texto || '%'")
	Set<Libro> buscarPorTitulo(String texto);

	Set<Libro> findByTituloContains(String texto);
	
	@Query(nativeQuery = true, value = "SELECT * FROM libros WHERE titulo LIKE CONCAT('%', CONCAT(:texto, '%'))")
	Set<Libro> buscarPorTituloNativeQuery(String texto);
}
