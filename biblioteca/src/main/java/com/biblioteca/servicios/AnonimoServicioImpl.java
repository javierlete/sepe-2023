package com.biblioteca.servicios;

import java.util.Optional;

import com.biblioteca.entidades.Persona;
import com.biblioteca.mockups.Mockups;

import lombok.extern.java.Log;

@Log
public class AnonimoServicioImpl implements AnonimoServicio {

	@Override
	public Persona iniciarSesion(String email, String password) {
		Optional<Persona> persona = Mockups.personas.values().stream().filter(p -> p.getEmail().equals(email)).findFirst();
		
		log.info("LOGIN: " + email);
		
		if(persona.isEmpty() || !persona.get().getPassword().equals(password)) {
			log.warning("LOGIN INCORRECTO: " + email);
			return null;
		}
		
		log.info("LOGIN CORRECTO: " + email);
		
		return persona.get();
	}
}
