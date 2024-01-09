package com.ipartek.bibliotecaspring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.bibliotecaspring.entidades.Persona;

@RepositoryRestResource(collectionResourceRel = "personas", path = "personas")
public interface PersonaRepository extends CrudRepository<Persona, Long>, PagingAndSortingRepository<Persona, Long> {
	Persona findByEmail(String email);
}
