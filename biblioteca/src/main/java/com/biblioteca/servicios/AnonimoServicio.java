package com.biblioteca.servicios;

import com.biblioteca.entidades.Persona;

public interface AnonimoServicio {
	Persona iniciarSesion(String email, String password);
}
