package com.biblioteca.rest;

import static com.biblioteca.mockups.Mockups.*;

import com.biblioteca.entidades.Persona;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/anonimo")
public class AnonimoRest {
	@GET
	@Path("/login")
	public Persona login(@QueryParam("email") String email, @QueryParam("password") String password) {
		Persona persona = personas.get(email);
		
		if(persona == null || !persona.getPassword().equals(password)) {
			throw new NotFoundException();
		}
		
		return persona;
	}
}
