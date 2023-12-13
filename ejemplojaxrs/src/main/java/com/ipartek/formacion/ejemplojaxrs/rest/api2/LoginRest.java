package com.ipartek.formacion.ejemplojaxrs.rest.api2;

import com.ipartek.formacion.ejemplojaxrs.entidades.Usuario;
import com.ipartek.formacion.ejemplojaxrs.global.Globales;
import com.ipartek.formacion.ejemplojaxrs.servicios.LoginServicio;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginRest {
	private LoginServicio login = Globales.FABRICA.getServicioLogin();
	
	@GET
	public Usuario login(@QueryParam("email") String email, @QueryParam("password") String password) {
		return login.validarUsuario(email, password);
	}
}
