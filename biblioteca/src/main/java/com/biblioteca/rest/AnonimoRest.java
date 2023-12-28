package com.biblioteca.rest;

import com.biblioteca.entidades.Persona;
import com.biblioteca.servicios.AnonimoServicio;
import com.biblioteca.servicios.AnonimoServicioImpl;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/anonimo")
public class AnonimoRest {
	
	private static final AnonimoServicio servicio = new AnonimoServicioImpl();
	
	@GET
	@Path("/login")
	public Persona login(@QueryParam("email") String email, @QueryParam("password") String password) {
		Persona persona = servicio.iniciarSesion(email, password);
		
		if(persona == null) {
			throw new NotFoundException("El usuario o la password proporcionada son incorrectos");
		}
		
		return persona;
	}
}
