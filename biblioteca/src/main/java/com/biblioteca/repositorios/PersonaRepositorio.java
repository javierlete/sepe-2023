package com.biblioteca.repositorios;

import java.util.Optional;

import com.biblioteca.entidades.Persona;

public interface PersonaRepositorio extends Repositorio<Persona> {
	Optional<Persona> obtenerPorEmail(String email);
}
