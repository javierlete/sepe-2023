package com.ipartek.bibliotecaspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.bibliotecaspring.entidades.Persona;
import com.ipartek.bibliotecaspring.repositorios.PersonaRepository;

@Service
public class AnonimoServicioImpl implements AnonimoServicio {

	@Autowired
	private PersonaRepository repo;

	@Override
	public Persona iniciarSesion(String email, String password) {
		Persona persona = repo.findByEmail(email);

		if(persona == null || !persona.getPassword().equals(password)) {
			return null;
		}
		
		return persona;
	}

}
