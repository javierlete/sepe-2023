package com.ipartek.bibliotecaspring.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.bibliotecaspring.entidades.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {
	Persona findByEmail(String email);
}
