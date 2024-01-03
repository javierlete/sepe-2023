package com.biblioteca.servicios;

import java.util.Optional;

import com.biblioteca.entidades.Persona;
import com.biblioteca.fabrica.Fabrica;
import com.biblioteca.repositorios.PersonaRepositorio;

import lombok.extern.java.Log;

@Log
public class AnonimoServicioImpl implements AnonimoServicio {
	private PersonaRepositorio repo = Fabrica.fabrica.obtenerObjeto(PersonaRepositorio.class);
	
	@Override
	public Persona iniciarSesion(String email, String password) {
		Optional<Persona> persona = repo.obtenerPorEmail(email);
		
		log.info("LOGIN: " + email);
		
		if(persona.isEmpty() || !persona.get().getPassword().equals(password)) {
			log.warning("LOGIN INCORRECTO: " + email);
			return null;
		}
		
		log.info("LOGIN CORRECTO: " + email);
		
		return persona.get();
	}
}
