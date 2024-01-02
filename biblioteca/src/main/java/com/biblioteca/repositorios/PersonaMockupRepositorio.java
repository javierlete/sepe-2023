package com.biblioteca.repositorios;

import java.util.Optional;

import com.biblioteca.entidades.Persona;
import com.biblioteca.mockups.Mockups;

import lombok.extern.java.Log;

@Log
public class PersonaMockupRepositorio implements PersonaRepositorio {

	@Override
	public Optional<Persona> obtenerPorEmail(String email) {
		log.info("petición en la capa de repositorios de la persona con email " + email);
		return Mockups.personas.values().stream().filter(p -> p.getEmail().equals(email)).findFirst();
	}

}
