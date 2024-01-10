package com.ipartek.bibliotecaspring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.bibliotecaspring.entidades.Persona;
import com.ipartek.bibliotecaspring.servicios.AnonimoServicio;

@RestController
@RequestMapping("/api/v1/negocio/anonimo")
public class AnonimoServicioRest {

	@Autowired
	private AnonimoServicio servicio;
	
	@GetMapping("/iniciar-sesion")
	public Persona iniciarSesion(String email, String password) {
		return servicio.iniciarSesion(email, password);
	}
}
